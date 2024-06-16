package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    @FindBy(css = "div.language-component")
    private WebElement languageButton;
    @FindBy(css = "div.search-facet select")
    private WebElement searchTypeDropDown;
    @FindBy(css = "form.search-bar-input input[type='text']")
    private WebElement bookSearchField;
    @FindBy(css = "input.search-bar-submit")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void changeLanguage(String language) {
        languageButton.click();
        waitForLanguagesDropdownToAppear();
        driver.findElement(By.cssSelector("ul.locale-options.dropdown-menu li a[title='" + language + "']")).click();
    }

    public void searchBookByTitle(String bookTitle) {
        new Select(searchTypeDropDown).selectByValue("title");
        bookSearchField.sendKeys(bookTitle);
        searchButton.click();
    }

    private void waitForLanguagesDropdownToAppear() {
        new WebDriverWait(this.driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.language-dropdown-component")));
    }
}