package pages;

import core.BasePage;

public class MenuPage extends BasePage {
	
	public void accessInsertAccount() {
		clickLink("Contas");
		clickLink("Adicionar");
	}
	
	public void listAccount() {
		clickLink("Contas");
		clickLink("Listar");
	}
	
	public void accessMoneyMovement() {
		clickLink("Criar Movimentação");
	}
	
	public void accessMonthlySummary() {
		clickLink("Resumo Mensal");
	}
	
	public void accessHomeScreen() {
		clickLink("Home");
	}

}
