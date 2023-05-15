package ModelTest;

import Model.Building;
import Model.Component;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBuilding {
    @Test
    void setBuilding(){
        ArrayList<Component> listComponents= new ArrayList<Component>();
        Component component1 = new Component(0, 100.0, 230.0, "ram");
        Component component2 = new Component(1, 450.0, 700.0, "Processador");
        Component component3 = new Component(0, 100.0, 230.0, "ram");
        listComponents.add(component1);
        listComponents.add(component2);
        listComponents.add(component3);
        Building building = new Building(listComponents);
        assertEquals(650.0, building.getCost());
        assertEquals(1160.0, building.getPrice());
        System.out.println("Test 1 passed");
    }
}
