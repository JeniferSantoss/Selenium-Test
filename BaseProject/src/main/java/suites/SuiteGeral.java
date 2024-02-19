package suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import core.DriverFactory;
import pages.LoginPage;
import tests.AccountTest;
import tests.BalanceTest;
import tests.MoneyMovementTest;
import tests.RemoveMoneyMovementTest;
import tests.SummaryTest;

@RunWith(Suite.class)
@SuiteClasses({
	AccountTest.class,
	MoneyMovementTest.class,
	RemoveMoneyMovementTest.class,
	BalanceTest.class,
	SummaryTest.class
})
public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	  @BeforeClass
	  public static void inicializa() {
		  page.accessHomeScreen();
		  
		  page.setEmail("numb@tester");
		  page.setPassword("123456");
		  page.enterButton();
	  }
	  
	  @AfterClass
	  public static void finaliza() {
		  DriverFactory.killDriver();
	  }

}
