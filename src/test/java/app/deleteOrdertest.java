package app;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class deleteOrdertest {
    Customer customer;
    Record record = new Record();

    public deleteOrdertest() {
        customer= new Customer("anas", "anas123","0595642329","Jenin", "Customer");
        customer.signIn("anas", "anas123");
        record.addOrder(new Order("05", "01", "2023", "11","wating"), customer);
        record.addOrder(new Order("14", "05", "2023", "3","intreatment"), customer);
    }

    @Given("the customer is logged in")
    public void the_customer_is_logged_in() {
    }

    @Given("he\\/she is opening the order page")
    public void he_she_is_opening_the_order_page() {
    }

    @Given("he\\/she has at leaset one order")
    public void he_she_has_at_leaset_one_order() {
        assertTrue(record.getCustomers().contains(customer));
    }

    @Given("he\\/she want to delete this order")
    public void he_she_want_to_delete_this_order() {
    }

    @When("he\\/she click on {string} button Next to edit button")
    public void he_she_click_on_button_next_to_edit_button(String string) {
    }

    @When("click on {string} from the confirmation message")
    public void click_on_from_the_confirmation_message(String string) {
    }

    @Then("this order will be deleted")
    public void this_order_will_be_deleted() {
        assertTrue(record.deleteOrder(new Order("05", "01", "2023", "11","wating")));
    }

    @Then("success message appear {string}")
    public void success_message_appear(String string) {
        Logger logger
                =Logger.getLogger(
                Invoice.class.getName());
        logger.log(Level.INFO,string);
    }

    @Then("this order will not be deleted")
    public void this_order_will_not_be_deleted() {
        assertTrue(record.getOrders().contains(new Order("05", "01", "2023", "11","wating")));
    }

}
