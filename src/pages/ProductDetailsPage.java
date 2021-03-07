package pages;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import pojo.ProductDetailsPojo;
import util.PropertyFileReader;

public class ProductDetailsPage extends PredefinedActions{

	private PropertyFileReader prop;
	private static ProductDetailsPage productDetailsPage;
	
	private ProductDetailsPage() {
		prop = new PropertyFileReader(ConfigFilePath.PRODUCTDETAILS_PAGE_PROPERTIES);
	}
	
	public static ProductDetailsPage getInstance() {
		if(productDetailsPage == null)
			productDetailsPage = new ProductDetailsPage();
		return productDetailsPage;
	}
	
	public ProductDetailsPojo captureProductDetails() {
		ProductDetailsPojo productDetailsPojo = new ProductDetailsPojo();
		String productName = getElementText(prop.getValue("productName"), true);
		String price = getElementText(prop.getValue("displayPrice"), false).substring(1);
		String quantity = getAttribute(prop.getValue("quantity"), "value", false);
		String size = getElementText(prop.getValue("size"), false);
		String productDescription = getElementText(prop.getValue("productDescription"), false);
		String color = getAttribute(prop.getValue("color"), "title", false);
		
		productDetailsPojo.setProductName(productName);
		productDetailsPojo.setPrice(price);
		productDetailsPojo.setQuantity(quantity);
		productDetailsPojo.setProductDescription(productDescription);
		productDetailsPojo.setSize(size);
		productDetailsPojo.setColor(color);
		return productDetailsPojo;
	}
	
	public void setQuantity(String quantity) {
		System.out.println("Step: set quantity");
		enterText(prop.getValue("quantity"), quantity, true);
	}
	
	public void setSize(String size) {
		System.out.println("Step: set size");
		selectValueFromDropdownByVisibleText(prop.getValue("setSize"), size, false);
	}
	
	public void setColor(String color) {
		System.out.println("Step: set color");
		clickOnElement("[xpath]:-//a[@title='"+color+"']", true);
	}
	
	public void clickOnAddToCart() {
		System.out.println("Step: click on add to cart");
		clickOnElement(prop.getValue("addToCart"), true);
	}
	
	public String verifyProductName() {
		System.out.println("Step: verify product name");
		return getElementText(prop.getValue("verifyProductName"), true);
	}
	
	public String verifyQuantity() {
		System.out.println("Step: verify quantity");
		return getElementText(prop.getValue("verifyProductQuantity"), true);
	}
	
	public String verifySizeAndColor() {
		System.out.println("Step: verify size and color");
		return getElementText(prop.getValue("verifyProductAttributes"), true);
	}
	
	public String verifyTotalPrice() {
		System.out.println("Step: verify total price");
		return getElementText(prop.getValue("verifyTotalPrice"), true).substring(1);
	}
	
	public CheckoutSummaryPage clickOnProceedToCheckout() {
		System.out.println("Step: Product Details page - click on 'proceed to checkout'");
		clickOnElement(prop.getValue("proceedToCheckoutButton"), true);
		return CheckoutSummaryPage.getInstance();
	}
	
	
}
