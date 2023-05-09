package dao.CustomerDao;

import FilesUtils.ManagingFiles;
import Model.Customer;
import Model.Technician;

import java.util.ArrayList;
import java.util.List;
public class CustomerDaoList implements CustomerDAO{
    private ManagingFiles managingFiles;
    private int nextID;

    public CustomerDaoList(){
        this.managingFiles = new ManagingFiles("Customer.bin");
        ArrayList<Customer> lista = this.managingFiles.retrieve();
        if (lista.size() == 0){
            nextID = lista.size();
        } else{
            nextID = 0;
        }
    }

    @Override
    public Customer create(Customer customer){
        ArrayList<Customer> lista = this.managingFiles.retrieve();
        customer.setId(nextID);
        nextID++;
        lista.add(customer);
        managingFiles.save(lista);
        return customer;
    }

    @Override
    public Customer findById(int id) {
        ArrayList<Customer> lista = this.managingFiles.retrieve();
        for (Customer customer: lista) {
            if (customer.getId() == id){
                return customer;
            }
        } return null;
    }
    @Override
    public ArrayList<Customer> findMany(){
        ArrayList<Customer> lista = this.managingFiles.retrieve();
        ArrayList<Customer> listCustomer = new ArrayList<Customer>();
        for (Object o : lista) {
            listCustomer.add((Customer) o);
        }
        return listCustomer;
    }

    @Override
    public void update(Customer customer){
        ArrayList<Customer> lista = this.managingFiles.retrieve();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == customer.getId()) {
                lista.set(i, customer);
                managingFiles.save(lista);
                return;
            }
        }
    }
    @Override
    public void deleteById(int id){
        ArrayList<Customer> lista = this.managingFiles.retrieve();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                break;
            }
        }
        changeId(lista);
        managingFiles.save(lista);
    }
    public void deleteMany(){
       ArrayList<Customer> lista = new ArrayList<Customer>();
       this.nextID =  0;
       managingFiles.save(lista);
    }
    private void changeId(ArrayList<Customer> lista){
        for (int i = 0; i < lista.size();i++){
            lista.get(i).setId(i);
        }
        managingFiles.save(lista);
    }
}
