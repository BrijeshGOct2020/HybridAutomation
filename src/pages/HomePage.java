package pages;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import util.PropertyFileReader;

public class HomePage extends PredefinedActions{
	private PropertyFileReader prop;
	private static HomePage homePage;
	
	private HomePage() {
		prop = new PropertyFileReader(ConfigFilePath.HOME_PAGE_PROPERTIES);
	}
	
	public static HomePage getInstance() {
		if(homePage == null)
			homePage = new HomePage();
		return homePage;
	}
	
	public AuthenticationPage clickOnSignIn() {
		System.out.println("Step: Click on sign in");
		clickOnElement(prop.getValue("signInButton"),true);
		return AuthenticationPage.getInstance();
	}
}
