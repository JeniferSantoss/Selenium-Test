package tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTest;
import core.Properties;
import pages.AccountPage;
import pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	AccountPage accountPage = new AccountPage();

	@Test
	public void test1_InsertAccount() {
		menuPage.accessInsertAccount();
		
		accountPage.setName("Conta do Teste");
		accountPage.save();
		
		Assert.assertEquals("Conta adicionada com sucesso!", accountPage.getMessageSuccess());	
	}
	
	@Test
	public void test2_ChangeAccount() {
		menuPage.listAccount();
		
		accountPage.clickChangeAccount("Conta do Teste");
		accountPage.setName(Properties.CHANGED_ACCOUNT);
		accountPage.save();
		
		Assert.assertEquals("Conta alterada com sucesso!", accountPage.getMessageSuccess());
	}
	
	@Test
	public void test3_sameNameAccount() {
		menuPage.accessInsertAccount();
		
		accountPage.setName(Properties.CHANGED_ACCOUNT);
		accountPage.save();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", accountPage.getMessageError());
	}
	

}
