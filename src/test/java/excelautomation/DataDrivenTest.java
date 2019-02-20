package excelautomation;

import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import com.weborders.utilities.ExcelUtil;
import com.weborders.utilities.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class DataDrivenTest extends TestBase {

    List<Map<String, String>> testData;

    @BeforeMethod
    public void getTestData() {
        ExcelUtil excelUtil = new ExcelUtil("./src/test/resources/EmployeesTestData.xlsx","data");
        testData = excelUtil.getDataList();
    }

    @Test
    public void employeesFormTest() {

        for (Map<String, String> empData : testData) {

            EmployeesFormPage empPage = new EmployeesFormPage();
            empPage.firstName.sendKeys(empData.get("first_name"));
            empPage.lastName.sendKeys(empData.get("last_name"));
            empPage.role.sendKeys(empData.get("Role"));
            empPage.selectGender(empData.get("gender"));
            empPage.email.sendKeys(empData.get("email"));
            empPage.annualSalary.sendKeys(empData.get("Salary").replace(".0",""));
            new Select(empPage.education).selectByVisibleText(empData.get("Education"));
            empPage.javaOCACert.click();
            empPage.additionalSkills.sendKeys(empData.get("Skills"));
            empPage.submitBttn.click();

            ConfirmationPage cPage = new ConfirmationPage();

            Assert.assertEquals(empData.get("first_name") +" "+empData.get("last_name"),
                    cPage.getFullName());

            Driver.getDriver().get(ConfigurationReader.getProperty("employees.app.url"));

        }

    }

}
