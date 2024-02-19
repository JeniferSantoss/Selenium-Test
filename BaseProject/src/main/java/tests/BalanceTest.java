package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import core.Properties;
import pages.HomePage;
import pages.MenuPage;

public class BalanceTest extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();
	
	@Test
	public void testBalance() {
		menu.accessHomeScreen();
		Assert.assertEquals("500.00", page.getBalanceAccount(Properties.CHANGED_ACCOUNT));
	}

}
