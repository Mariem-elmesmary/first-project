package Features;

import P04_Wishlist.Wishlist_page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Wishlist {
    public static ChromeDriver driver;
    Wishlist_page wish= new Wishlist_page();
    SoftAssert soft= new SoftAssert();


    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
    }
    @Test
    public void TC_1(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", wish.scrollto());
        boolean x = wish.scrollto().isDisplayed();
        soft.assertTrue(x, "Hot Sellers section is not displayed!");
        Actions act= new Actions(driver);
        act.moveToElement(wish.card()).perform();
        js.executeScript("arguments[0].click();",wish.addtowishlist_Button());
        boolean y= driver.getCurrentUrl().contains("login");
        Assert.assertTrue(y);
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void TC_2(){
        wish.signin().click();
        wish.emaill().sendKeys("mariem.elmesmary@gmail.com");
        wish.passwordd().sendKeys("password@123");
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",wish.clickk());

        JavascriptExecutor jss = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", wish.scrollto());
        boolean y = wish.scrollto().isDisplayed();
        soft.assertTrue(y, "Hot Sellers section is not displayed!");
        Actions act= new Actions(driver);
        act.moveToElement(wish.card()).perform();

        JavascriptExecutor jjs =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",wish.addtowishlist_Button());
        boolean w= driver.getCurrentUrl().contains("wishlist");
        Assert.assertTrue(w);
        System.out.println(driver.getCurrentUrl());
     boolean s=wish.product().isDisplayed();
       soft.assertTrue(s);

    }
    @AfterMethod
    void end(){
        driver.quit();
    }

}

