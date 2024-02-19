package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import core.Properties;
import pages.AccountPage;
import pages.MenuPage;

public class RemoveMoneyMovementTest extends BaseTest{
	
	MenuPage menuPage = new MenuPage();
	AccountPage accountPage = new AccountPage();

	@Test
	public void testDeleteAccountWithMovement() {
		menuPage.listAccount();
		
		accountPage.clickDeleteAccount(Properties.CHANGED_ACCOUNT);
		
		Assert.assertEquals("Conta em uso na movimentações", accountPage.getMessageError());
	}
}
