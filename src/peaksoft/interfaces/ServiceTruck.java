package peaksoft.interfaces;

import peaksoft.models.Driver;

import java.util.HashMap;
import java.util.Map;

public interface ServiceTruck {
    Map<Integer, Driver> driverMap =new HashMap<>();

    default Map<Integer, Driver> searchID(int id) {
        Map<Integer, Driver> map =new HashMap<>();

        for (Map.Entry<Integer, Driver> entry : driverMap.entrySet()) {
            if (entry.getKey() == id) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }
}
