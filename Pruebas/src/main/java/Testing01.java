import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Testing01 {
    public static void main (String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://demo.automationtesting.in/Windows.html");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();

        Thread.sleep(2000);

        Set<String> s = driver.getWindowHandles();

        for(String i : s){
            String t = driver.switchTo().window(i).getTitle();
            System.out.println(t);
            if(t.contains("Frames & windows")){
                driver.close();
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
