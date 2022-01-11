Feature: Finance Manager Dashboard Page
    Background: Finance Manager is on the Finance Manager Dashboard
        Given A user is on the login Page
        When valid finance manager credentials are inputted
        Then the finance manager will be sent to the finance manager dashboard
    Scenario: A Finance Manager can approve a pending reimbursement
        Given a finance manager is on the finance manager dashboard
        When the finance manager clicks approve on a pending reimbursement
        Then the reimbursement status will display approved
    Scenario: A Finance Manager can deny a pending reimbursement
        Given a finance manager is on the finance manager dashboard
        When the finance manager clicks deny on a pending reimbursement
        Then the reimbursement status will display denied