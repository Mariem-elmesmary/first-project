package Features;

import P03_LandingPage.Landing_page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class landing {
    By viewthebutton=By.xpath("//span[.=\"Add to Cart\"]");
    public static ChromeDriver driver;
    Landing_page land = new Landing_page();
    SoftAssert soft = new SoftAssert();

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_1() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", land.scroll());
        boolean x = land.scroll().isDisplayed();
        soft.assertTrue(x, "Hot Sellers section is not displayed!");

        List<WebElement> item_card = land.item_card();
        boolean z=land.productprice().getText().contains("$");
        soft.assertTrue(z,"$ is not found");
        soft.assertAll();
        for (WebElement card : item_card) {
            WebElement cardprice = land.productprice();
            String priceText = cardprice.getText().replace("As low as", "").replace("$", "").trim();
            System.out.println("price is" + priceText);
            double price = 0;
            price = Double.parseDouble(priceText);
            if (!priceText.contains("."))
            {
                throw new AssertionError("price is an integer not double" + priceText);
            }
        }

    }
    @Test
    public void TC_2(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", land.scroll());
        boolean x = land.scroll().isDisplayed();
        soft.assertTrue(x, "Hot Sellers section is not displayed!");
        List<WebElement> item_card = land.item_card();
        boolean h=land.productprice().getText().contains("Add to Cart");
        soft.assertTrue(h,"add to cart is not found");
        boolean z=land.addtocart().isDisplayed();
        soft.assertTrue(z,"button ");
        JavascriptExecutor jss =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",land.addtocart());

    }
    @Test
    public void TC_3(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", land.scroll());
        boolean x = land.scroll().isDisplayed();
        soft.assertTrue(x, "Hot Sellers section is not displayed!");

        Actions act = new Actions(driver);
       act.moveToElement(land.hover()).perform();
        WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitt.until(ExpectedConditions.presenceOfElementLocated(viewthebutton));
        land.size().click();
        JavascriptExecutor jsss = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",land.color());
        js.executeScript("arguments[0].click();",land.addtocart());
        boolean a=land.number().getText().contains("1");
        soft.assertTrue(a,"no items");

    }
   @AfterMethod
void end(){
       driver.quit();
    }
}
