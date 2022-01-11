Feature: Login Page
    Scenario: An employee can login with valid credentials and be redirected to the employee dashboard
        Given A user is on the login Page
        When valid employee credentials are inputted
        Then the employee will be sent to the employee dashboard
    Scenario: A finance manager can login with valid credentials and be redirect to the finance manager dashboard
        Given A user is on the login Page
        When valid finance manager credentials are inputted
        Then the finance manager will be sent to the finance manager dashboard
    Scenario: Invalid credentials will keep the user on the login page
        Given A user is on the login Page
        When invalid credentials are inputted
        Then the user remains on the login page
