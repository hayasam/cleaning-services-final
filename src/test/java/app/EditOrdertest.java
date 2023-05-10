package app;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EditOrdertest {

    String day, month, year, time;
    Customer customer;
    Order oldOrder = new Order("05", "01", "2023", "11","wating");
    Order newdOrder;
    Record record = new Record();

    public EditOrdertest() {
        customer = new Customer("anas", "anas123","0595642329","Jenin", "Customer");
        customer.signIn("anas", "anas123");
        record.addOrder(oldOrder, customer);
        record.addOrder(new Order("14", "05", "2022", "3","intreatment"), customer);
    }

    @Given("he\\/she want to edit this order to another time")
    public void he_she_want_to_edit_this_order_to_another_time() {
    }

    @When("he\\/she click on {string} button Next to each order")
    public void he_she_click_on_button_next_to_each_order(String string) {
    }

    @When("he\\/she should  choose another avaliable order to book")
    public void he_she_should_choose_another_avaliable_order_to_book() {
        newdOrder = new Order("20", "03", "2023", "1","wating");

    }

    @Then("this order will be booked for this customer")
    public void this_order_will_be_booked_for_this_customer() {
        assertTrue(record.editOrder(oldOrder, newdOrder));
    }



    @When("he\\/she  choose unavailable time")
    public void he_she_choose_unavailable_time() {
        newdOrder = new Order("14", "05", "2023", "3","intreatment");
        assertFalse(record.editOrder(oldOrder, newdOrder));
    }

    @Then("error message will appear {string}")
    public void error_message_will_appear(String string) {
        Logger logger
                =Logger.getLogger(
                Invoice.class.getName());

        logger.log(Level.INFO,string);
    }

    }



