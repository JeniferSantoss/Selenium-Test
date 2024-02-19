package tests;

import static core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTest;
import pages.MenuPage;
import pages.MonthlySummaryPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SummaryTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MonthlySummaryPage summaryPage = new MonthlySummaryPage();

	@Test
	public void test1_DeleteMoneyMovement() {
		menuPage.accessMonthlySummary();
		
		summaryPage.DeleteMoneyMovement();
		
		Assert.assertEquals("Movimentação removida com sucesso!", 
				summaryPage.getMessageSuccess());
	}
	
	@Test
	public void test2_MonthlySummary() {
		menuPage.accessMonthlySummary();
		
		Assert.assertEquals("Seu Barriga - Extrato", 
				getDriver().getTitle());
	}
	
}
