package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class MonthlySummaryPage extends BasePage {
	
	public void DeleteMoneyMovement() {
		clickButton(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String getMessageSuccess() {
		return getText(By.xpath("//div[@class='alert alert-success']"));
	}

}
