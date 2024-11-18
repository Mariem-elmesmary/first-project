package P03_LandingPage;

import Features.landing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Landing_page {
    public WebElement scroll() {
        return landing.driver.findElement(By.xpath("//h2[.='Hot Sellers']"));
    }

    public List<WebElement> item_card() {
        return landing.driver.findElements(By.className("product-item-info"));
    }
    public WebElement productprice(){
        return landing.driver.findElement(By.cssSelector("div[data-role=\"priceBox\"]"));
    }
public WebElement addtocart(){
        return landing.driver.findElement(By.xpath("//a[@title=\"Breathe-Easy Tank\"]//parent::strong//parent::div//parent::button//span"));
}
public WebElement hover(){
        return landing.driver.findElement(By.xpath("//img[@alt='Breathe-Easy Tank']"));
}
public WebElement size(){
return landing.driver.findElement(By.xpath("//a[@title=\"Breathe-Easy Tank\"]//parent::strong//parent::div//div//div//div//div[3]"));
}
public WebElement color(){
        return landing.driver.findElement(By.cssSelector("div[option-label=\"Yellow\"]"));
}
public WebElement number(){
        return landing.driver.findElement(By.className("counter-number"));
}
}