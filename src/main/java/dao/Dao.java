package dao;

import dao.ComponentDao.ComponentDAO;
import dao.CustomerDao.CustomerDAO;
import dao.CustomerDao.CustomerDaoList;
import dao.TechnicianDao.TechnicianDAO;
import dao.TechnicianDao.TechnicianDaoList;
import dao.WorkOrderDao.WorkOrderDAO;
import dao.WorkOrderDao.WorkOrderDaoList;

public class Dao{
    public static CustomerDAO customerDao;
    public static TechnicianDAO technicianDao;
    public static WorkOrderDAO workOrderDAO;
    public static CustomerDAO customerDAO;
    public static ComponentDAO componentDAO;
    public static CustomerDAO getCustomer(){
        if (customerDao == null){
            customerDao = new CustomerDaoList();
        }
        return customerDao;
    }
    public static TechnicianDAO getTechnicianDao(){
        if (technicianDao == null){
            technicianDao = new TechnicianDaoList();
        }
        return technicianDao;
    }
    public static WorkOrderDAO workOrderDao(){
        if (workOrderDAO == null){
            workOrderDAO = new WorkOrderDaoList();
        }
        return workOrderDAO;
    }

}
