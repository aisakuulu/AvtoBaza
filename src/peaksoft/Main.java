package peaksoft;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import peaksoft.enumpack.State;
import peaksoft.exeptions.InvalidChangeAttemptException;
import peaksoft.models.Driver;
import peaksoft.models.Truck;
import peaksoft.models.modelservice.DriverService;
import peaksoft.models.modelservice.TruckService;
import peaksoft.services.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path TRUCKS = Paths.get("./truck.json");
    public static final Path DRIVERS = Paths.get("./driver.json");
    static Scanner scanner = new Scanner(System.in);
    static DriverService driverService = new DriverService();
    static TruckService truckService = new TruckService();
    static Service service = new Service(driverService, truckService);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Truck truck1 = new Truck(1, "Renault Magnum", null, State.ON_THE_BASE);
        Truck truck2 = new Truck(2, "Volvo FH12", null, State.ON_THE_BASE);
        Truck truck3 = new Truck(3, "DAF XF", null, State.ON_THE_BASE);

        truckService.addTruck(truck1);
        truckService.addTruck(truck2);
        truckService.addTruck(truck3);

        Driver driver1 = new Driver("drv-1", "Will");
        Driver driver2 = new Driver("drv-2", "Smith");
        Driver driver3 = new Driver("drv-3", "Parker");

        driverService.addDriver(driver1);
        driverService.addDriver(driver2);
        driverService.addDriver(driver3);

        driverService.showInfo();

        while (true) {
            try {
                System.out.println("Enter truck id to see truck information: ");
                int truck = scanner.nextInt();
                service.showTruckId(truck);
                System.out.printf("""
                        Press 1 to change Driver
                        Press 2 to send to the Route
                        Press 3 ot send to the Repairing
                        Press 4 ot send to the Base
                        """);
                int state = scanner.nextInt();
                switch (state) {
                    case 1 -> service.changeDriver(truck);
                    case 2 -> truckService.onTheWay(truck);
                    case 3 -> truckService.onTheRepairing(truck);
                    case 4 -> truckService.onTheBase(truck);
                }
            } catch (InvalidChangeAttemptException e) {
                System.err.println("The number is not found");
            }

            service.showService();

            Map<Integer, Truck> truckMap = new HashMap<>();
            Map<Integer, Driver> driverMap = new HashMap<>();

            String truckJson =GSON.toJson(truckMap);
            write(truckJson);

            String driverJson = GSON.toJson(driverMap);
            write(driverJson);
        }








    }

    private static void write(String obj) {
        Path write = Paths.get(String.valueOf(TRUCKS));
        try {
            Files.writeString(write, obj, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeDriver(String obj) {
        Path write = Paths.get(String.valueOf(DRIVERS));
        try {
            Files.writeString(write, obj, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
