package tobyspring;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/**/applicationContext.xml")
@DirtiesContext
public class UserDaoTest {
	
//	@Autowired
//	private ApplicationContext context; 
	
	@Autowired
	UserDao dao;

	private User user1;
	private User user2;
	private User user3;
	
	@Before
	public void setUp() {
//		this.dao = this.context.getBean("userDao", UserDao.class);
		this.user1 = new User("gyumee", "박성철", "springnol"); 
		this.user2 = new User("leegw700", "이길원", "springno2"); 
		this.user3 = new User("bumJin", "박범진", "springno3");
		
		DataSource dataSource = new SingleConnectionDataSource(
				"jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=UTF-8",
				"root", "admin", true);
		
		dao.setDataSource(dataSource);
	}
	
	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {
		
//		User user1 = new User("gyumee", "박성철", "springnol"); 
//		User user2 = new User("leegw7ee", "이길원", "springno2"); 
		
		dao.deleteAll(); 
		assertThat(dao.getCount(), is(0)); 
		
		dao.add(user1); 
		dao.add(user2); 
		assertThat(dao.getCount(), is(2));

		User userget1 = dao.get(user1.getId()); 
		assertThat(userget1.getName(), is(user1.getName())); 
		assertThat(userget1.getPassword(), is(user1.getPassword())); 

		User userget2 = dao.get(user2.getId()); 
		assertThat(userget2.getName(), is(user2.getName())); 
		assertThat(userget2.getPassword(), is(user2.getPassword()));
		
	}
	
	//@Test 
	public void count() throws SQLException, ClassNotFoundException { 

//		User user1 = new User("gyumee", "박성철", "springnol"); 
//		User user2 = new User("leegw700", "이길원", "springno2"); 
//		User user3 = new User("bumJin", "박범진", "springno3");
				
		dao.deleteAll();
		
		assertThat(dao.getCount() , is(0)); 

		dao.add(user1);
		assertThat(dao.getCount(), is(1)); 
		
		dao.add(user2);
		assertThat(dao.getCount() , is(2)); 

		dao.add(user3);
		assertThat(dao.getCount() , is(3));
	}
	
	//@Test(expected=EmptyResultDataAccessException.class) 
	public void getUserFailure() throws SQLException, ClassNotFoundException{ 

		dao.deleteAll(); 
		assertThat(dao.getCount(), is(0)); 
		
		dao.get("unknown_id");
	}
}
