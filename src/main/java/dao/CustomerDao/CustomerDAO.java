package dao.CustomerDao;

import dao.CRUD;
import Model.Customer;

public interface CustomerDAO extends CRUD<Customer>{
    public Customer create(Customer customer);
}
