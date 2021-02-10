package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import pojo.CreateAccountDetailsPojo;

public class CreateAccountPage extends PredefinedActions{
	WebDriverWait wait = new WebDriverWait(driver,30);
	
	public void validatePageHeading() {
		System.out.println("Step: Validate CreateAccount page title");
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Create an account']"))).isDisplayed());
	}
	
	private void selectTitle(boolean isMale) {
		WebElement titleElement;
		System.out.println("Step: Select title");
		titleElement = isMale ? wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")))
														 : wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2")));
		wait.until(ExpectedConditions.elementToBeClickable(titleElement)).click();
	}
	
	private void enterFirstName(String firstName) {
		System.out.println("Step: Enter First Name");
		driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
	}
	
	private void enterLastName(String lastName) {
		System.out.println("Step: Enter Last Name");
		driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
	}
	
	private void enterPassword(String password) {
		System.out.println("Step: Enter Password");
		driver.findElement(By.id("passwd")).sendKeys(password);
	}
	
	private void selectDay(String day) {
		System.out.println("Step: Select day");
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("uniform-days")))).click();
		Select s = new Select(driver.findElement(By.id("days")));
		s.selectByValue(day);
	}
	
	private void selectMonth(String month) {
		System.out.println("Step: Select month");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-months"))).click();
		Select s = new Select(driver.findElement(By.id("months")));
		s.selectByValue(month);
	}
	
	private void selectYear(String year) {
		System.out.println("Step: Select year");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-years"))).click();
		Select s = new Select(driver.findElement(By.id("years")));
		s.selectByValue(year);
	}
	
	private void enterCompanyName(String company) {
		System.out.println("Step: Enter Company Name");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("company"))).sendKeys(company);
	}
	
	private void enterAddress(String address) {
		System.out.println("Step: Enter Address Name");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address1"))).sendKeys(address);
	}
	
	private void enterCity(String city) {
		System.out.println("Step: Enter City Name");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city"))).sendKeys(city);
	}
	
	private void selectState(String state) {
		System.out.println("Step: Select State");
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("uniform-id_state")))).click();
		Select s = new Select(driver.findElement(By.id("id_state")));
		s.selectByVisibleText(state);
	}
	
	private void enterPostCode(String postCode) {
		System.out.println("Step: Enter Postcode");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postcode"))).sendKeys(postCode);
	}
	
	private void additionalInfo(String additionalInfo) {
		System.out.println("Step: Enter additional information");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("other"))).sendKeys(additionalInfo);
	}
	
	private void enterHomePhoneNumber(String hPhone) {
		System.out.println("Step: Enter Home mobile number");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).sendKeys(hPhone);
	}
	
	private void enterMobilePhone(String mNumber) {
		System.out.println("Step: Enter Mobile number");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone_mobile"))).sendKeys(mNumber);
	}
	
	public void enterCreateAccountDetails(CreateAccountDetailsPojo createAccountDetailsPojo) {
		selectTitle(createAccountDetailsPojo.isMale());
		enterFirstName(createAccountDetailsPojo.getFirstName());
		enterLastName(createAccountDetailsPojo.getLastName());
		enterPassword(createAccountDetailsPojo.getPassword());
		selectDay(createAccountDetailsPojo.getDay());
		selectMonth(createAccountDetailsPojo.getMonth());
		selectYear(createAccountDetailsPojo.getYear());
		enterCompanyName(createAccountDetailsPojo.getCompany());
		enterAddress(createAccountDetailsPojo.getAddress1());
		enterCity(createAccountDetailsPojo.getCity());
		selectState(createAccountDetailsPojo.getState());
		enterPostCode(createAccountDetailsPojo.getPostCode());
		enterHomePhoneNumber(createAccountDetailsPojo.gethPhone());
		enterMobilePhone(createAccountDetailsPojo.getmNumber());
	}
	
	public MyProfilePage clickOnRegistration() {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submitAccount"))).click();
		System.out.println("Details Registered in Application");
		return new MyProfilePage();
	}
}
