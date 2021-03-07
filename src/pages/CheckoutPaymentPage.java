package pages;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import util.PropertyFileReader;

public class CheckoutPaymentPage extends PredefinedActions{
	private PropertyFileReader prop;
	private static CheckoutPaymentPage checkoutPaymentPage;
	
	private CheckoutPaymentPage() {
		prop = new PropertyFileReader(ConfigFilePath.CHECKOUTPAYMENT_PAGE_PROPERTIES);
	}
	
	public static CheckoutPaymentPage getInstance() {
		if(checkoutPaymentPage == null)
			checkoutPaymentPage = new CheckoutPaymentPage();
		return checkoutPaymentPage;
	}
	
	public void clickOnPayByBankWire() {
		System.out.println("Step: click on 'Pay by bank wire' button");
		clickOnElement(prop.getValue("payByWireButton"), true);
	}
	
	public void clickOnPayByCheck() {
		System.out.println("Step: click on 'Pay by check' button");
		clickOnElement(prop.getValue("payByCheckButton"), true);
	}

	public void clickOnConfirmOrderButton() {
		clickOnElement(prop.getValue("confirmOrderButton"), true);
	}
	
	public String getOrderCompleteConfirmationText() {
		return getElementText(prop.getValue("orderCompleteText"), true);
	}
}
