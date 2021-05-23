package com.testPackage;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.utility.ListenerClass.class)
public class ScreenshotTest extends BaseClass {

    @Test
    public void test01(){
        setup();
        driver.findElement(By.name("q")).sendKeys("Mendoza - Argentina");
        Assert.assertTrue(false);
    }

    @Test
    public void test02(){
        setup();
        driver.findElement(By.name("q")).sendKeys("Selenium - Automation with Java");
        Assert.assertTrue(false);
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
