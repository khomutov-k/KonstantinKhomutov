Feature: User Table Page table data check.
  Checks User Table Page
  Scenario Outline: User Table Page test
  Given I open JDI main page
  And I login as user Roman Iovlev
  When I click on 'Service' button in Header
  And I click on 'User Table' button in Service dropdown
  Then User Table page should be opened
  And Dropdown should be displayed in '<Number>' row at Users Table
  And Username should be displayed in '<Number>' row as '<Username>' at Users Table
  And Description text under image in '<Number>' row should be displayed as '<Description>'
  And Checkboxes should be displayed in '<Number>' row at Users Table on User Table Page
    Examples:
      | Number |Username          |Description                       |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulksome description             |
  Scenario Outline: User Table Page dropdown test
    Given I open JDI main page
    And I login as user Roman Iovlev
    When I click on 'Service' button in Header
    And I click on 'User Table' button in Service dropdown
    Then User Table page should be opened
    And Dropdown should have '<Option>' for user 'Roman' at Users Table
    Examples:
    |Option |
    |Admin  |
    |User   |
    |Manager|