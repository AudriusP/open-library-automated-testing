package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBooksPage {
    WebDriver driver;

    public SearchBooksPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBookByYearsPublished(String yearsPublished) {
        driver.findElement(By.xpath("//span[@class='publishedYear' and contains(text(), '" + yearsPublished + "')]/../../../span[@class='bookcover ']")).click();
    }
}