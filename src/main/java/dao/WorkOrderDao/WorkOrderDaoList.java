package dao.WorkOrderDao;

import FilesUtils.ManagingFiles;
import Model.Customer;
import Model.Technician;
import Model.WorkOrder;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderDaoList implements WorkOrderDAO {
    private ManagingFiles managingFiles;
    private ArrayList<WorkOrder> lista;
    private int nextID;

    public WorkOrderDaoList(){
        this.managingFiles = new ManagingFiles("workOrder.dat");
        this.lista = this.managingFiles.retrieve();
        if (lista.size() == 0){
            nextID = lista.size()-1;
        } else{
            nextID = 0;
        }
    }
    //Create
    @Override
    public WorkOrder create(WorkOrder workOrder) {
        workOrder.setId(nextID);
        nextID++;
        lista.add(workOrder);
        return workOrder;
    }
    //read
    @Override
    public WorkOrder findById(int id) {
        for (WorkOrder workOrder: lista) {
            if(workOrder.getId() == id){
                return workOrder;
            }
        }
        return null;
    }

    @Override
    public WorkOrder findByCustomer(Customer customer) {
        for (WorkOrder workOrder: this.lista) {
            if (workOrder.getCustomer() == customer.getId()){
                return workOrder;
            }

        }return null;
    }

    @Override
    public WorkOrder findByTechnician(Technician technician) {
        for (WorkOrder workOrder: this.lista) {
            if (workOrder.getTechnician() == technician.getId()){
                return workOrder;
            }
        }return null;
    }
    public ArrayList<WorkOrder> findMany(){
        ArrayList<WorkOrder> listWorkOrder = new ArrayList<WorkOrder>();
        for (Object o : this.lista) {
            listWorkOrder.add((WorkOrder) o);
        }
        return listWorkOrder;
    }

    //Update
    public void update(WorkOrder workOrder){
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getId() == workOrder.getId()) {
                this.lista.set(i, workOrder);
                return;
            }
        }
    }
    //Delete
    public void deleteMany(){
        this.lista = new ArrayList<WorkOrder>();
        this.nextID =  0;
    }
    public void deleteById(int id){
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getId() == id) {
                this.lista.remove(i);
                break;
            }
        }
        changeId();
    }

    public WorkOrder getNewAvailableOrder(){
        for (WorkOrder i: lista) {
            if (i.getStatus() == "Aberta") {
                return i;
            }
        }
        return null;

    }
    private void changeId(){
        for (int i = 0; i < this.lista.size();i++){
            this.lista.get(i).setId(i);
        }
    }

}
