package excelautomation;

import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataDrivenTest {
    private WebDriver driver;

    @BeforeMethod
    public void setupDriver() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("data-url"));
    }
    @AfterMethod
    public void teardown() {
        Driver.closeDriver();
    }

    @Test
    public void employeesFormTest() {
        EmployeesFormPage empPage = new EmployeesFormPage();
        empPage.firstName.sendKeys("Mark");
        empPage.lastName.sendKeys("Smith");
        empPage.role.sendKeys("Student");
        empPage.selectGender("male");
        empPage.email.sendKeys("kigus@parcel4.net");
        empPage.annualSalary.sendKeys("90123");
        new Select(empPage.education).selectByVisibleText("High School");
        empPage.javaOCACert.click();
        empPage.additionalSkills.sendKeys("Google > Copy > Paste");
        empPage.submitBttn.click();

    }
}
