import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appleyk.Application;
import com.appleyk.node.User;
import com.appleyk.relation.LikeRelation;
import com.appleyk.repository.LikeRelationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class LikeRelationTest {

	@Autowired
	private LikeRelationRepository likeRepository;


	/**
	 * 在已有的两个节点的基础上创建关系
	 */
	@Test
	public void createLikeRelation() throws Exception {

		LikeRelation like = new LikeRelation();

		/**
		 * 节点 == 刘大壮
		 */
		User startNode = new User();
		startNode.setUid(1001L);

		/**
		 * 节点 == 马晓丽
		 */
		User endNode = new User();
		endNode.setUid(1002L);

		like.setStartNode(startNode);
		like.setEndNode(endNode);

		like.setRelationID(520);
		like.setSince(2018);
		like.setReason("晓丽是女神");

		List<LikeRelation> likes = likeRepository.createLikes(startNode.getUid(), 
				endNode.getUid(), like.getRelationID(),like.getSince(),like.getReason());	
		
		/**
		 * 遍历创建的关系
		 */
		for (LikeRelation likeRelation : likes) {
			User sNode = (User) likeRelation.getStartNode();
			User eNode = (User) likeRelation.getEndNode();
			System.out.println(sNode.getName() + "--喜欢-->" + eNode.getName());
		}
	}
	
	
	/**
	 * 创建节点并创建关系
	 */
	@Test
	public void createLikes(){
		LikeRelation like = new LikeRelation();

		/**
		 * 节点 == 韩梅梅
		 */
		User startNode = new User();
		startNode.setUid(1003L);
		startNode.setName("韩梅梅");
		startNode.setAge(18);
		startNode.setSex("女");
		startNode.addHobby("看书");
		startNode.addHobby("逛街");
		
		/**
		 * 节点 == 李晓明
		 */
		User endNode = new User();
		endNode.setUid(1004L);
		endNode.setName("李晓明");
		endNode.setAge(19);
		endNode.setSex("男");
		endNode.addHobby("游戏");
		endNode.addHobby("音乐");
		endNode.addHobby("篮球");
		
		like.setStartNode(startNode);
		like.setEndNode(endNode);

		like.setRelationID(520);
		like.setSince(2018);
		like.setReason("晓明好帅啊");
		
		LikeRelation relation = likeRepository.save(like);
		System.out.println(relation.getStartNode().getName()+"-->喜欢--"+
		relation.getEndNode().getName()+",理由："+relation.getReason());
		
	}
	
	/**
	 * 查询关系
	 */
	@Test
	public void findLikes(){
		List<LikeRelation> likes = likeRepository.getLikes();
		for (LikeRelation likeRelation : likes) {
			User sNode = (User) likeRelation.getStartNode();
			User eNode = (User) likeRelation.getEndNode();
			System.out.println(sNode.getName() + "--喜欢-->" + eNode.getName()
			+" == reason: "+likeRelation.getReason());
		}
	}

}
