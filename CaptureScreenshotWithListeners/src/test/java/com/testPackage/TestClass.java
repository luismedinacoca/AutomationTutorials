package com.testPackage;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestClass extends BaseClass {
    @Test
    public void test03(){
        setup();
        driver.findElement(By.name("q")).sendKeys("Crowdar Automation");
        driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).click();
        Assert.assertTrue(false);
    }

    @Test
    public void test04(){
        setup();
        driver.findElement(By.name("q")).sendKeys("Wolox and AiCore");
        driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).click();
        Assert.assertTrue(false);
    }

    @Test
    public void test05(){
        setup();
        driver.findElement(By.name("q")).sendKeys("Wakapi - Mendoza");
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
