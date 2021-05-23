package com.testPackage;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ScreenshotTest extends BaseClass {

    @Test
    public void test01(){
        setup();
        driver.findElement(By.name("q")).sendKeys("Belatrix - Mendoza");
        driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).click();
        Assert.assertTrue(false);
    }

    @Test
    public void test02(){
        setup();
        driver.findElement(By.name("q")).sendKeys("Globant");
        driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).click();
        Assert.assertTrue(false);
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
