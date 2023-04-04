import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertEquals;

public class SignUpStepdefs {
    WebDriver driver;
    int time = 800;

    @Before
    public void setup() {
        //setup skapar vår browser
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver_win32/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Given("i have navigated to the website")
    public void iHaveNavigatedToTheWebsite() throws InterruptedException {
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();
        Thread.sleep(time);

    }

    @And("i typed {string}")
    public void iTyped(String Email) throws InterruptedException {
        Thread.sleep(time);
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(Email);
    }

    @And("i entered {string}")
    public void iEntered(String Username) throws InterruptedException {
        Thread.sleep(time);
        /*if (Username != null){
            int randomNum = ((int) (Math.random() * 10000)-9999);
            Username = (Math.abs(randomNum)) + Username;
        }*/
        WebElement username = driver.findElement(By.id("new_username"));
        username.click();
        username.clear();
        username.sendKeys(Username);
    }

    @And("i set {string}")
    public void iSet(String password) throws InterruptedException {
        Thread.sleep(time);
        WebElement Password = driver.findElement(By.id("new_password"));
        Password.sendKeys(password);
    }


    @When("i press Signup")
    public void iPressSignup() throws InterruptedException {

        Thread.sleep(time);
        driver.findElement(By.id("marketing_newsletter")).click();
        driver.findElement(By.id("create-account-enabled")).click();
        Thread.sleep(12000);
    }

@Test
    @Then("user is {string}")
    public void userIs(String created) {
        boolean actual = true;
        boolean expected;
        if (created.equalsIgnoreCase("yes")) {
            expected = true;
        } else {
            expected = false;
        }
        if ((created.equalsIgnoreCase("yes")) && (driver.findElement(By.cssSelector("#signup-success > div > div.content.line.section > section > div > h1")).isDisplayed())) {
            actual = true;
        } else if ((created.equalsIgnoreCase("no")) && (driver.findElement(By.cssSelector("#av-flash-errors > ul > li")).isDisplayed())) {
            actual = false;
        } else if ((created.equalsIgnoreCase("no")) && (driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(2) > div > span")).isDisplayed())) {
            actual = false;

            assertEquals(expected, actual);

        }
    }
@Test
    @Then("user is not {string}")
    public void userIsNot(String created) {
        boolean actual = true;
        boolean expected;
        if (created.equalsIgnoreCase("yes")) {
            expected = true;
        } else {
            expected = false;
        }
        if ((created.equalsIgnoreCase("no")) && (driver.findElement(By.xpath("//*[@id=\"signup-form\"]/fieldset/div[1]/div/span")).isDisplayed())) {
            actual = false;
        }

        assertEquals(expected, actual);
    }
}


