Feature: carTest.feature

  Background:
    Given user is on the Main page cars.com

  Scenario: compare cars
    When click Research from Main menu
    And select car with random parameters
    And click CompareTrims on just opened Car page
    Then opened CompareTrims page contains selected make, model, year
    And go back to the main page

    #selection of another car ( repeating steps 2-5)
    When click Research from Main menu
    And select car with random parameters
    And click CompareTrims on just opened Car page
    Then opened CompareTrims page contains selected make, model, year


    #comparison of two selected cars
    When click Research from Main menu
    And go to Side-By-Side Comparisons
    And select first car
    And add to comparison another car
    Then characteristics of the selected cars are correct












