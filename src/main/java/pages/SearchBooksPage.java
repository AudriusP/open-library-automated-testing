package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchBooksPage {
    WebDriver driver;

    public SearchBooksPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBookByYearsPublished(int yearsPublished) {
        List<WebElement> books = driver.findElements(By.cssSelector("ul.list-books li"));

        for (WebElement book : books) {
            if (book.getText().contains("First published in " + yearsPublished)) {
                book.findElement(By.cssSelector("span.bookcover ")).click();
                break;
            }
        }

//        Alternative way to select book by years published
//        driver.findElement(By.xpath("//span[@class='publishedYear' and contains(text(), '" + yearsPublished + "')]/../../../span[@class='bookcover ']")).click();
    }
}