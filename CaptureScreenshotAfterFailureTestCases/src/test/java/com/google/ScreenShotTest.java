package com.google;

import com.utility.TakeScreenShot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShotTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void test01(){
        driver.findElement(By.name("q")).sendKeys("Mendoza - Argentina");
        Assert.assertTrue(false);
    }

    @Test
    public void test02(){
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.FAILURE==result.getStatus()){
            TakeScreenShot.takingSreenshot(driver, result.getName());
        }

        if(driver != null){
            driver.quit();
        }
    }

}
