package app;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Servicestest {
    Customer customer;
    int index;
    boolean available;
    ArrayList<Service> servicesList = new ArrayList<Service>();
    ArrayList<Service> selectedServices = new ArrayList<Service>();

    public Servicestest() {
        Service service1 = new Service("Cleaning carpets", 50, 250.00,"9 m2","silk");
        servicesList.add(service1);
        servicesList.add(new Service("Cleaning covers", 1, 50.00,"3 m2","cotton"));
        servicesList.add(new Service("Cleaning  carpets and covers", 50, 500.00,"6 m2","wool"));
        customer = new Customer("anas", "anas123","0595642329","Jenin", "Customer");
        customer.signIn("anas", "anas123");
    }

    @Given("the customer is logged in")
    public void the_customer_is_logged_in() {
        assertTrue(customer.isSignedIn());

    }

    @Given("the customer want to select a service")
    public void the_customer_want_to_select_a_service() {
        int i = 1;
        for (Service service : servicesList) {
            System.out.println(i++ + ". " + service);
        }
    }

    @When("the customer select a service {string}")
    public void the_customer_select_a_service(String string) {
        index = Integer.parseInt(string);
        System.out.println(index);
    }

    @When("the service is available")
    public void the_service_is_available() {
        available = servicesList.get(index).getQuantity() != 0;
        assertTrue(available);
    }

    @Then("the service price will be added to the invoice")
    public void the_service_price_will_be_added_to_the_invoice() {
        if (available) {
            servicesList.get(index).removeQuantity();
            selectedServices.add(servicesList.get(index));
            assertTrue(customer.setSelectedServices(selectedServices));
        }
    }

    @Then("message displayed {string}")
    public void message_displayed(String string) {
        System.out.println(string);
    }

    @When("the service is not available")
    public void the_service_is_not_available() {
        available = servicesList.get(index).getQuantity() != 0;
        assertFalse(available);
    }

}
