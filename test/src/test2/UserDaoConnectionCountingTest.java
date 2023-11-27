package test2;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoConnectionCountingTest {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
//		ApplicationContext context = 
//				new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		ApplicationContext context = 
				new GenericXmlApplicationContext("applicationContext.xml");
	
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		CountingConnectionMaker ccm = context.getBean("connectionMaker", 
				CountingConnectionMaker.class);
		
		System.out.println(" Connection counter : "+ccm.getCounter());
		
		
	}
}
