import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appleyk.Application;
import com.appleyk.node.User;
import com.appleyk.relation.LikeRelation;
import com.appleyk.repository.UserRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class) 
public class UserNodeTest {

	
	@Autowired
	UserRepository userRepository;
	
	/**
	 * 创建用户节点 【批量创建】 
	 * @throws Exception
	 */
	@Test
	public void createUser() throws Exception{	
		
		List<User> userNodes = new ArrayList<>();		
		User userNode1 = new User();
		userNode1.setUid(1001L);
		userNode1.setName("刘大壮");
		userNode1.setAge(22);
		userNode1.setSex("男");
		userNode1.addHobby("游戏");
		userNode1.addHobby("睡觉");
		userNode1.addHobby("撸串");
		
		User userNode2 = new User();
		userNode2.setUid(1002L);
		userNode2.setName("马晓丽");
		userNode2.setAge(17);
		userNode2.setSex("女");
		userNode2.addHobby("逛街");
		userNode2.addHobby("美食");
		userNode2.addHobby("化妆");
		
		userNodes.add(userNode1);
		userNodes.add(userNode2);			
		Iterable<User> iterable = userRepository.save(userNodes);		
		for (User user : iterable) {
			System.out.println("创建节点：【"+user.getName()+"】成功！");
		}
		
	}
	
	/**
	 * 创建节点  == 内置关系
	 */
	@Test
	public void createNodeandRelation(){
			
		User startNode = new User();
		startNode.setUid(1011L);
		startNode.setName("刘泽");
		startNode.setAge(22);
		startNode.setSex("男");
		startNode.addHobby("游戏");
		startNode.addHobby("睡觉");
		
		User endNode1 = new User();
		endNode1.setUid(1012L);
		endNode1.setName("张婷");
		endNode1.setAge(17);
		endNode1.setSex("女");
		endNode1.addHobby("逛街");
		endNode1.addHobby("美食");
		endNode1.addHobby("化妆");
		
		User endNode2 = new User();
		endNode2.setUid(1013L);
		endNode2.setName("林志玲");
		endNode2.setAge(45);
		endNode2.setSex("女");
		endNode2.addHobby("逛街");
		endNode2.addHobby("美食");
		endNode2.addHobby("化妆");
		
		startNode.addLikes(endNode1, "心地善良，人美", 2015,521 );
		startNode.addLikes(endNode2, "女神姐姐", 2011, 520);
		
		User userNode = userRepository.save(startNode);
		System.out.println("节点"+userNode.getName()+"创建成功！");
		
	}
	
	/**
	 * 根据用户的name查询user节点列表
	 */
	@Test
	public void findUserByName(){
		List<User> users = userRepository.getUsersByName("刘大壮");
		System.out.println("共查出来节点有："+users.size()+"个");
	}
	
	/**
	 * 根据用户的年龄查询user节点【年龄大于18】
	 */
	@Test
	public void findUserByAge(){
		List<User> users = userRepository.getUsers(18);
		for (User user : users) {
			System.out.println("共查出来节点有："+users.size()+"个, == "+user.getName());
		}
	}
}
