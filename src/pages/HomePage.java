package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class HomePage extends PredefinedActions{
	
	public AuthenticationPage clickOnSignIn() {
		System.out.println("Step: Click on sign in");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement signInElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header_user_info>a")));
		signInElement.click();
		return new AuthenticationPage();
	}
}
