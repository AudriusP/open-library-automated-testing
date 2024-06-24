package openLibrary;

import helpers.ApiHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookPage;
import pages.MainPage;
import pages.SearchBooksPage;

import java.time.Duration;

public class StepsDefinition {
    public static WebDriver driver;
    private ApiHelper apiHelper;
    private MainPage mainPage;
    private SearchBooksPage searchBooksPage;
    private BookPage bookPage;
    private String bookAuthor;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        apiHelper = new ApiHelper();
        mainPage = new MainPage(driver);
        searchBooksPage = new SearchBooksPage(driver);
        bookPage = new BookPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("User goes to the OpenLibrary page {string}")
    public void userGoesToTheOpenLibraryPage(String pageUrl) {
        driver.get(pageUrl);
    }

    @And("User sets website in {string}")
    public void userSetsWebsiteIn(String language) {
        mainPage.changeLanguage(language);
    }

    @When("User searches using Title option for book {string}")
    public void userSearchesUsingTitleOptionForBook(String bookTitle) {
        mainPage.searchBookByTitle(bookTitle);
    }

    @And("User chooses book published in {int}")
    public void userChoosesBookPublishedIn(int yearsPublished) {
        searchBooksPage.selectBookByYearsPublished(yearsPublished);

    }

    @And("Get author from API for book {string} published in {int}")
    public void getAuthorFromAPIForBook(String bookTitle, int yearsPublished) {
        bookAuthor = apiHelper.getBookAuthorByBookTitle(bookTitle, yearsPublished);
    }

    @Then("Author from API matches author on book page")
    public void authorFromAPIMatchesAuthorOnBookPage() {
        bookPage.verifyBookAuthor(bookAuthor);
    }
}