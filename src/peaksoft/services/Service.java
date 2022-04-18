package peaksoft.services;

import peaksoft.enumpack.State;
import peaksoft.models.Driver;
import peaksoft.models.Truck;
import peaksoft.models.modelservice.DriverService;
import peaksoft.models.modelservice.TruckService;

import java.util.Map;
import java.util.Scanner;

public class Service {
    private DriverService driverService;
    private TruckService truckService;

    Scanner scanner = new Scanner(System.in);

    public Service(DriverService driverService, TruckService truckService) {
        this.driverService = driverService;
        this.truckService = truckService;
    }

    public void changeDriver (int truck) {
        for (Map.Entry<Integer, Truck> truckEntry : truckService.getTruckMap().entrySet()) {
            if (truckEntry.getValue().getState().equals(State.ON_THE_BASE)) {
                driverService.showInfo();
                System.out.println("Select driver to change driver: ");
                String driver = String.valueOf(scanner.nextInt());
                changeDriver1(truck, Integer.parseInt(driver));
                break;
            } else if (truckEntry.getValue().getState().equals(State.ON_THE_WAY)) {
                System.out.println("You cant change the driver, because truck is on the way");
                truckEntry.getValue().getTruckName();
                break;
            } else {
                System.out.println("You cant change the driver, because truck is on the repair");
                truckEntry.getValue().getTruckName();
            }
        }
    }

    public void changeDriver1(int truckID, int driverID) {
        Truck truck = truckService.showTruckId(truckID);
        Driver driver = driverService.searchId(String.valueOf(driverID));
        try{
            if (driver.isFree()) {
                truck.getDriver().setTruck(null);
                truck.setDriver(driver);
                driver.setTruck(truck);
            } else {
                System.out.println("Driver is not free");
            }
        } catch (NullPointerException e) {
            truck.setDriver(driver);
            driver.setTruck(truck);
        }
    }

    public void showService() {
        truckService.showInfo();
        driverService.showInfo();
    }

    public void showTruckId(int id) {
        truckService.showTruckId(id);
    }
}
