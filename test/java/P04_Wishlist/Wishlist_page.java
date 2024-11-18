package P04_Wishlist;


import Features.Wishlist;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Wishlist_page {
    public WebElement signin(){
        return Wishlist.driver.findElement(By.className("authorization-link"));
    }
    public WebElement emaill(){
        return Wishlist.driver.findElement(By.name("login[username]"));
    }
    public WebElement passwordd(){
        return Wishlist.driver.findElement(By.name("login[password]"));
    }
    public WebElement clickk(){
        return Wishlist.driver.findElement(By.xpath("//button[contains(@class, 'primary')]"));
    }
    public WebElement scrollto() {
    return Wishlist.driver.findElement(By.xpath("//h2[.='Hot Sellers']"));
}
public WebElement card() {
    return Wishlist.driver.findElement(By.xpath("//img[@alt='Breathe-Easy Tank']"));
}
public WebElement addtowishlist_Button(){
        return Wishlist.driver.findElement(By.xpath("//a[@title=\"Breathe-Easy Tank\"]//parent::strong//parent::div//div//div//div//span//parent::a"));
}
public WebElement product (){
        return Wishlist.driver.findElement(By.className("product-item-details"));
}

}
