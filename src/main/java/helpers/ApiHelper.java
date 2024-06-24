package helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiHelper {

    public ApiHelper() {
        RestAssured.baseURI = "https://openlibrary.org/";
    }

    public String getBookAuthorByBookTitle(String bookTitle, int yearsPublished) {
        Response response = RestAssured.get("search.json?q=title:" + bookTitle + " first_publish_year:" + yearsPublished);
        return response.jsonPath().get("docs[0].author_name[0]").toString();
    }
}