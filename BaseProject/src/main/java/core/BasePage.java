package core;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	
/************ TextField e TextArea ************/
	
	public void write(By by, String text) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(text);
	}

	public void write(String id_field, String text) {
		getDriver().findElement(By.id(id_field)).sendKeys(text);
	}
	
	public String getValueField(String id_field) {
		return getDriver().findElement(By.id(id_field)).getAttribute("value");
	}
	
	/************ Radio e Check ************/
	
	public void clickRadio(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public void clickRadio(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clickButtonByText(String text) {
		clickButton(By.xpath("//button[.='"+text+"']"));
	}
	
	public boolean isRadioMarked(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void clicarCheck(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public boolean isCheckMarked(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	/************ Combo ************/
	
	public void selectCombo(String id, String value) {
		WebElement element = getDriver().findElement(By.id(id));
		 Select combo = new Select(element);
		 combo.selectByVisibleText(value);
	}
	
	public void deselectCombo(String id, String value) {
		WebElement element = getDriver().findElement(By.id(id));
		 Select combo = new Select(element);
		 combo.deselectByVisibleText(value);
	}
	
	public String obterValorCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		 Select combo = new Select(element);
		 return combo.getFirstSelectedOption().getText();
	}
	
	public List<String> getValueCombo(String id) {
		WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> values = new ArrayList<String>();
		for(WebElement option: allSelectedOptions) {
			values.add(option.getText());
		}
		return values;
	}
	
	public int getOptionsCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	public boolean checkOptionCombo(String id, String opcao) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)) {
				return true;
			}
		}
		
		return false;
	}
	
	/************ Button ************/
	
	public void clickButton(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clickButton(String id) {
		clickButton(By.id(id));
	}
	
	public String getValueElement(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	/************ Link ************/
	
	public void clickLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	/************ Textos ************/
	
	public String getText(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String getText(String id) {
		return getText(By.id(id));
	}
	
	/************ Alerts ************/
	
	public String getTextAlert() {
		Alert alert = getDriver().switchTo().alert();	
		return alert.getText();
	}
	
	public String getTextAlertSuccess() {
		Alert alert = getDriver().switchTo().alert();
		String value = alert.getText();
		alert.accept();
		return value;
	}
	
	public String getTextAlertDenied() {
		Alert alert = getDriver().switchTo().alert();
		String value = alert.getText();
		alert.dismiss();
		return value;
	}
	
	public void writeAlert(String value) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
	}
	
	/************ Frames e Janelas ************/
	
	public void openFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public void exitFrame(String id) {
		getDriver().switchTo().defaultContent();
	}
	
	public void changeWindow(String id) {
		getDriver().switchTo().window(id);
		
	}
	
	/************ JS ************/
	
	public Object executeJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);

	}
	
	/************ Tabela ************/
	
	
	public WebElement getCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id=\'"+idTabela+"']"));
		int idColuna = getIndexColumn(colunaBusca, tabela);
		int idLinha = getIndexLinha(valor, tabela, idColuna);
		int idColunaBotao = getIndexColumn(colunaBotao, tabela);

		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
		return celula;

		
	}
	
	
	public void clickButtonTable(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		WebElement celula = getCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();

		
	}

	protected int getIndexLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i <linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int getIndexColumn(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}

}
