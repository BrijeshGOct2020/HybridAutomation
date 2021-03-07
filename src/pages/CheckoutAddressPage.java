package pages;

import java.util.List;
import base.PredefinedActions;
import constantPath.ConfigFilePath;
import util.PropertyFileReader;

public class CheckoutAddressPage extends PredefinedActions {
	private PropertyFileReader prop;
	private static CheckoutAddressPage checkoutAddressPage;
	
	private CheckoutAddressPage() {
		prop = new PropertyFileReader(ConfigFilePath.CHECKOUTADDRESS_PAGE_PROPERTIES);
	}
	
	public static CheckoutAddressPage getInstance() {
		if(checkoutAddressPage == null)
			checkoutAddressPage = new CheckoutAddressPage();
		return checkoutAddressPage;
	}
	
	public boolean isDeliveryAndBillingAddressSame() {
		System.out.println("Step: check if checkbox checked");
		return isElementSelected(prop.getValue("addressCheckbox"), false);
	}

	public List<String> getDeliveryAddress() {
		System.out.println("Step: Get delivery address");
		return getElementsText(prop.getValue("deliveryAddress"), false);
	}

	public List<String> getBillingAddress() {
		System.out.println("Step: Get billing address");
		return getElementsText(prop.getValue("billingAddress"), false);
	}
	
	public CheckoutShippingPage clickOnProceedToCheckout() {
		System.out.println("Step: CheckoutAddressPage - Click on 'proceed to checkout' button");
		clickOnElement(prop.getValue("proceedToCheckoutButton"), true);
		return CheckoutShippingPage.getInstance();
	}
}
