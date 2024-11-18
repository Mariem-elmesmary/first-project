package Features;

import PO2_LogIn.mainPage;
import PO2_LogIn.signPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login {
    public static ChromeDriver driver;
    signPage sign=new signPage();
    mainPage main=new mainPage();
    @BeforeMethod
    public void setup(){
        driver =new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
    }
    @Test
    public void signin(){
        main.signinButton().click();
        sign.emaill().sendKeys("mariem.elmesmary@gmail.com");
        sign.passwordd().sendKeys("password@123");
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sign.clickk());
        boolean x=sign.welcome().getText().contains("Mariam El-mesmary");
        SoftAssert soft= new SoftAssert();
        soft.assertTrue(x);


    }
@AfterMethod
void end(){
    driver.quit();
}
}

