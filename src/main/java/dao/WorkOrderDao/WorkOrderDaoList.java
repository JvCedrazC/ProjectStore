package dao.WorkOrderDao;

import FilesUtils.ManagingFiles;
import Model.Customer;
import Model.Technician;
import Model.WorkOrder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkOrderDaoList implements WorkOrderDAO {
    private ManagingFiles managingFiles;
    private int nextID;

    public WorkOrderDaoList(){
        this.managingFiles = new ManagingFiles("workOrder.dat");
        ArrayList<WorkOrder>lista = this.managingFiles.retrieve();
        if (lista.size() == 0){
            nextID = lista.size()-1;
        } else{
            nextID = 0;
        }
    }
    //Create
    @Override
    public WorkOrder create(WorkOrder workOrder) {
        ArrayList<WorkOrder> lista = new ArrayList<WorkOrder>();
        workOrder.setId(nextID);
        nextID++;
        lista.add(workOrder);
        managingFiles.save(lista);
        return workOrder;
    }
    //read
    @Override
    public WorkOrder findById(int id) {
        ArrayList<WorkOrder> lista;
        lista = managingFiles.retrieve();
        for (WorkOrder workOrder: lista) {
            if(workOrder.getId() == id){
                return workOrder;
            }
        }
        return null;
    }

    @Override
    public WorkOrder findByCustomer(Customer customer) {
        ArrayList<WorkOrder> lista;
        lista = managingFiles.retrieve();
        for (WorkOrder workOrder: lista) {
            if (workOrder.getCustomer() == customer.getId()){
                return workOrder;
            }

        }return null;
    }

    @Override
    public WorkOrder findByTechnician(Technician technician) {
        ArrayList<WorkOrder> lista;
        lista = managingFiles.retrieve();
        for (WorkOrder workOrder: lista) {
            if (workOrder.getTechnician() == technician.getId()){
                return workOrder;
            }
        }return null;
    }
    public ArrayList<WorkOrder> findMany(){
        ArrayList<WorkOrder> listWorkOrder = new ArrayList<WorkOrder>();
        ArrayList<WorkOrder> lista;
        lista = managingFiles.retrieve();
        for (Object o : lista) {
            listWorkOrder.add((WorkOrder) o);
        }
        return listWorkOrder;
    }

    //Update
    public void update(WorkOrder workOrder){
        ArrayList<WorkOrder> lista;
        lista = managingFiles.retrieve();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == workOrder.getId()) {
                lista.set(i, workOrder);
                return;
            }
        }
        managingFiles.save(lista);
    }
    //Delete
    public void deleteMany(){
        ArrayList<WorkOrder> lista = new ArrayList<WorkOrder>();
        managingFiles.save(lista);
        this.nextID =  0;

    }
    public void deleteById(int id){
        ArrayList<WorkOrder> lista;
        lista = managingFiles.retrieve();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                break;
            }
        }
        changeId(lista);
    }

    public WorkOrder getNewAvailableOrder(){
        ArrayList<WorkOrder> lista;
        lista = managingFiles.retrieve();
        for (WorkOrder i: lista) {
            if (i.getStatus() == "Aberta") {
                return i;
            }
        }
        return null;

    }
    private void changeId(ArrayList<WorkOrder> lista){
        for (int i = 0; i < lista.size();i++){
            lista.get(i).setId(i);
        }
        managingFiles.save(lista);
    }

}
