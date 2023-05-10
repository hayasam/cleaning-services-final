package app;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddOrdertest {
    String day, month, year, time;
    String status="wating";
    String status1="intreatment";
    Customer customer;
    Record record = new Record();

    public AddOrdertest() {
        customer = new Customer("anass", "anass123","0595642329","Jenin", "Customer");
        customer.signIn("anass", "anass123");
        record.addOrder(new Order("05", "01", "2022", "11","watimg"), customer);
        record.addOrder(new Order("14", "05", "2022", "3","intreatment"), customer);
    }

    @Given("the customer is logged in")
    public void the_customer_is_logged_in() {
        assertTrue(customer.isSignedIn());
    }

    @Given("he\\/she choose day {string}")
    public void he_she_choose_day(String string) {
        this.day = string;
    }

    @Given("he\\/she choose month {string}")
    public void he_she_choose_month(String string) {
        this.month = string;
    }

    @Given("he\\/she choose year {string}")
    public void he_she_choose_year(String string) {
        this.year = string;
    }

    @Given("he\\/she choose time {string}")
    public void he_she_choose_time(String string) {
        this.time = string;
    }

    @Then("this order will book for this customer")
    public void this_order_will_book_for_this_customer() {
        assertTrue(record.addOrder(new Order(day, month, year, time,status), customer));
    }

    @Then("the error message {string} will appear")
    public void the_error_message_will_appear(String string) {
        assertFalse(record.addOrder(new Order(day, month, year, time,status1), customer));

    }
}