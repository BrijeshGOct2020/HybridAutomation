package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import base.PredefinedActions;
import constantPath.ConfigFilePath;
import exceptionHandling.ProductNotFoundException;
import util.PropertyFileReader;

public class ProductCategoryPage extends PredefinedActions {
	
	private PropertyFileReader prop;
	private static ProductCategoryPage productCategoryPage;
	
	private ProductCategoryPage() {
		prop = new PropertyFileReader(ConfigFilePath.PRODUCTCATEGORY_PAGE_PROPERTIES);
	}
	
	public static ProductCategoryPage getInstance() {
		if(productCategoryPage == null)
			productCategoryPage = new ProductCategoryPage();
		return productCategoryPage;
	}

	public List<WebElement> getProductList() {
		System.out.println("Step: Get list of products");
		return getElements(prop.getValue("allProducts"), true);
	}

	public ProductDetailsPage selectFirstProduct(List<WebElement> productList) {
		System.out.println("Step: Select first product from list");
		if (productList.size() > 0) {
			clickOnElement(productList.get(0));
		} else {
			throw new ProductNotFoundException("No product found");
		}
		return ProductDetailsPage.getInstance();
	}
}
