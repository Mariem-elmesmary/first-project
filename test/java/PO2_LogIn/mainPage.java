package PO2_LogIn;

import Features.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class mainPage {
    public WebElement signinButton(){
        return Login.driver.findElement(By.className("authorization-link"));
    }
}
