package com.testPackage;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.utility.ListenerClass.class)
public class TestClass extends BaseClass {
    @Test
    public void test03(){
        setup();
        driver.findElement(By.name("q")).sendKeys("Córdoba - Argentina");
        Assert.assertTrue(false);
    }

    @Test
    public void test04(){
        setup();
        driver.findElement(By.name("q")).sendKeys("React & JavaScript");
        Assert.assertTrue(false);
    }

    @Test
    public void test05(){
        setup();
        driver.findElement(By.name("q")).sendKeys("Misiones - Argentina");
        Assert.assertTrue(false);
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
