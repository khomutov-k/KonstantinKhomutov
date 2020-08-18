Feature: exercise 3 scenario.
  Scenario: Vip checkbox check
  Given I open JDI main page
  And I login as user Roman Iovlev
  And I click on "Service" button in Header
  And I click on "User Table" button in Service dropdown
  When I select vip checkbox for "Sergey Ivan"
  Then Log row has "Vip: condition changed to true" text in log section
