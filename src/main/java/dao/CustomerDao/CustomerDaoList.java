package dao.CustomerDao;

import Model.Customer;

import java.util.ArrayList;
import java.util.List;
public class CustomerDaoList implements CustomerDAO{
    private List<Customer> lista;
    private int nextID;

    public CustomerDaoList(){
        this.lista = new ArrayList<Customer>();
        this.nextID = 0;
    }

    @Override
    public Customer create(Customer customer){
        customer.setId(nextID);
        nextID++;
        this.lista.add(customer);
        return customer;
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer: this.lista) {
            if (customer.getId() == id){
                return customer;
            }
        } return null;
    }
    @Override
    public List<Customer> findMany(){
        ArrayList<Customer> listCustomer = new ArrayList<Customer>();
        for (Object o : this.lista) {
            listCustomer.add((Customer) o);
        }
        return listCustomer;
    }

    @Override
    public void update(Customer customer){
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getId() == customer.getId()) {
                this.lista.set(i, customer);
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
       this.lista = new ArrayList<Customer>();
       this.nextID =  0;
    }
    private void changeId(){
        for (int i = 0; i < this.lista.size();i++){
            this.lista.get(i).setId(i);
        }
    }
}
