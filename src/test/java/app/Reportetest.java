package app;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class Reportetest {
    String day, month, year, time;
    Customer customer;
    Secretary secretary;
    Record record = new Record();
    int numOfVisits = 0;
    Report report = new Report();
    String date;

    ArrayList<Service> servicesList = new ArrayList<Service>();

    public Reportetest() {
        customer = new Customer("anas", "anas123","0595642329","Jenin", "Customer");
        customer.signIn("anas", "anas123");
        secretary = new Secretary("sara", "sara123","0595642325","Gaza","Secretary");
        secretary.signIn("sara", "sara123");
        record.addOrder(new Order("05", "01", "2023", "11","waiting"), customer);
        record.addOrder(new Order("02", "05", "2023", "9","treatment"), customer);
        record.addOrder(new Order("14", "05", "2023", "3","treatment"), customer);

        record.addVisit(new Order("05", "01", "2023", "11","waiting"));
        record.addVisit(new Order("02", "05", "2023", "9","waiting"));
        record.addVisit(new Order("14", "05", "2023", "3","waiting"));

        servicesList.add(new Service("Cleaning carpets", 50, 250.00,"9 m2 ","silk"));
        servicesList.add(new Service("Cleaning covers", 0, 50.00,"3 m2 ","cotton"));
        servicesList.add(new Service("Cleaning  carpets and covers", 50, 500.00,"6 m2 ","wool"));
    }


    @When("the secretary is logged in")
    public void the_secretary_is_logged_in() {

    }

    @When("and he\\/she want to check the number of visitors in a certain month {string}")
    public void and_he_she_want_to_check_the_number_of_visitors_in_a_certain_month(String string) {
        this.month = string;

    }

    @When("he choose visitors list for a certain month")
    public void he_choose_visitors_list_for_a_certain_month() {
        for (int i = 0; i < record.getOrders().size(); i++) {
            if (record.getType().get(i) == 2 && record.getOrders().get(i).getMonth().equals(month)) {
                date = record.getOrders().get(i).getDay() + "/" + record.getOrders().get(i).getMonth() + "/" + record.getOrders().get(i).getYear();
                time = record.getOrders().get(i).getTime();
                numOfVisits++;
            }
        }

    }

    @When("click on button {string}")
    public void click_on_button(String string) {
    }

    @Then("a report of number of visitors will be generated")
    public void a_report_of_number_of_visitors_will_be_generated() {
        assertTrue(report.numOfVisitsReport(numOfVisits, month));
    }

    @When("and he\\/she want to check the number of available services")
    public void and_he_she_want_to_check_the_number_of_available_services() {

    }

    @When("he\\/she choose services list")
    public void he_she_choose_services_list() {

    }

    @Then("a report of available services will be generated")
    public void a_report_of_available_services_will_be_generated() {
        assertTrue(report.availableServicesReport(servicesList));

    }

}
