Feature: Different Element Page check
  In order to assert that elements on the page work as expected
  As a page visitor
  I want to click interface elements and get text in logs according UI element used.
  Scenario: Check checkboxes elements
    Given I open JDI main page
    And I login as user Roman Iovlev
    And I open Different Element Page
    When I click 'Water' checkbox on Different Element Page
    And I click 'Wind' checkbox on Different Element Page
    Then I should see 'Water': condition changed to 'true' in logs bar on the Different Element Page
    And I should see 'Wind': condition changed to 'true' in logs bar on the Different Element Page

  Scenario: Check radio elements
    Given I open JDI main page
    And I login as user Roman Iovlev
    And I open Different Element Page
    When I click 'Selen' radio on Different Element Page
    Then I should see metal: value changed to 'Selen' in logs bar on the Different Element Page

  Scenario: Check dropdown element
    Given I open JDI main page
    And I login as user Roman Iovlev
    And I open Different Element Page
    When I click 'Yellow' option in dropdown on Different Element Page
    Then I should see Colors: value changed to 'Yellow' in logs bar on the Different Element Page
