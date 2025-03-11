package POM;

import Core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class ChallengePage extends BaseTest {
    WebDriver driver;
    private WebDriverWait wait;

    By dropdown = By.xpath("//a[@data-toggle='dropdown'][1]");
    By createChallenge = By.xpath("(//a[contains(normalize-space(), 'Create Challenge')])[1]");
    By titleInput = By.id("title");
    By flagInput = By.id("flag");
    By descriptionInput = By.id("flask-pagedown-description");
    By fileUpload = By.id("file-upload");
    By categoryInput = By.id("category");
    By points = By.id("points");
    By howToSolve = By.id("howtosolve");
    By sumbitButton = By.xpath("//button[text()='Submit for Verification']");
    By myChallenges = By.xpath("(//a[contains(normalize-space(), 'My Challenges')])[1]");
    By myChallengeSubject = By.xpath("//h1");
    By myChallengeTitle = By.xpath("(//div[@class='card-header d-flex']//span)[1]");
    By myChallengePoints = By.xpath("(//span[@class='font-weight-bolder'])[1]");

    public ChallengePage(WebDriver driver) {
//         super(driver);
         this.driver = driver;
         this.wait = new WebDriverWait(driver, 30);
    }
         public void navigateToCreateChallenge(){
             driver.findElement(dropdown).click();
             wait.until(ExpectedConditions.visibilityOfElementLocated(createChallenge)).click();
//           driver.findElement(myChallenge).click();
//             driver.findElement(createChallenge).click();
         };

        public void createChallenge(String title, String flag, String file,String description, String howtosolve) {
            driver.findElement(titleInput).clear();
            driver.findElement(titleInput).sendKeys(title);
            driver.findElement(flagInput).sendKeys(flag);
            WebElement descriptionElement = driver.findElement(descriptionInput);
            descriptionElement.clear();
            descriptionElement.sendKeys(description);
            driver.findElement(howToSolve).sendKeys(howtosolve);
            driver.findElement(fileUpload).sendKeys(file);

            // Randomly a category
            WebElement categoryDropdown = driver.findElement(categoryInput);
            Select selectCategory = new Select(categoryDropdown);
            List<WebElement> optionsCategory = selectCategory.getOptions();
            int randomIndexCategory = new Random().nextInt(optionsCategory.size());
            selectCategory.selectByIndex(randomIndexCategory);

            // Select the random option
            WebElement pointsDropdown = driver.findElement(points);
            Select selectPoint = new Select(pointsDropdown);
            List<WebElement> options = selectPoint.getOptions();
            int randomIndexPoint = new Random().nextInt(options.size());
            selectPoint.selectByIndex(randomIndexPoint);

            driver.findElement(sumbitButton).click();
            wait.withTimeout(Duration.ofSeconds(15));
        }

        public void viewMyChallenge(String createdUser, String createdTitle){
            driver.findElement(dropdown).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(myChallenges)).click();
            WebElement subject = driver.findElement(myChallengeSubject);
            String subjectText = subject.getText();
            WebElement title = driver.findElement(myChallengeTitle);
            String titletText = title.getText();
            WebElement points = driver.findElement(myChallengePoints);
            String pointNumber = points.getText();
            String expectedSubject = "Challenges by " + createdUser;
            assertEquals(subjectText, expectedSubject);
            assertEquals(titletText, createdTitle);
        }
}



