package com.testPackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FromFullpageToWebelementScreenshot {
    public static WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @Test
    public void fromFullpageToWebelementScreenshot() throws Exception {
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement element = driver.findElement(By.xpath("//div[@id='divLogo']/img"));

        //get entire page screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        //Get the location, height, width of element on the page
        Point point = element.getLocation();
        int eleHeight = element.getSize().getHeight();
        int eleWidth = element.getSize().getWidth();

        //crop entire page screenshot to get element screenshot only
        try{
            BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
            ImageIO.write(eleScreenshot, "png", screenshot);
        } catch(Exception e) { e.getMessage();}

        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        //copy element screenshot to desired location
        File screenshotLocation = new File("C:\\Workspace\\AutomationTutorials\\CaptureScreenshotWebElementWholePage\\screenshots\\FromFullPageToWebElementScreenShot_" + dateName + ".png");
        FileUtils.copyFile(screenshot, screenshotLocation);

        //close browser
        driver.close();
    }
}
