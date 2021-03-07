package pages;

import org.junit.Assert;
import base.PredefinedActions;
import constantPath.ConfigFilePath;
import util.PropertyFileReader;

public class AuthenticationPage extends PredefinedActions {
	private PropertyFileReader prop;
	private static AuthenticationPage authenticationPage;
	
	private AuthenticationPage() {
		prop = new PropertyFileReader(ConfigFilePath.AUTHENTICATION_PAGE_PROPERTIES);
	}
	
	public static AuthenticationPage getInstance() {
		if(authenticationPage == null)
			authenticationPage = new AuthenticationPage();
		return authenticationPage;
	}
	
	public void validatePageHeading() {
		System.out.println("Step: Validate Authentication page title");
		Assert.assertTrue(isElementDisplayed(prop.getValue("authenticationPageTitle"), true));
	}
	
	public void enterEmailAdress(String emailId) {
		System.out.println("Step: Enter email address for the create user name");
		enterText(prop.getValue("createAccountEmail"),emailId, true);
	}

	public CreateAccountPage clickOnCreateAccount() {
		System.out.println("Step: Click on the submit button to fill the other details");
		clickOnElement(prop.getValue("createAccountSubmit"), true);
		return CreateAccountPage.getInstance();
	}
	
	public MyProfilePage signIn(String email, String password) {
		enterEmailSignIn(email);
		enterPassword(password);
		return clickOnSignInButton();
	}
	
	public void enterEmailSignIn(String email) {
		System.out.println("Step: Enter email in SignIn box");
		enterText(prop.getValue("signInEmail"), email, true);
	}
	
	public void enterPassword(String password) {
		System.out.println("Step: Enter password in SignIn box");
		enterText(prop.getValue("signInPassword"), password, true);
	}
	
	public MyProfilePage clickOnSignInButton() {
		System.out.println("Step: Sign in button");
		clickOnElement(prop.getValue("signInSubmit"), true);
		return MyProfilePage.getInstance();
	}
	
	public String getAlertErrorText() {
		System.out.println("Step: Get alert");
		return getElementText(prop.getValue("alertError"),true);
	}
}
