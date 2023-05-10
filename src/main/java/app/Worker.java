package app;

public class Worker extends Users {
    private boolean isAvailable;

    public Worker(String userName, String password,String phone,String address, String role) {
        super(userName, password,phone,address, role);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    @Override
    public boolean equals(Object o) {
        if  (!(o instanceof Worker))
            return false;
        Worker other = (Worker) o;
        return (this.userName.equals(other.userName) &&this.phone.equals(other.phone) && this.address.equals(other.address) && this.password.equals(other.password) && this.role.equals(other.role));
    }
    @Override
    public int hashCode() {
        return 0;
    }

}