package pages;

import org.junit.Assert;
import base.PredefinedActions;
import constantPath.ConfigFilePath;
import pojo.CreateAccountDetailsPojo;
import util.PropertyFileReader;

public class CreateAccountPage extends PredefinedActions{
	
	private PropertyFileReader prop;
	private static CreateAccountPage createAccountPage;
	
	private CreateAccountPage() {
		prop = new PropertyFileReader(ConfigFilePath.CREATEACCOUNT_PAGE_PROPERTIES);
	}
	
	public static CreateAccountPage getInstance() {
		if(createAccountPage == null)
			createAccountPage = new CreateAccountPage();
		return createAccountPage;
	}
	
	public void validatePageHeading() {
		System.out.println("Step: Validate CreateAccount page title");
		Assert.assertTrue(isElementDisplayed(prop.getValue("pageTitle"), true));
	}
	
	private void selectTitle(boolean isMale) {
		System.out.println("Step: Select title");
		if(isMale)
			clickOnElement(prop.getValue("genderMale"), true);
		else
			clickOnElement(prop.getValue("genderFemale"), true);
	}
	
	private void enterFirstName(String firstName) {
		System.out.println("Step: Enter First Name");
		enterText(prop.getValue("firstName"), firstName, true);
	}
	
	private void enterLastName(String lastName) {
		System.out.println("Step: Enter Last Name");
		enterText(prop.getValue("lastName"), lastName, true);
	}
	
	private void enterPassword(String password) {
		System.out.println("Step: Enter Password");
		enterText(prop.getValue("password"), password, true);
	}
	
	private void selectDay(String day) {
		System.out.println("Step: Select day");
		clickOnElement(prop.getValue("dayDropdown"), true);
		selectValueFromDropdownByValue(prop.getValue("days"), day, false);
	}
	
	private void selectMonth(String month) {
		System.out.println("Step: Select month");
		clickOnElement(prop.getValue("monthDropdown"), true);
		selectValueFromDropdownByValue(prop.getValue("months"), month, false);
	}
	
	private void selectYear(String year) {
		System.out.println("Step: Select year");
		clickOnElement(prop.getValue("yearDropdown"), true);
		selectValueFromDropdownByValue(prop.getValue("years"), year, false);
	}
	
	private void enterCompanyName(String company) {
		System.out.println("Step: Enter Company Name");
		enterText(prop.getValue("company"), company, false);
	}
	
	private void enterAddress(String address) {
		System.out.println("Step: Enter Address Name");
		enterText(prop.getValue("address"), address, false);
	}
	
	private void enterCity(String city) {
		System.out.println("Step: Enter City Name");
		enterText(prop.getValue("city"), city, false);
	}
	
	private void selectState(String state) {
		System.out.println("Step: Select State");
		clickOnElement(prop.getValue("stateDropdown"), false);
		selectValueFromDropdownByVisibleText(prop.getValue("state"), state, false);
	}
	
	private void enterPostCode(String postCode) {
		System.out.println("Step: Enter Postcode");
		enterText(prop.getValue("postCode"), postCode, false);
	}
	
	private void additionalInfo(String additionalInfo) {
		System.out.println("Step: Enter additional information");
		enterText(prop.getValue("additionalInfo"), additionalInfo, false);
	}
	
	private void enterHomePhoneNumber(String hPhone) {
		System.out.println("Step: Enter Home mobile number");
		enterText(prop.getValue("homePhone"), hPhone, false);
	}
	
	private void enterMobilePhone(String mNumber) {
		System.out.println("Step: Enter Mobile number");
		enterText(prop.getValue("mobileNumber"), mNumber, false);
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
		clickOnElement(prop.getValue("registrationButton"), false);
		System.out.println("Details Registered in Application");
		return MyProfilePage.getInstance();
	}
}
