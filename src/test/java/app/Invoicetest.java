package app;
import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Invoicetest {

    Customer customer;
    Secretary secretary;
    int index;
    boolean available;
    Invoice invoice;

    public Invoicetest() {
        customer = new Customer("anass", "anass123","0595642329","Jenin", "Customer");
        customer.signIn("anass", "anass123");
        secretary = new Secretary("sara", "sara123","0595642325","Gaza", "Secretary");
        secretary.signIn("sami", "sami123");
        customer.getSelectedServices().add(new Service("Cleaning carpets", 50, 250.00,"9 m2","silk"));
    }

    @When("the customer finished his visit")
    public void the_customer_finished_his_visit() {
        customer.setWorkerVisit(200.00);
        invoice = new Invoice(customer.getSelectedServices(), customer.getWorkerVisit());
    }

    @Then("the secretary will issue the invoice")
    public void the_secretary_will_issue_the_invoice() {
        assertTrue(invoice.printInvoice());
        invoice.total = 0.0;
        assertEquals(false, invoice.printInvoice());
    }

}
