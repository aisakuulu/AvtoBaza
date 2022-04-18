package peaksoft.models;

import peaksoft.enumpack.State;

import java.util.Objects;

public class Truck {

    private int id;
    private String truckName;
    private Driver driver;
    private State state;

    public Truck() {
    }

    public Truck(int id, String truckName, Driver driver, State state) {
        this.id = id;
        this.truckName = truckName;
        this.driver = driver;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return id == truck.id && Objects.equals(truckName, truck.truckName) &&
                Objects.equals(driver, truck.driver) && state == truck.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, truckName, driver, state);
    }

    public boolean hasDriver() {
        return this.driver != null;
    }
}
