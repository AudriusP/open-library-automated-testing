package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage {
    WebDriver driver;
    @FindBy(css = "div.desktop a[itemprop='author']")
    private WebElement author;

    public BookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyBookAuthor(String bookAuthor) {
        Assert.assertEquals(author.getText(), bookAuthor);
    }
}