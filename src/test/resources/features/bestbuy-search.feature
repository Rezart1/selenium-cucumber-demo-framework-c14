Feature: Search functionality

  Scenario Outline: User can search for a product
    Given user navigates to best buy
    When user enters "<productName>" in search box
    #TODO - Create a step that asserts that all results on the page relate to the search input
    Examples:
    * quit the driver
    @smartphones
    |productName       |
    |iPhone pro 15     |
    |Samsung Galaxy 24 |
    |Google Pixel 2024 |

    @laptops
    Examples:
      |productName      |
      |Mac Book Pro M3  |
      |Acer 2024 Laptop |
      |Hp 2024 Laptop   |
