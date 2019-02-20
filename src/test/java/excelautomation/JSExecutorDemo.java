package excelautomation;

import com.weborders.utilities.BrowserUtils;
import com.weborders.utilities.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JSExecutorDemo extends TestBase {

    @Test
    public void test() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("alert('You are doing something dangerous');");

        EmployeesFormPage employeesFormPage = new EmployeesFormPage();

        // it will click on the employees.male webelement
        // first arg is JS command, second arg is WE on which command will be executed
        jse.executeScript("arguments[0].click();", employeesFormPage.male);

        String name = "Kunkka";
        jse.executeScript("arguments[0].setAttribute('value', '" +
                name + "')", employeesFormPage.firstName);

        // scroll down on a page
        jse.executeScript("window.scrollBy(0, 1000)");

        // putting so that driver does not close quickly
        BrowserUtils.wait(10);
    }
}
