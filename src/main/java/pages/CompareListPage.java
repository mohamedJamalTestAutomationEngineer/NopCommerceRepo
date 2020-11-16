package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareListPage extends PageBase{

	public CompareListPage(WebDriver constructorDriver) {
		super(constructorDriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "a.clear-list")
	WebElement clearListBtn;
	
	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;
	
	@FindBy(tagName = "tr")
	List<WebElement> allRows;
	
	@FindBy(tagName = "td")
	List<WebElement> allCols;
	
	
	@FindBy(css = "div.no-data")
	public WebElement clearCompareMessage;
	
	public void compareBetweenProducts()
	{
		System.out.println("rows size : " + allRows.size());
		
		for(WebElement row : allRows)
		{
			System.out.println(row.getText() + "\t");
			
			for(WebElement col : allCols)
			{
				System.out.println(col.getText() + "\t");
			}
		}
	}
	
	public void clearCompareList()
	{
		clickOnButton(clearListBtn);
	}
	

}
