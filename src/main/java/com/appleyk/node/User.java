package com.appleyk.node;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.appleyk.relation.LikeRelation;

@NodeEntity
public class User extends BaseNode{

	/**
	 * 用户ID
	 */
	private Long uid;
	
	/**
	 * 用户性别
	 */
	private String sex;
	
	/**
	 * 用户年龄
	 */
	private Integer age;
	
	/**
	 * 兴趣爱好
	 */
	private List<String> hobbies;
	
	/**
	 * 添加关系喜欢，方向为  ->，表明当前节点是startNode
	 */
	@Relationship(type="Like",direction = Relationship.OUTGOING)
	private List<LikeRelation> likes;
	

	
	public User(){
		hobbies = new ArrayList<>();
		likes = new ArrayList<>();
	}
	
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	public void addHobby(String hobby){
		hobbies.add(hobby);
	}
		
	public void addLikes(User user,String reason,Integer since,Integer relationID){
		LikeRelation like = new LikeRelation(this, user, reason, since, relationID);
		this.likes.add(like);
	}
}
