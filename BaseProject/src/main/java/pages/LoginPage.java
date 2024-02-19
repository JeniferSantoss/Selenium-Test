package pages;


import core.BasePage;
import core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void accessHomeScreen() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
	}
	
	public void setEmail(String email) {
		write("email", email);
	}
	
	public void setPassword(String password) {
		write("senha", password);
	}
	
	public void enterButton() {
		clickButtonByText("Entrar");
	}

}
