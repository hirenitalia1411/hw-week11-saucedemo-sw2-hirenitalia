package testsuite;
/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userShouldLoginSuccessfullyWithValid Credentials
 *      Enter “standard_user” username
 *      Enter “secret_sauce” password
 *      Click on ‘LOGIN’ button
 *      Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 *      Enter “standard_user” username
 *      Enter “secret_sauce” password
 *      Click on ‘LOGIN’ button
 *      Verify that six products are displayed on  page
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://www.saucedemo.com/"; // base URL

    @Before
    public void setUp () {
        openBrowser(baseUrl); // calling method from BaseTest class to open and set-up the browser
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user"); // find element for Username field and enter valid username
        driver.findElement(By.name("password")).sendKeys("secret_sauce"); // find element for Password field and enter valid password
        driver.findElement(By.name("login-button")).click(); // find element for login button and click
        // get the text from redirected page to verify the login
        String actualText = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        String expectedText = "Products"; // expected text in the redirected page
        Assert.assertEquals(expectedText, actualText); // verify expected and actual text
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user"); // find element for Username field and enter valid username
        driver.findElement(By.name("password")).sendKeys("secret_sauce"); // find element for Password field and enter valid password
        driver.findElement(By.name("login-button")).click(); // find element for login button and click
        // find the elements with the same class name to find the products on the page
        List<WebElement> numberOfProduct = driver.findElements(By.className("inventory_item"));
        System.out.println("Number of Product in Page: " + numberOfProduct.size()); // display the no of products using size method
    }

    @After
    public void tearTown () {
        closeBrowser(); // calling method from BaseTest class to close the browser
    }
}