package Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenerTest.class)
public class DemoTest {
	
	@Test
	public void Test1() {
		
	}
	
	@Test
	public void Test2() {
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = {"Test2"})
	public void Test3() {
		
	}
	
	@Test
	public void Test4() {
		System.out.println("Hi");
	}
	
	@Test
	public void sample() {
		System.out.println("Sample");
		System.out.println("Sample for pull");
	}

}
