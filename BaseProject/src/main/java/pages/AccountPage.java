package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class AccountPage extends BasePage {
	
	public void setName(String name) {
		write("nome", name);
	}
	
	public void save() {
		clickButtonByText("Salvar");
	}
	
	public String getMessageSuccess() {
		return getText(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String getMessageError() {
		return getText(By.xpath("//div[@class='alert alert-danger']"));
	}

	public void clickChangeAccount(String string) {
		getCelula("Conta", string, "Ações", "tabelaContas")
				.findElement(By.xpath(".//span[@class=\'glyphicon glyphicon-edit']")).click();
		
	}
	
	public void clickDeleteAccount(String string) {
		getCelula("Conta", string, "Ações", "tabelaContas")
				.findElement(By.xpath(".//span[@class=\'glyphicon glyphicon-remove-circle']")).click();
		
	}
	

}
