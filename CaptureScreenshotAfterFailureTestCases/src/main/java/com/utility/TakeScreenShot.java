package com.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenShot {
    
    public static void takingSreenshot(WebDriver driver, String fileName){
        String projectPath = System.getProperty("user.dir");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(source, new File(projectPath + "\\Screenshot\\"+fileName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
