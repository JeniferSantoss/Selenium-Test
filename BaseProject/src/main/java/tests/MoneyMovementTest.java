package tests;

import static utils.DataUtils.getFormatDate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTest;
import core.Properties;
import pages.MenuPage;
import pages.MoneyMovementPage;
import utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MoneyMovementTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private MoneyMovementPage MovePage = new MoneyMovementPage();
	
	@Test
	public void test1_InsertMoneyMovement() {
		menuPage.accessMoneyMovement();
		
		Date futureDate = DataUtils.getDate(0);
		
		MovePage.setDateMovement(getFormatDate(futureDate));
		MovePage.setDatePayment(getFormatDate(futureDate));
		MovePage.setDescription("Movimentação teste");
		MovePage.setMember("Alguem");
		MovePage.setValue("500");
		MovePage.setAccount(Properties.CHANGED_ACCOUNT);
		MovePage.setStatus();
		MovePage.clickButtonSave();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", MovePage.getMessageSuccess());
	}
	
	@Test
	public void test2_requiredField() {
		menuPage.accessMoneyMovement();
		
		MovePage.clickButtonSave();
		
		List<String> errors = MovePage.getErrors();
		//Assert.assertEquals("Data da Movimentação é obrigatório", errors.get(0));
		Assert.assertTrue(errors.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número"			
				)));
		
		Assert.assertEquals(6, errors.size());
	}
	
	@Test
	public void test3_futureMoneyMovement() {
		menuPage.accessMoneyMovement();
		
		MovePage.setDateMovement("05/06/2100");
		MovePage.setDatePayment("05/06/2100");
		MovePage.setDescription("Movimentação teste");
		MovePage.setMember("Alguem");
		MovePage.setValue("500");
		MovePage.setAccount(Properties.CHANGED_ACCOUNT);
		MovePage.setStatus();
		MovePage.clickButtonSave();
		
		List<String> errors = MovePage.getErrors();
		Assert.assertTrue(
			errors.contains("Data da Movimentação deve ser menor ou igual à data atual"	
				));
		
		Assert.assertEquals(1, errors.size());
	}

}
