package peaksoft.models.modelservice;

import peaksoft.enumpack.State;
import peaksoft.models.Truck;

import java.util.HashMap;
import java.util.Map;

public class TruckService {
    Map<Integer, Truck> truckMap = new HashMap<>();

    public Map<Integer, Truck> getTruckMap() {
        return truckMap;
    }

    public void setTruckMap(Map<Integer, Truck> truckMap) {
        this.truckMap = truckMap;
    }

    public void addTruck(Truck truck) {
        truckMap.put(truck.getId(), truck);
    }

    public void onTheWay(int id) {
        for (Map.Entry<Integer, Truck> truck : truckMap.entrySet()) {
            if (truck.getKey() == id) {
                if (truck.getValue().getState().equals(State.ON_THE_WAY)) {
                    System.err.println("Truck is on the road");
                } else {
                    if (truck.getValue().getDriver() == null) {
                        System.err.println("No Driver");
                    } else {
                        truck.getValue().setState(State.ON_THE_WAY);
                        System.out.println("You have successfully entered the route");
                    }
                }
            }
        }
    }

    public void onTheRepairing(int id) {
        truckMap.entrySet().stream()
                .filter(x -> x.getKey() == id)
                .forEach(x -> x.getValue().setState(State.ON_REPAIR));
        System.out.println("The truck has sent to the repair");
    }

    public void onTheBase(int id) {
        truckMap.entrySet().stream().filter(x -> x.getKey() == id).forEach(x -> x.getValue().setState(State.ON_THE_BASE));
        System.out.println("=================================================");
        System.out.println("you have successfully sent for base");
    }

    public Truck showTruckId(int id) {

        for (Map.Entry<Integer, Truck> truckEntry : truckMap.entrySet()) {
            if (id == truckEntry.getKey()) {
                try {
                    System.out.println(" Id          : " + truckEntry.getValue().getId());
                    System.out.println(" Truck       : " + truckEntry.getValue().getTruckName());
                    System.out.println(" Driver      : " + truckEntry.getValue().getDriver().getDriverName());
                    System.out.println(" Truck State : " + truckEntry.getValue().getState());
                } catch (NullPointerException e) {
                    System.out.println(" Driver      : " + " ");
                    System.out.println(" Truck State : " + truckEntry.getValue().getState() + "\n");
                }
            }
        }
        return null;
    }

    public void showInfo() {
        System.out.println("""
                 #     | Bus            | Driver   | State
                -------+----------------+----------+--------------""");
        for (Map.Entry<Integer, Truck> entry : truckMap.entrySet()) {
            Integer key = entry.getKey();
            Truck value = entry.getValue();
            try {
                System.out.printf("""
                                -%d-    |  %s       | %s  | %s            """, key, value.getTruckName(),
                        value.getDriver().getDriverName(), value.getState() + "\n");
            } catch (NullPointerException e) {
                System.out.printf("""
                                -%d-    |  %s       | %s        | %s            """, key, value.getTruckName(),
                        " ", value.getState() + "\n");
            }
        }
    }
}
