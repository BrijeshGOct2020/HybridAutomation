package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.PredefinedActions;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyProfilePage;
import pojo.CreateAccountDetailsPojo;
import util.ExcelOperation;

public class CreateAccountTest {

	@Test
	public void createAccountTest() {
		PredefinedActions.start();
		HomePage homePage = new HomePage();
		AuthenticationPage authenticationPage = homePage.clickOnSignIn();
		authenticationPage.validatePageHeading();
		authenticationPage.enterEmailAdress("automation19783849@gmail.com");
		CreateAccountPage createAccountPage = authenticationPage.clickOnCreateAccount();
		createAccountPage.validatePageHeading();

		System.out.println("Navigate to create account page");
		CreateAccountDetailsPojo createAccountDetailsPojo = new CreateAccountDetailsPojo();
		createAccountDetailsPojo.setMale(true);
		createAccountDetailsPojo.setFirstName("Test");
		createAccountDetailsPojo.setLastName("User");
		createAccountDetailsPojo.setPassword("Avbdggh@567");
		createAccountDetailsPojo.setDay("12");
		createAccountDetailsPojo.setMonth("1");
		createAccountDetailsPojo.setYear("1997");
		createAccountDetailsPojo.setCompany("PTC");
		createAccountDetailsPojo.setAddress1("650 Grassmere park");
		createAccountDetailsPojo.setCity("nashville");
		createAccountDetailsPojo.setState("Maine");
		createAccountDetailsPojo.setPostCode("37211");
		createAccountDetailsPojo.setAdditionalInfo("NA");
		createAccountDetailsPojo.sethPhone("1234567890");
		createAccountDetailsPojo.setmNumber("9876543210");
		createAccountDetailsPojo.setAliasAddress("");
		createAccountPage.enterCreateAccountDetails(createAccountDetailsPojo);

		MyProfilePage myProfilePage = createAccountPage.clickOnRegistration();
		String actual = myProfilePage.getHeaderText();
		String expected = "Test User";
		Assert.assertEquals(actual, expected, "Verification of headertext failed");
	}

	@Test(dataProvider = "Create Account")
	public void createAccountTestDynamicData(String email, String gender, String firstName, String lastName,
			String password, String day, String month, String year, String company, String address, String city,
			String state, String postCode, String additionalInfo, String hPhone, String mNumber,
			String aliasAddress) {
		PredefinedActions.start();
		HomePage homePage = new HomePage();
		AuthenticationPage authenticationPage = homePage.clickOnSignIn();
		authenticationPage.validatePageHeading();
		authenticationPage.enterEmailAdress(email);
		CreateAccountPage createAccountPage = authenticationPage.clickOnCreateAccount();
		createAccountPage.validatePageHeading();

		System.out.println("Navigate to create account page");
		CreateAccountDetailsPojo createAccountDetailsPojo = new CreateAccountDetailsPojo();
		boolean genderFlag = gender.equalsIgnoreCase("m") ? true : false;
		createAccountDetailsPojo.setMale(genderFlag);
		createAccountDetailsPojo.setFirstName(firstName);
		createAccountDetailsPojo.setLastName(lastName);
		createAccountDetailsPojo.setPassword(password);
		createAccountDetailsPojo.setDay(day);
		createAccountDetailsPojo.setMonth(month);
		createAccountDetailsPojo.setYear(year);
		createAccountDetailsPojo.setCompany(company);
		createAccountDetailsPojo.setAddress1(address);
		createAccountDetailsPojo.setCity(city);
		createAccountDetailsPojo.setState(state);
		createAccountDetailsPojo.setPostCode(postCode);
		createAccountDetailsPojo.setAdditionalInfo(additionalInfo);
		createAccountDetailsPojo.sethPhone(hPhone);
		createAccountDetailsPojo.setmNumber(mNumber);
		createAccountDetailsPojo.setAliasAddress(aliasAddress);
		createAccountPage.enterCreateAccountDetails(createAccountDetailsPojo);

		MyProfilePage myProfilePage = createAccountPage.clickOnRegistration();
		String actual = myProfilePage.getHeaderText();
		String expected = firstName+" "+lastName;
		Assert.assertEquals(actual, expected, "Verification of headertext failed");
	}

	@DataProvider(name = "Create Account")
	public String[][] createAccount() throws IOException {
		return ExcelOperation.getExcelData("TestData.xlsx", "CreateAccount");
	}
}
