Feature: Functional
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: check Invalid ZIP Code message
    Given User opens '<homePage>' page
    And User checks location popover visibility
    When User clicks location button
    And User checks zip code field visibility
    And User enters invalid zipcode '<zipcode>'
    And User clicks zipcode button
    Then User gets *INVALID ZIPCODE* message

    Examples:
      | homePage                | zipcode |
      | https://www.amazon.com/ | str     |

  Scenario Outline: change delivery country
    Given User opens '<homePage>' page
    And User checks location popover visibility
    When User clicks location button
    And User checks country list button visibility
    And User clicks country list button
    And User checks country list dropdown visibility
    And User chooses country from the list
    And User clicks done button
    Then delivery country changes to '<country>'

    Examples:
      | homePage                  | country |
      | https://www.amazon.com/   | Canada  |

  Scenario Outline: empty email sign in error message
    Given User opens '<homePage>' page
    And User checks sign in button visibility
    When User opens sign in page
    And User checks email field visibility
    And User clicks sign in button on sign in page
    Then User gets error message

    Examples:
      | homePage                  |
      | https://www.amazon.com/   |

  Scenario Outline: search products contain search word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that all products contain search '<keyword>'

    Examples:
      | homePage                | keyword |
      | https://www.amazon.com/ | mouse   |

  Scenario Outline: filter search query by brand
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User checks brand filters visibility
    And User filters by brand
    Then User checks filtered product visibility

    Examples:
    | homePage                | keyword |
    | https://www.amazon.com/ | pencil  |

  Scenario Outline: language change on Customer Preference Page
    Given User opens '<homePage>' page
    And User checks customer preference button visibility
    When User clicks customer preference button
    And User checks language list visibility
    And User chooses language
    Then User checks that current url contains 'es' language

    Examples:
    | homePage                  |
    | https://www.amazon.com/   |

  Scenario Outline: currency change on Customer Preference Page
    Given User opens '<homePage>' page
    And User checks customer preference button visibility
    When User clicks customer preference button
    And User checks currency list visibility
    And User chooses currency
    And User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that price contains '<symbol>'

    Examples:
    | homePage                | keyword | symbol |
    | https://www.amazon.com/ | blush   | EUR    |

  Scenario Outline: check paging on Category Page
    Given User opens '<homePage>' page
    And User checks shop by category button visibility
    And User clicks shop by category button
    And User selects computer category
    And User selects monitors category
    And Users checks next page button visibility
    When Users clicks next page button
    Then User checks that page changes to '<page>'

    Examples:
    | homePage                | page |
    | https://www.amazon.com/ | 2    |

  Scenario Outline: check review rating filter
    Given User opens '<homePage>' page
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User opens product page
    And User checks customer review button visibility
    And User clicks customer review button
    When User filters reviews by rating
    Then User checks that '<rating>' equals filter

    Examples:
    | homePage                | rating | keyword   |
    | https://www.amazon.com/ | 1      | eyeshadow |

  Scenario Outline: check Store Page visibility
    Given User opens '<homePage>' page
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User opens product page
    And User checks store page link visibility
    When User click store page
    Then User checks that store page opens

    Examples:
    | homePage                | keyword  |
    | https://www.amazon.com/ | lipstick |


