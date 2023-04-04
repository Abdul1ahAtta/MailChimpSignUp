Feature: SignUp

  Scenario Outline: Create user
    Given i have navigated to the website
    And i typed "<Email>"
    And i entered "<Username>"
    And i set "<password>"
    When i press Signup
    Then user is "<created>"

    Examples:
      | Email                      | Username                                                                                                                    | password       | created |
      | blablabla166@gmail.com     | BalaaBala3367779901111                                                                                                      | BalaBala1234@  | yes     |
      | blablabla12366@gmail.com   | BalaaBala3367779901111                                                                                                      | BalaBala12345@ | no      |
      | blablablalong666@gmail.com | 6667BalaBala123BalaBala11232BbbalaBala123BajdsbhsbdkhvbcdkavklaBala123BalaBala123BalaBala123BalaBala123BalaBala123BalaBala1 | BalaBala123@   | no      |


  Scenario Outline: Create user
    Given i have navigated to the website
    And i typed "<Email>"
    And i entered "<Username>"
    And i set "<password>"
    When i press Signup
    Then user is not "<created>"
    Examples:
      | Email | Username                 | password       | created |
      |       | BalaBala3367779991121111 | BalaBala12345@ | no      |
