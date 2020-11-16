package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver constructorDriver) {
		super(constructorDriver);
	}
	
	@FindBy(id = "FriendEmail")
	WebElement friendsEmail;
	
	@FindBy(id = "YourEmailAddress")
	WebElement registeredUserEmail;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalMessgeBox;
	
	@FindBy(css = "input.button-1.send-email-a-friend-button")
	WebElement sendMailBtn;
	
	@FindBy(css = "div.result")
	public WebElement successOfSendMailMessage;
	
	public void sendEmailToFriend(String friendmail , String messageTxt)
	{
		setElementTxtBox(friendsEmail, friendmail);
		setElementTxtBox(personalMessgeBox, messageTxt);
		clickOnButton(sendMailBtn);
	}

}
