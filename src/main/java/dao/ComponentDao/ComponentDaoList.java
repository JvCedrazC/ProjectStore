package dao.ComponentDao;


import FilesUtils.ManagingFiles;
import Model.Component;
import Model.Customer;

import java.util.List;
import java.util.ArrayList;

public class ComponentDaoList implements ComponentDAO{
    private ManagingFiles managingFiles;
    private int nextID;
    public ComponentDaoList(){
        this.managingFiles = new ManagingFiles("Component.bin");
        ArrayList<Component> lista = this.managingFiles.retrieve();
        if (lista.size() == 0){
            this.nextID = lista.size();
        } else{
            this.nextID = 0;
        }
    }
    @Override
    public Component create(Component component){
        ArrayList<Component> lista = this.managingFiles.retrieve();
        component.setId(nextID);
        nextID++;
        lista.add(component);
        managingFiles.save(lista);
        return component;
    }
    @Override
    public Component findById(int id){
        ArrayList<Component> lista = this.managingFiles.retrieve();
        for (Component i: lista) {
            if (i.getId() == id){
                return i;
            }
        }
        return null;
    }
    @Override
    public List<Component> findMany(){
        ArrayList<Component> lista = this.managingFiles.retrieve();
        ArrayList<Component> listComponent = new ArrayList<Component>();
        for (Object o : lista) {
            listComponent.add((Component) o);
        }
        return listComponent;
    }

    @Override
    public void deleteById(int id){
        ArrayList<Component> lista = this.managingFiles.retrieve();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                break;
            }
        }
        managingFiles.save(lista);
    }
    public void update(Component component){
        ArrayList<Component> lista = this.managingFiles.retrieve();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == component.getId()) {
                lista.set(i, component);
                managingFiles.save(lista);
                return;
            }
        }

    }
    public void deleteMany(){
        ArrayList<Component> lista  = new ArrayList<Component>();
        this.nextID =  0;
        managingFiles.save(lista);
    }

}
