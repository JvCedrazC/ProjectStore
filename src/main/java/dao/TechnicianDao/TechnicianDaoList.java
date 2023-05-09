package dao.TechnicianDao;


import FilesUtils.ManagingFiles;
import Model.Technician;

import java.util.ArrayList;
import java.util.List;

public class TechnicianDaoList implements TechnicianDAO{
    private ManagingFiles managingFiles;
    private int nextID;

    public TechnicianDaoList(){
        this.managingFiles = new ManagingFiles("Technician.bin");
        ArrayList<Technician> lista = this.managingFiles.retrieve();
        if (lista.size() == 0){
            this.nextID = lista.size();
        } else{
            this.nextID = 0;
        }
    }

    @Override
    public Technician create(Technician technician){
        ArrayList<Technician> lista = this.managingFiles.retrieve();
        technician.setId(nextID);
        nextID++;
        lista.add(technician);
        save(lista);
        return technician;

    }

    @Override
    public Technician findById(int id) {
        ArrayList<Technician> lista = this.managingFiles.retrieve();
        for (Technician technician: lista) {
            if (technician.getId() == id){
                return technician;
            }
        } return null;

    }
    @Override
    public ArrayList<Technician> findMany(){
        ArrayList<Technician> lista = this.managingFiles.retrieve();
        ArrayList<Technician> listTechnician = new ArrayList<Technician>();
        for (Object o : lista) {
            listTechnician.add((Technician) o);
        }
        return listTechnician;
    }

    @Override
    public void update(Technician technician){
        ArrayList<Technician> lista = this.managingFiles.retrieve();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == technician.getId()) {
                lista.set(i, technician);
                save(lista);
                return;
            }
        }
    }
    @Override
    public void deleteById(int id){
        ArrayList<Technician> lista = this.managingFiles.retrieve();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                break;
            }
        }
        changeId();
        save(lista);
    }
    public void deleteMany(){
        ArrayList<Technician> lista = new ArrayList<Technician>();
        this.nextID =  0;
        save(lista);
    }
    public Technician findByName(String name){
        ArrayList<Technician> lista = this.managingFiles.retrieve();
        for (Technician i: lista) {
            if (i.getName() == name){
                return i;
            }
        }return null;
    }
    private void changeId(){
        ArrayList<Technician> lista = this.managingFiles.retrieve();
        for (int i = 0; i < lista.size();i++){
            lista.get(i).setId(i);
        }
        save(lista);
    }
    public void save(ArrayList<Technician> lista){

        managingFiles.save(lista);
    }

}
