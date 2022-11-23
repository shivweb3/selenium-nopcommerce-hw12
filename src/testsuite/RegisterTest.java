package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    //5.1)
    public void UserShouldNavigateToRegisterPageSuccessfully(){
        // click on the ‘Register’ link
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        //Verify the text ‘Register’
        String expectedMessage = "Register";

        //Location what actually message it shows when you enter invalid username and password
        WebElement actualMessagetext = driver.findElement(By.xpath("//h1[text()='Register']"));
        String actualMessage = actualMessagetext.getText();

        Assert.assertEquals("No such message is displayed",actualMessage,expectedMessage);
    }

    @Test
    //5.2)
    public void userShouldRegisterAccountSuccessfully(){
        // click on the ‘Register’ link
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        //Select Gender radio button
        driver.findElement(By.id("gender-male")).click();

        // Enter First Name
        driver.findElement(By.name("FirstName")).sendKeys("Shiv");

        //Enter Last Name
        driver.findElement(By.name("LastName")).sendKeys("Patel");
        //Enter Date
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("19");
        //Enter Month
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("April");
        //Enter Year
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("2001");
        //Enter Email
        driver.findElement(By.id("Email")).sendKeys("test12345@gmail.com");
        //Enter Password
        driver.findElement(By.id("Password")).sendKeys("Test12345");
        //Enter Confirm Password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Test12345");
        //Click on Register Button
        driver.findElement(By.id("register-button")).click();
    }

    @After
    public void teardown() {
        closeBrowser();
    }

}

