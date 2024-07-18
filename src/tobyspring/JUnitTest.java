package tobyspring;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class JUnitTest {
	
	static Set<JUnitTest> testObjects = new HashSet<JUnitTest>();
	
	@Test 
	public void testl() { 
		assertThat(testObjects, not(hasItem(this))); 
		testObjects.add(this);
	}
	
	@Test 
	public void test2() { 
		assertThat(testObjects, not(hasItem(this))); 
		testObjects.add(this);
	}

	@Test 
	public void test3() {
		assertThat(testObjects, not(hasItem(this))); 
		testObjects.add(this);
	}
}
