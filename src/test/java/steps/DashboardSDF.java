package steps;

import POM.DashboardPom;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class DashboardSDF {

    DashboardPom dashboardPom;

    String requestId;

    public DashboardSDF(){
        this.dashboardPom = new DashboardPom(DriverSingleton.getInstance());
    }

    @Given("a finance manager is on the finance manager dashboard")
    public void a_finance_manager_is_on_the_finance_manager_dashboard() {
        Assertions.assertEquals("http://localhost:7000/manager-dashboard/", dashboardPom.getCurrentUrl());
        dashboardPom.waitForRequests();
    }
    @When("the finance manager clicks approve on a pending reimbursement")
    public void the_finance_manager_clicks_approve_on_a_pending_reimbursement() {
        requestId = dashboardPom.approve();
    }

    @Then("the reimbursement status will display approved")
    public void the_reimbursement_status_will_display_approved() {
        Assertions.assertEquals("Status: APPROVED", dashboardPom.waitForStatus(requestId, "APPROVED"));
    }

    @When("the finance manager clicks deny on a pending reimbursement")
    public void the_finance_manager_clicks_deny_on_a_pending_reimbursement() {
        requestId = dashboardPom.deny();

    }
    @Then("the reimbursement status will display denied")
    public void the_reimbursement_status_will_display_denied() {
        Assertions.assertEquals("Status: DENIED", dashboardPom.waitForStatus(requestId, "DENIED"));
    }
}
