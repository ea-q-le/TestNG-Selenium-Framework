package excelautomation;

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

    private WebDriver driver;

    public ConfirmationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        driver = Driver.getDriver();
    }

    @FindBy(xpath = "//div[contains(text(),'Dear')]")
    public WebElement dear;

    public String getFullName() {

        String name = dear.getText();
        name = name.replace("Dear ", "");
        name = name.substring(0, name.length()-1);

        return name;
    }




}
