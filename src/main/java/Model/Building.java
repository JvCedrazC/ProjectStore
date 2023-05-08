package Model;

import java.io.Serializable;
import java.util.ArrayList;
public class Building extends Services {
    private static ArrayList<Component> usedComponents = new ArrayList<Component>();
    //Class' Methods
    public Building (ArrayList<Component> component){
        for (int i = 0; i < component.size();i++){
            Component x =addComponent(component.get(i));
            System.out.println("Component added: " + x.getName()+"\nComponent ID:"+ x.getId());
        }
        calculatePrice();
        calculateCost();

    }
    public static ArrayList<Component> getUsedComponents() {
        return usedComponents;
    }

    private Component addComponent(Component component){
        usedComponents.add(component);
        return component;
    }
    private void calculatePrice(){
        Double total = 0.0;
        for (int i = 0; i < usedComponents.size();i++){
            total += usedComponents.get(i).getPrice();
        }
        setPrice(total);
    }
    private void calculateCost(){
        Double total = 0.0;
        for (int i = 0; i < usedComponents.size();i++){
            total += usedComponents.get(i).getCost();
        }
        setCost(total);
    }

}
