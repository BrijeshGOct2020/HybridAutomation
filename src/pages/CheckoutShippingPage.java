package pages;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import util.PropertyFileReader;

public class CheckoutShippingPage extends PredefinedActions{
	private PropertyFileReader prop;
	private static CheckoutShippingPage checkoutShippingPage;
	
	private CheckoutShippingPage() {
		prop = new PropertyFileReader(ConfigFilePath.CHECKOUTSHIPPING_PAGE_PROPERTIES);
	}
	
	public static CheckoutShippingPage getInstance() {
		if(checkoutShippingPage == null)
			checkoutShippingPage = new CheckoutShippingPage();
		return checkoutShippingPage;
	}
	
	public String getShippingCharge() {
		System.out.println("Step: Get Shipping charge");
		return getElementText(prop.getValue("shippingCharges"), true).substring(1);
	}
	
	public void agreeTermsAndConditions() {
		System.out.println("Step: Agree terms & conditions");
		clickOnElement(prop.getValue("agreeTermsAndConditions"), false);
	}
	
	public CheckoutPaymentPage clickOnProceedToCheckout() {
		System.out.println("Step: CheckoutShippingPage - Click on 'proceed to checkout' button");
		clickOnElement(prop.getValue("proceedToCheckoutButton"), true);
		return CheckoutPaymentPage.getInstance();
	}
}
