package app;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Invoice {
    protected List<Service> services = new ArrayList<>();
    protected Double workerVisit = 0.0;
    protected Double total = 0.0;

    public Invoice(List<Service> selectedServices, Double workerVisit) {
        services = selectedServices;
        for (Service service : selectedServices) {
            this.total += service.getPrice();
        }
        this.workerVisit = workerVisit;
        this.total += workerVisit;
    }

    public boolean printInvoice() {
        Logger logger
                =Logger.getLogger(
                Invoice.class.getName());
        if (total == 0.0)
            return false;
        String strservice;
        for (Service service : services) {
            strservice=service.toString();
            logger.log(Level.INFO,strservice);
        }
        String  worker="Worker visit = " + workerVisit;
        String totalV="Total Invoice = " + total + " NIS";

        logger.log(Level.SEVERE,"\n");
        logger.log(Level.INFO,worker);
        logger.log(Level.INFO,"\n");
        logger.log(Level.INFO,totalV);


        return true;

    }

}
