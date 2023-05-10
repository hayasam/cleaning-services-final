package app;

public class Order {
    private String day;
    private String month;
    private String year;
    private String time;
    private String Status;

    public Order(String day, String month, String year, String time , String Status) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.time = time;
        this.Status=Status;

    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getTime() {
        return time;
    }
    public String getStatus() {
        return Status;
    }

    @Override
    public boolean equals(Object o) {
        if  (!(o instanceof Order))
            return false;
        Order other = (Order) o;
        return (this.day.equals(other.day) && this.month.equals(other.month) && this.year.equals(other.year) && this.time.equals(other.time)&& this.Status.equals(other.Status));
    }
    @Override
    public int hashCode() {
        return 0;
    }



}