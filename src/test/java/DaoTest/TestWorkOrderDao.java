package DaoTest;

import Model.Customer;
import Model.Technician;
import Model.WorkOrder;


import dao.Dao;
import dao.WorkOrderDao.WorkOrderDAO;
import dao.WorkOrderDao.WorkOrderDaoList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestWorkOrderDao {


    @Test
    void create(){
        WorkOrderDaoList listWorkOrder;
        listWorkOrder = new WorkOrderDaoList();
        listWorkOrder.deleteMany();
        WorkOrder workOrder1 = new WorkOrder(-1, 0, "07/05/2023");
        listWorkOrder.create(workOrder1);
        assertEquals(1, listWorkOrder.findMany().size());

    }
    @Test
    void findById(){
        WorkOrderDaoList listWorkOrder = new WorkOrderDaoList();
        listWorkOrder.deleteMany();
        WorkOrder workOrder1 = new WorkOrder(-1, 0, "06/05/2023");
        WorkOrder workOrder2 = new WorkOrder(-1, 1, "07/05/2023");
        listWorkOrder.create(workOrder1);
        listWorkOrder.create(workOrder2);
        assertEquals(listWorkOrder.findById(1).getCreatedAT(),"07/05/2023" );
    }
    @Test
    void findByCustomer(){
        WorkOrderDaoList listWorkOrder = new WorkOrderDaoList();
        listWorkOrder.deleteMany();
        Customer customer1 = new Customer(0, "Neymar jr", "NeymarJunior@gmail.com");
        Customer customer2 = new Customer(1, "Lebron James", "Lebron_LA_Lakers_23@hotmail.com");
        WorkOrder workOrder1 = new WorkOrder(-1, 0, "06/05/2023");
        WorkOrder workOrder2 = new WorkOrder(-1, 1, "07/05/2023");

        listWorkOrder.create(workOrder1);
        listWorkOrder.create(workOrder2);

        assertEquals(listWorkOrder.findByCustomer(customer1).getId(), workOrder1.getId());
        System.out.println("WorkOrder 1 Id:" + workOrder1.getId());
        System.out.println("WorkOrder 1 Id:" + listWorkOrder.findByCustomer(customer1).getId());
    }
    @Test
    void findByTechnician(){
        WorkOrderDaoList listWorkOrder = new WorkOrderDaoList();
        listWorkOrder.deleteMany();
        WorkOrder workOrder1 = new WorkOrder(-1, 0, "06/05/2023");
        workOrder1.setTechnician(0);
        WorkOrder workOrder2 = new WorkOrder(-1, 1, "07/05/2023");

        listWorkOrder.create(workOrder1);
        listWorkOrder.create(workOrder2);
        Technician technician = new Technician(0, "Lionel Messi");

        assertEquals(listWorkOrder.findByTechnician(technician).getId(), workOrder1.getId());
        System.out.println("WorkOrder 1 Id:" + workOrder1.getId());
        System.out.println("WorkOrder 1 Id:" + listWorkOrder.findByTechnician(technician).getId());
    }
    @Test
    void findMany(){
        WorkOrderDaoList listWorkOrder = new WorkOrderDaoList();
        ArrayList<WorkOrder> workOrders = new ArrayList<WorkOrder>();
        WorkOrder workOrder1 = new WorkOrder(-1, 0, "06/05/2023");
        WorkOrder workOrder2 = new WorkOrder(-1, 1, "07/05/2023");
        Technician technician = new Technician(0, "Lionel Messi");
        Technician technician1 = new Technician(1, "Joe Biden");
        listWorkOrder.create(workOrder1);
        listWorkOrder.create(workOrder2);
        workOrder1.setTechnician(0);
        workOrder2.setTechnician(1);
        listWorkOrder.update(workOrder1);
        listWorkOrder.update(workOrder2);
        workOrders = listWorkOrder.findMany();

        assertEquals(workOrders.get(0).getStatus(), workOrder1.getStatus());
        assertEquals(workOrders.get(1).getStatus(), workOrder2.getStatus());

        System.out.println("WorkOrder 1 -> Status: "+ workOrders.get(0).getStatus());
        System.out.println("WorkOrder 2 -> Status: "+ workOrders.get(1).getStatus());
    }
    @Test
    void update(){
        WorkOrderDaoList listWorkOrder = new WorkOrderDaoList();
        listWorkOrder.deleteMany();
        WorkOrder workOrder1 = new WorkOrder(-1, 0, "06/05/2023");
        listWorkOrder.create(workOrder1);
        Technician technician = new Technician(0, "Lionel Messi");
        workOrder1.setTechnician(technician.getId());
        listWorkOrder.update(workOrder1);
        assertEquals(listWorkOrder.findById(0).getTechnician(), 0);
    }

    @Test
    void deleteById(){
        WorkOrderDaoList listWorkOrder = new WorkOrderDaoList();
        listWorkOrder.deleteMany();
        WorkOrder workOrder1 = new WorkOrder(-1, 0, "06/05/2023");
        WorkOrder workOrder2 = new WorkOrder(-1, 1, "07/05/2023");
        Technician technician = new Technician(0, "Lionel Messi");
        Technician technician1 = new Technician(1, "Joe Biden");
        listWorkOrder.create(workOrder1);
        listWorkOrder.create(workOrder2);
        workOrder1.setTechnician(0);
        workOrder2.setTechnician(1);
        listWorkOrder.update(workOrder1);
        listWorkOrder.update(workOrder2);
        listWorkOrder.deleteById(1);
        assertEquals(listWorkOrder.findMany().size(), 1);
    }
    @Test
    void deleteMany(){
        WorkOrderDaoList listWorkOrder = new WorkOrderDaoList();
        listWorkOrder.deleteMany();
        listWorkOrder.deleteMany();
        WorkOrder workOrder1 = new WorkOrder(-1, 0, "06/05/2023");
        WorkOrder workOrder2 = new WorkOrder(-1, 1, "07/05/2023");
        listWorkOrder.create(workOrder1);
        listWorkOrder.create(workOrder2);
        listWorkOrder.deleteMany();
        assertEquals(0, listWorkOrder.findMany().size());
    }

    @Test
    void getNewAvailableOrder(){
        WorkOrderDaoList listWorkOrder = new WorkOrderDaoList();
        listWorkOrder.deleteMany();
        WorkOrder workOrder1 = new WorkOrder(-1, 0, "06/05/2023");
        WorkOrder workOrder2 = new WorkOrder(-1, 1, "07/05/2023");
        WorkOrder workOrder3 = new WorkOrder(-1, 2, "08/05/2023");
        listWorkOrder.create(workOrder1);
        listWorkOrder.create(workOrder2);
        listWorkOrder.create(workOrder3);

        workOrder1.setTechnician(0);
        workOrder2.setTechnician(1);
        listWorkOrder.update(workOrder1);
        listWorkOrder.update(workOrder2);

        assertEquals("Aberta", listWorkOrder.getNewAvailableOrder().getStatus());
    }



}
