package dao.WorkOrderDao;

import dao.CRUD;
import Model.Customer;
import Model.Technician;
import Model.WorkOrder;

public interface WorkOrderDAO extends CRUD<WorkOrder>{
    public WorkOrder create(WorkOrder workOrder);
    public WorkOrder findByCustomer(Customer customer);
    public WorkOrder findByTechnician(Technician technician);
    public void deleteById(int id);
}
