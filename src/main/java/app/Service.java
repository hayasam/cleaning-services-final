package app;

public class Service {
    private String serviceName;
    private int quantity;
    private double price;
    private String decripation;
    private String material;

    public Service (String serviceName, int quantity, double price,String decripation,String material) {
        this.serviceName = serviceName;
        this.quantity = quantity;
        this.price = price;
        this.decripation=decripation;
        this.material=material;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    public String getdecripation() {
        return decripation;
    }
    public String getmaterial() {
        return material;
    }




    public void removeQuantity() {
        this.quantity--;
    }

    public String printList() {
        return "Service Name = " + serviceName + ", Quantity = " + quantity + ", Price = " + price + " NIS"+",Decripation = "+decripation +"Material ="+material ;
    }

    @Override
    public String toString() {
    	 return "Service Name = " + serviceName + ", Quantity = " + quantity + ", Price = " + price + " NIS"+",Decripation = "+decripation +"Material ="+material ;
    	       }

}
