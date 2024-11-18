package P01_Register;

import Features.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class createpage {
    public WebElement firstname() {
        return Register.driver.findElement(By.id("firstname"));
    }

    public WebElement lastName() {
        return Register.driver.findElement(By.id("lastname"));
    }

    public WebElement email() {
        return Register.driver.findElement(By.name("email"));
    }

    public WebElement password() {
        return Register.driver.findElement(By.id("password"));
    }

    public WebElement createButton() {
        return Register.driver.findElement(By.cssSelector("button[title=\"Create an Account\"]"));
    }

    public WebElement required() {
        return Register.driver.findElement(By.cssSelector("div[for=\"password-confirmation\"]"));
    }

    public WebElement confirm() {
        return Register.driver.findElement(By.name("password_confirmation"));
    }
    public WebElement contain(){
        return Register.driver.findElement(By.className("box-information"));
    }
}


