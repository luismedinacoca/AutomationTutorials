package com.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    public static WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    public void setup(){
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    public void screenShot(String fileName){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(source, new File(projectPath + "\\screenshots\\"+fileName+".png"));
        } catch (IOException e) {
            e.getMessage();
        }    }
}
