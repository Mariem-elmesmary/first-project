package data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Data_Provider {
    public static ChromeDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "Provider")
    void TC_A(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.className("fa-sign-in")).click();
        if (username.equals("tomsmith") && password.equals("SuperSecretPassword!")) {
            boolean x = driver.findElement(By.className("flash")).isDisplayed();
            Assert.assertTrue(x);
        } else {
            boolean y = driver.findElement(By.className("flash")).isDisplayed();
            Assert.assertTrue(y);
        }
    }

    @DataProvider(name = "Provider")
    public Object[][] getData() {
        String excelFilePath = "C:\\Users\\HP\\Desktop\\data-Provider.xlsx";
        Object[][] data = null;

        try (FileInputStream fis = new FileInputStream(new File("C:\\Users\\HP\\Desktop\\data-Provider.xlsx"));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount - 1][colCount]; // Exclude header

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = cell.toString(); // Read cell value
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
