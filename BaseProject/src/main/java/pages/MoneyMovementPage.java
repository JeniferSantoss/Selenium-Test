package pages;


import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class MoneyMovementPage extends BasePage {
	
	public void setDateMovement(String date) {
		write("data_transacao", date);
	}
	
	public void setDatePayment(String date) {
		write("data_pagamento", date);
	}
	
	public void setDescription(String description) {
		write("descricao", description);
	}
	
	public void setMember(String member) {
		write("interessado", member);
	}

	public void setValue(String value) {
		write("valor", value);
	}
	
	public void setAccount(String account) {
		selectCombo("conta", account);
	}
	
	public void setStatus() {
		clickRadio("status_pago");
	}
	
	public void clickButtonSave() {
		clickButtonByText("Salvar");
	}
	
	public String getMessageSuccess() {
		return getText(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public List<String> getErrors(){
		List<WebElement> error = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> recurrence = new ArrayList<String>();
		for(WebElement errors: error) {
			recurrence.add(errors.getText());
		}
		
		return recurrence;
	}
	
}
