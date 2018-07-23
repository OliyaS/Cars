package cars.entities;

import framework.BaseEntity;

import java.util.HashMap;
import java.util.Map;

public class Car extends BaseEntity {

    private Map<String, String> map = new HashMap<>();

    public Map<String, String> getMap() {
        return map;
    }
}
