Feature: Book search

  Scenario Outline: Search for book
    Given User goes to the OpenLibrary page "https://openlibrary.org/"
    And User sets website in "English"
    When User searches using Title option for book "<bookTitle>"
    And User chooses book published in <publishedYear>
    And Get author from API for book "<bookTitle>" published in <publishedYear>
    Then Author from API matches author on book page

    Examples:
      | bookTitle                                                                               | publishedYear |
      | Clean Code: A Comprehensive Beginner's Guide to Learn the Realms of Clean Code from A-Z | 2020          |
      | Hamlet                                                                                  | 1508          |