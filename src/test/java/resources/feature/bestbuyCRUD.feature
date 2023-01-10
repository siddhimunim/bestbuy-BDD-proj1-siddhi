Feature: Best Buy Application

  As a user I want to test Best Buy Application

  Scenario Outline: Product Api CRUD Test
    Given Best buy application is running
    When I create a new product by providing the information name "<name>" type "<type>" price "<price>" shipping "<shipping>" upc "<upc>" description "<description>" manufacturer "<manufacturer>" model "<model>" url "<url>" image "<image>"
    Then I verify that the product with name "<name>" is created
    And I update product by providing the information name "<name>" type "<type>" price "<price>" shipping "<shipping>" upc "<upc>" description "<description>" manufacturer "<manufacturer>" model "<model>" url "<url>" image "<image>"
    And The product with name "<name>" is updated successfully
    And I delete the product that created with name "<name>"
    Then The product deleted successfully from the application
    Examples:
      | name           | type        | price | shipping | upc    | description                          | manufacturer    | model     | url                         | image                                           |
      | Gucci          | perfume     | 100   | 15       | 987654 | unisex                               | perfum catagory | MN2727B4z | http://www.google.com/image | http://dummyimage.com/128x100.png/ff4444/ffffff |
      | GHD hair dryer | electronics | 114   | 14       | 988547 | with select electronic devices plugs | ghdCompany      | MN2525B4  | http://www.yahoo.com/image  | http://dummyimage.com/214x100.png/5fa2dd/ffffff |

  Scenario Outline: Store Api CRUD Test
    Given Best buy application is running
    When I create a new store by providing the information name "<name>" type "<type>" address "<address>" addresstwo "<address2>" city "<city>" state "<state>" zip "<zip>" lat "<lat>" lng "<lng>" hours "<hours>"
    Then I verify that the store with name "<name>" is created
    And I update store by providing the information name "<name>" type "<type>" address "<address>" addresstwo "<address2>" city "<city>" state "<state>" zip "<zip>" lat "<lat>" lng "<lng>" hours "<hours>"
    And The store with name "<name>" is updated successfully
    And I delete the store that created with name "<name>"
    Then The store deleted successfully from the application
    Examples:
      | name   | type        | address          | address2 | city     | state   | zip   | lat | lng | hours      |
      | argos  | electronics | 45 london street | LE 40    | London   | Harrow  | 54534 | 98  | 67  | 8am to 8pm |
      | currys | appliences  | 30 dam street    | GB 98    | Coventry | midland | 858   | 459 | 489 | 8am to 8pm |
