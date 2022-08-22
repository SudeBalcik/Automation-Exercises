package TestCase2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestStart {
    WebDriver driver;

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        System.out.println("Finish");
    }



    // Navigate to url 'http://automationexercise.com'
    //Verify that home page is visible successfully
    @Test
    public void test01() {
driver.get("https://automationexercise.com/");
        WebElement homepage=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        System.out.println(homepage.getText());
        //Assertions usage

        String actualYaziStr= homepage.getText();
        String expectedBulunacakkelime="Home";
        Assert.assertTrue(actualYaziStr.contains(expectedBulunacakkelime));




    //Click on 'Signup / Login' button
   // Verify 'Login to your account' is visible

            WebElement SignupButton = driver.findElement(By.xpath("//a[@href='/login']"));
            SignupButton.click();
            WebElement loginyazi= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
            System.out.println(loginyazi.getText());

            String actualLoginYazi=loginyazi.getText();
            String expectedLoginYazi="Login to your account";
            Assert.assertTrue(actualLoginYazi.contains(expectedLoginYazi));


        //Enter correct email address and password
        //Click 'login' button


        Actions actions=new Actions(driver);
        WebElement EmailAddress = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        EmailAddress.sendKeys("sude11@gmail.com");
        actions.sendKeys(Keys.TAB)
                .sendKeys("123456")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();


        //Verify that 'Logged in as username' is visible

        WebElement usernameButton= driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        System.out.println(usernameButton.getText());

        String actualusernameButtonYazi=usernameButton.getText();
        String expectedusernameButtonYazi="Logged in as Sude";
        Assert.assertTrue(actualusernameButtonYazi.contains(expectedusernameButtonYazi));

   }





    //Click 'Delete Account' button
    //Verify that 'ACCOUNT DELETED!' is visible



}
