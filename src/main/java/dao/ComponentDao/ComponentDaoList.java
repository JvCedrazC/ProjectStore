package dao.ComponentDao;


import Model.Component;
import java.util.List;
import java.util.ArrayList;

public class ComponentDaoList implements ComponentDAO{
    private ArrayList<Component> lista = new ArrayList<Component>();
    private int nextID;
    public ComponentDaoList(){
        this.lista = new ArrayList<Component>();
        this.nextID = 0;
    }
    @Override
    public Component create(Component component){
        component.setId(nextID);
        nextID++;
        lista.add(component);
        return component;
    }
    @Override
    public Component findById(int id){
        for (Component i: lista) {
            if (i.getId() == id){
                return i;
            }
        }
        return null;
    }
    @Override
    public List<Component> findMany(){
        ArrayList<Component> listComponent = new ArrayList<Component>();
        for (Object o : this.lista) {
            listComponent.add((Component) o);
        }
        return listComponent;
    }

    @Override
    public void deleteById(int id){
        for (int i = 0; i < lista.size(); i++) {
            if (this.lista.get(i).getId() == id) {
                this.lista.remove(i);
                break;
            }
        }
    }
    public void update(Component component){
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getId() == component.getId()) {
                this.lista.set(i, component);
                return;
            }
        }
    }
    public void deleteMany(){
        this.lista = new ArrayList<Component>();
        this.nextID =  0;
    }

}
