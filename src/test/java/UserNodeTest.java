import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appleyk.Application;
import com.appleyk.node.User;
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
