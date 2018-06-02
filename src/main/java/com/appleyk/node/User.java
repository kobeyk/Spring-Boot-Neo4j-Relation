package com.appleyk.node;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;

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

	
	public User(){
		hobbies = new ArrayList<>();
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
		
}
