package steps;

import POM.LoginPom;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class LoginSDF {

    LoginPom loginPom;

    public LoginSDF() {
        this.loginPom = new LoginPom(DriverSingleton.getInstance());
    }

    @After
    public void quitInstance(){
        DriverSingleton.quitInstance();
    }

    @Given("A user is on the login Page")
    public void a_user_is_on_the_login_page() {
        DriverSingleton.getInstance().get("http://localhost:7000/");
        loginPom.waitForPath("");
        Assertions.assertEquals("http://localhost:7000/", loginPom.getCurrentUrl());
    }

    @When("valid finance manager credentials are inputted")
    public void valid_finance_manager_credentials_are_inputted() {
        loginPom.waitForElements();
        loginPom.login("alincoln", "password");
        loginPom.waitForPath("manager-dashboard/");
    }

    @Then("the finance manager will be sent to the finance manager dashboard")
    public void the_finance_manager_will_be_sent_to_the_finance_manager_dashboard() {
        Assertions.assertEquals("http://localhost:7000/manager-dashboard/", loginPom.getCurrentUrl());
    }

    @When("valid employee credentials are inputted")
    public void valid_employee_credentials_are_inputted() {
        loginPom.waitForElements();
        loginPom.login("user1", "password");
        loginPom.waitForPath("employee-dashboard/");
    }
    @Then("the employee will be sent to the employee dashboard")
    public void the_employee_will_be_sent_to_the_employee_dashboard() {
        Assertions.assertEquals("http://localhost:7000/employee-dashboard/", loginPom.getCurrentUrl());
    }

    @When("invalid credentials are inputted")
    public void invalid_credentials_are_inputted() {
        loginPom.waitForElements();
        loginPom.login("user1", "p4ssw0rd");
    }
    @Then("the user remains on the login page")
    public void the_user_remains_on_the_login_page() {
        Assertions.assertEquals("http://localhost:7000/", loginPom.getCurrentUrl());
    }

}
