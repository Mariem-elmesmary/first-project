package Features;

import P01_Register.createpage;
import P01_Register.homepage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Register {
    public static ChromeDriver driver;
    homepage home = new homepage();
    createpage create = new createpage();
    SoftAssert soft = new SoftAssert();

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void tc_1() {
        home.click().click();
        create.firstname().sendKeys("mariem");
        create.lastName().sendKeys("mohamed");
        create.email().sendKeys("mariem.elmesmary@gmail.com");
        create.password().sendKeys("password@123");
        create.createButton().click();
        boolean x = create.required().isDisplayed();
        Assert.assertTrue(x);
    }

    @Test
    public void tc_2() {
        home.click().click();
        create.firstname().sendKeys("mariem");
        create.lastName().sendKeys("mohamed");
        create.email().sendKeys("mariem.elmesmary@gmail.com");
        create.password().sendKeys("password@123");
        create.confirm().sendKeys("password@1234");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", create.createButton());
        boolean y = create.required().isDisplayed();
        soft.assertTrue(y);
    }

    @Test
    public void tc_3() {
        home.click().click();
        create.firstname().sendKeys("mariem");
        create.lastName().sendKeys("elmesmary");
        create.email().sendKeys("mariem.elmeysmary@gmail.com");
        create.password().sendKeys("password@123");
        create.confirm().sendKeys("password@123");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", create.createButton());
        boolean z = create.contain().getText().contains("mariem");
        soft.assertTrue(z);

        boolean w = create.contain().getText().contains("mariem.elmeysmary@gmail.com");
        soft.assertTrue(w);


    }

    @AfterMethod
   void end() {
       driver.quit();
    }
}

