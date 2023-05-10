package app;

import java.util.ArrayList;
import java.util.List;


public class Customer extends Users {
    private List<Service> selectedServices = new ArrayList<>();
    private double workerVisit;

    public Customer(String userName, String password,String phone,String address, String role) {
        super(userName, password,phone,address ,role);
    }

    public List<Service> getSelectedServices() {
        return selectedServices;
    }

    public boolean setSelectedServices(List<Service> selectedServices) {
        if (selectedServices.isEmpty())
            return false;

        this.selectedServices = selectedServices;
        return true;
    }


    public double getWorkerVisit() {
        return workerVisit;
    }

    public void setWorkerVisit(double workerVisit) {
        this.workerVisit = workerVisit;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer)) {
            return false;
        } else {
            Customer other = (Customer) o;
            return (this == other);
        }
    }

    @Override
    public int hashCode() {
        return 0;
    }

}

