package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class ItemsPage {
	
	public ItemsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//button[text()=' Add Item']")//this is to locate"Add Item" button on the second page
    public WebElement items_page_addItem_btn;
    
    @FindBy (xpath = "//h3[text()='Items']")      //this is the "Items" text
    public WebElement items_page_item_headerText;
    
    @FindBy (xpath = "//h3[text()='New Item']")
    public WebElement items_Input_page_newItem_text;
    
    @FindBy (xpath = "//div[@class='relative rounded-md shadow-sm font-base']/input")//here because we couldn't find id
    public WebElement items_input_page_name_box;//or class or anything we had to go to the parent which is the div then
                                                //we went down to the "input" which is the child and in order to get to
                                                //the child we put "/" to get there that's why we put "/input" 
    
    @FindBy (xpath = "//input[@id='0']")        //we found "id" here but keep in mind if the id has number it will be 
    public WebElement items_input_page_price_box;//very hard to locate it sometimes
    
    @FindBy (xpath = "//div[@tabindex='-1']/input")//here we found the parent then the child and we put "/" before the
    public WebElement items_input_page_unit_dropdown;//child
    
    @FindBy (xpath = "//span[text()='pc']")        //this "pc" located in the drop down list
    public WebElement items_input_page_unit_pc_option;
    
    @FindBy (name = "description")
    public WebElement items_input_page_description;
    
    @FindBy (xpath = "//button[text()=' Save Item']")
    public WebElement items_page_saveItem_btn;
    
    //now the requirements in the ItemsManagement cucumber class said once you save and click, the item should be saved
    //on the next page, but if you keep adding for ex items on this page the first item will be in last as of keep adding
    //items and it will ended in a different page, so how should we deal with this? we go to the filter and type the item
    //there then click it will pops up on the page and that's how we verify it
    
    @FindBy (xpath = "//button[text()='Filter ']")//to locate the filter button
    public WebElement items_page_filter_btn;
    
    @FindBy (xpath = "//input[@name='name']")//to locate the name box
    public WebElement items_page_filter_name_box;
    
    @FindBy (xpath = "(//button[contains(@id, 'headlessui-menu-button')])[3]")//to locate the 3 dots at the end right
    public WebElement items_page_3dot_menu;
    
    @FindBy (xpath = "//a[text()=' Edit']")   //to locate "Edit"
    public WebElement items_page_3dot_edit_option;
    
    @FindBy (xpath = "//a[text()=' Delete']")  // to locate "Delete"
    public WebElement items_page_3dot_delete_option;
    
    @FindBy (xpath = "//h3[text()='Are you sure?']")  //to locate "Are you sure?"
    public WebElement items_Input_delete_youSure_text;
    
    @FindBy (xpath = "//button[text()='Ok']")   // to locate "Ok"
    public WebElement items_page_delete_ok_btn;
    
    @FindBy (xpath = "//button[text()='Cancel']")  //to locate the "Cancel"
    public WebElement items_page_delete_cancel_btn;
    
    @FindBy (xpath = "//span[text()='No Results Found']")// to locate this text "No Results Found" after we click delete
    public WebElement items_Input_noResultFound_text;
    
    @FindBy (xpath = "//th[text()='Name ']")  //to locate the name
    public WebElement items_page_table_Name_Column_Header;
    
    @FindBy (xpath = "//h3[text()='Edit Item']") //to locate the edit item page
    public WebElement items_page_edit_item_headerText;
    
    @FindBy (xpath = "//button[text()=' Update Item']")//to locate update button on items page
    public WebElement items_page_update_item_btn;

}
