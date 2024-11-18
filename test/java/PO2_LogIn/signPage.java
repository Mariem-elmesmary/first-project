package PO2_LogIn;

import Features.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class signPage {

    public WebElement emaill(){
        return Login.driver.findElement(By.name("login[username]"));
    }
    public WebElement passwordd(){
        return Login.driver.findElement(By.name("login[password]"));
    }
    public WebElement clickk(){
        return Login.driver.findElement(By.xpath("//button[contains(@class, 'primary')]"));
    }
    public WebElement welcome(){
        return Login.driver.findElement(By.className("welcome"));
    }




}
