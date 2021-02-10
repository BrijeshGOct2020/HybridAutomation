package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.PredefinedActions;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyProfilePage;
import pojo.CreateAccountDetailsPojo;

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
}
