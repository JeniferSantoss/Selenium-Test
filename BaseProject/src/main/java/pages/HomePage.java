package pages;

import core.BasePage;

public class HomePage extends BasePage {
	
	public String getBalanceAccount(String name) {
		return getCelula("Conta", name, "Saldo", "tabelaSaldo").getText();
			
	}
	
}

