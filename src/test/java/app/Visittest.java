package app;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;

public class Visittest {

    Secretary secretary;
    Customer customer;
    Worker worker;
    Record record = new Record();
    int index;

    public Visittest() {
        worker = new Worker("qasem", "qasem123","0595642328","Nubles", "Worker");
        worker.signIn("qasem", "qasem123");
        customer = new Customer("anas", "anas123","0595642329","Jenin", "Customer");
        secretary = new Secretary("sara", "sara123","0595642325","Gaza", "Secretary");
        secretary.signIn("sara", "sara123");
        record.addOrder(new Order("05", "01", "2023", "11","wating"), customer);
    }
    @Given("the secretary is logged in")
    public void the_secretary_is_logged_in() {
        assertEquals(true,secretary.isSignedIn());
    }

    @When("a customer arrived to  Cleaning system on his Order")
    public void a_customer_arrived_to_cleaning_system_on_his_order() {
        index = record.getCustomers().indexOf(customer);

    }

    @Then("a visit will be recorded")
    public void a_visit_will_be_recorded() {
        assertEquals(true,record.addVisit(record.getOrders().get(index)));
    }

    @When("a customer arrived to  Cleaning system without Order")
    public void a_customer_arrived_to_cleaning_system_without_order() {

    }

    @When("the worker is available")
    public void the_worker_is_available() {
        worker.setAvailability(true);
    }

    @When("the worker is not available")
    public void the_worker_is_not_available() {
        worker.setAvailability(false);

    }

    @Then("an Order will be recorded")
    public void an_order_will_be_recorded() {
        if (worker.isAvailable())
            record.addOrder(new Order("14", "05", "2023", "3" ,"intreatment"), customer);
    }

}
