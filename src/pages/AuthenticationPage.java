package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class AuthenticationPage extends PredefinedActions {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	public void validatePageHeading() {
		System.out.println("Step: Validate Authentication page title");
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Authentication']"))).isDisplayed());
	}
	
	public void enterEmailAdress(String emailId) {
		System.out.println("Step: Enter email address for the create user name");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create"))).sendKeys(emailId);
	}

	public CreateAccountPage clickOnCreateAccount() {
		System.out.println("Step: Click on the submit button to fill the other details");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("SubmitCreate"))).click();
		return new CreateAccountPage();
	}
}
