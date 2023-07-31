public class Driver {
    private String car;
    private int license;

    public Driver(String car, int license) {
        this.car = car;
        this.license = license;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "CarDriver{" +
                "car='" + car + '\'' +
                ", license=" + license +
                '}';
    }
}
