package peaksoft.models.modelservice;

import peaksoft.models.Driver;
import peaksoft.models.Truck;

import java.util.HashMap;
import java.util.Map;

public class DriverService {
    Map<String, Driver> driverMap =new HashMap<>();

    public Map<String, Driver> getDriverMap() {
        return driverMap;
    }

    public void setDriverMap(Map<String, Driver> driverMap) {
        this.driverMap = driverMap;
    }

    public void addDriver(Driver driver) {
        driverMap.put(driver.getId(), driver);
    }

    public Driver searchId(String id) {
        return driverMap.get(id);
    }

    public void showInfo() {
        System.out.println("""
                 #     | Driver         | Bus      
                -------+----------------+--------------""");
        for (Map.Entry<String, Driver> entry : driverMap.entrySet()) {
            String key = entry.getKey();
            Driver value = entry.getValue();
            try {
                System.out.println(key + "|" + value.getDriverName() + "|" + value.getTruck().getTruckName() + "\n");
            } catch (NullPointerException e) {
                System.out.println(key + "|" + value.getDriverName() + "|" + "" + "\n");
            }
        }
    }
}
