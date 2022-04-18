package peaksoft.models;

import java.util.Objects;

public class Driver {
    private String id;
    private String driverName;
    private Truck truck;

    public Driver() {
    }

    public Driver(String id, String driverName) {
        this.id = id;
        this.driverName = driverName;
        this.truck = truck;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public boolean hasTruck() {
        return this.truck != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id == driver.id && Objects.equals(driverName, driver.driverName) &&
                Objects.equals(truck, driver.truck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, driverName, truck);
    }

    public boolean isFree() {
        return truck == null;
    }
}
