package core;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import enums.ByValue;

public class Element {
	private ByValue by;
	private String map;
	private WebElement webElement = null;
	private WebElement element = null;
	private HashMap<ByValue, By> byMap = new HashMap<>();
	
	public Element(ByValue by, String _map) {
		this.by = by;
		map = _map;
		setByMap();
	}
	
	private void setByMap() {
		byMap.put(ByValue.ID, By.id(map));
		byMap.put(ByValue.XPATH, By.xpath(map));
		byMap.put(ByValue.CSS, By.cssSelector(map));
		byMap.put(ByValue.LINKTEXT, By.linkText(map));
		byMap.put(ByValue.NAME, By.name(map));
		byMap.put(ByValue.CLASSNAME, By.className(map));
	}
	
	public void setWebElement(WebElement _element) {
		webElement = _element;
	}
	
	public WebElement getElement() {
		if (element == null) {
			element = get(byMap.get(by));
		}
		return element;
	}
	
	public WebElement get(By by) {
		if (webElement == null) {
			return Driver.getDriver().findElement(by);
		}
		return webElement.findElement(by);
	}
			
	public List<WebElement> getElements() {
		return Driver.getDriver().findElements(byMap.get(by));
	}
	
	public void sendKeys(CharSequence... value) {
		getElement().sendKeys(value);
	}
	
	public String getText() {
		return getElement().getText();
	}
	
	public void click() {
		getElement().click();
	}
	
	public String getAttribute(String value) {
		return getElement().getAttribute(value);
	}
	
	public Element clear() {
		getElement().clear();
		return this;
	}
	
	public boolean isEnabled() {
		return getElement().isEnabled();
	}
	
	public boolean isDisplayed() {
		return getElement().isDisplayed();
	}
	
	public boolean isSelected() {
		return getElement().isSelected();
	}
	
	public void select(String value) {
		Select select = new Select(getElement());
		select.selectByVisibleText(value);
	}
	
	public Element waitVisibleElement() {
		element = Driver.waitVisibleElement(byMap.get(by));
		return this;
	}
	
	public void waitInvisibilityElement() {
		Driver.waitInvisibilityElemnt(byMap.get(by));
	}
	
	public Element waitClickableElement() {
		element = Driver.waitClickableElement(byMap.get(by));
		return this;
	}
}
