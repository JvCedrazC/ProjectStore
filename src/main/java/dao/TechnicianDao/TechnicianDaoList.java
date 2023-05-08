package dao.TechnicianDao;


import Model.Technician;

import java.util.ArrayList;
import java.util.List;

public class TechnicianDaoList implements TechnicianDAO{
    private ArrayList<Technician> lista = new ArrayList<Technician>();
    private int nextID;

    public TechnicianDaoList(){
        this.lista = new ArrayList<Technician>();
        this.nextID = 0;
    }

    @Override
    public Technician create(Technician technician){
        technician.setId(nextID);
        nextID++;
        this.lista.add(technician);
        return technician;

    }

    @Override
    public Technician findById(int id) {
        for (Technician technician: this.lista) {
            if (technician.getId() == id){
                return technician;
            }
        } return null;

    }
    @Override
    public ArrayList<Technician> findMany(){
        ArrayList<Technician> listTechnician = new ArrayList<Technician>();
        for (Object o : this.lista) {
            listTechnician.add((Technician) o);
        }
        return listTechnician;
    }

    @Override
    public void update(Technician technician){
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getId() == technician.getId()) {
                this.lista.set(i, technician);
                return;
            }
        }
    }
    @Override
    public void deleteById(int id){
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getId() == id) {
                this.lista.remove(i);
                break;
            }
        }
        changeId();
    }
    public void deleteMany(){
        this.lista = new ArrayList<Technician>();
        this.nextID =  0;
    }
    public Technician findByName(String name){
        for (Technician i: this.lista) {
            if (i.getName() == name){
                return i;
            }
        }return null;
    }
    private void changeId(){
        for (int i = 0; i < this.lista.size();i++){
            this.lista.get(i).setId(i);
        }
    }

}
