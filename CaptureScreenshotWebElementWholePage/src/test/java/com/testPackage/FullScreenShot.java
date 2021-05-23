package com.testPackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;

public class FullScreenShot {
    public static WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @Test
    public void fullPageScreenShot() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationtestinginsider.com/p/selenium-vi.html");

        //create an object of AShot() class and set image strategy by shootingStrategy
        //and viewportPasting() method and take a screenshot using takeScreenshot method
        Screenshot Screenshot = new AShot()
                .shootingStrategy(ShootingStrategies
                        .viewportPasting(500)).takeScreenshot(driver);

        //copy screenshot to desired location
        try{
            ImageIO.write(Screenshot.getImage(), "png",
                    new File("C:\\Workspace\\AutomationTutorials\\CaptureScreenshotWebElementWholePage\\screenshots\\FullScreenShot.png"));
        }catch(Exception e){ e.getMessage();}

        driver.close();
    }
}
