package P01_Register;

import Features.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class homepage {
    public WebElement click(){
        return Register.driver.findElement(By.linkText("Create an Account"));
    }

}
