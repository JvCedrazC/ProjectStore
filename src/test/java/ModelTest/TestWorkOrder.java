package ModelTest;

import Model.*;
import Model.Instalation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class TestWorkOrder {
    @Test
    void setServices(){
        ArrayList<Services> listServices = new ArrayList<Services>();
        ArrayList<Component> listComponents= new ArrayList<Component>();
        ArrayList<String> listPrograms = new ArrayList<String>();

        Component component1 = new Component(0, 100.0, 230.0, "ram");
        Component component2 = new Component(1, 450.0, 700.0, "Processador");
        Component component3 = new Component(0, 100.0, 230.0, "ram");

        listComponents.add(component1);
        listComponents.add(component2);
        listComponents.add(component3);

        String program1 = "Word";
        String program2 = "Firefox";
        String program3 = "Chrome";

        listPrograms.add(program1);
        listPrograms.add(program2);
        listPrograms.add(program3);

        Building building = new Building(listComponents);
        Cleaning cleaning = new Cleaning(); //70 reais
        Instalation instalation = new Instalation(listPrograms, 10.0, 0.0);

        listServices.add(building);
        listServices.add(cleaning);
        listServices.add(instalation);

        Double total = building.getPrice() + cleaning.getPrice() + instalation.getPrice();

        assertEquals(total, 1240.0);
        System.out.println("Test 2 passed");
    }
    @Test
    void setWorkOrder(){
        Customer cusomer1 = new Customer(0, "Josue", "josuesilva@gmail.com");
        Technician technician1 = new Technician(0, "Maicon");
        WorkOrder workOrder = new WorkOrder(0, 0, "04/05/2023");
        ArrayList<Services> listServices = new ArrayList<Services>();
        ArrayList<Component> listComponents= new ArrayList<Component>();
        ArrayList<String> listPrograms = new ArrayList<String>();

        workOrder.change_status();
        assertEquals(workOrder.getStatus(), "Aberta");

        workOrder.setTechnician(0);
        workOrder.change_status();
        assertEquals(workOrder.getStatus(), "Em andamento");

        Component component1 = new Component(0, 100.0, 230.0, "ram");
        Component component2 = new Component(1, 450.0, 700.0, "Processador");
        Component component3 = new Component(0, 100.0, 230.0, "ram");

        listComponents.add(component1);
        listComponents.add(component2);
        listComponents.add(component3);

        String program1 = "Word";
        String program2 = "Firefox";
        String program3 = "Chrome";

        listPrograms.add(program1);
        listPrograms.add(program2);
        listPrograms.add(program3);

        Building building = new Building(listComponents);
        Cleaning cleaning = new Cleaning(); //70 reais
        Instalation instalation = new Instalation(listPrograms, 10.0, 0.0);

        listServices.add(building);
        listServices.add(cleaning);
        listServices.add(instalation);

        for (Services i: listServices) {
            workOrder.addService(i);
        }

        Double total_price = building.getPrice() + cleaning.getPrice() + instalation.getPrice();
        Double total_cost = building.getCost() + cleaning.getCost() + instalation.getCost();
        assertEquals(workOrder.getPrice(), total_price);
        assertEquals(workOrder.getCost(), total_cost);

        System.out.println("Test 3 passed");
    }
}
