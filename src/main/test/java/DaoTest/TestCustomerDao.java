package DaoTest;

import Model.Customer;
import Model.Technician;
import dao.CustomerDao.CustomerDaoList;
import dao.TechnicianDao.TechnicianDaoList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCustomerDao {


    Customer customer2 = new Customer(-1, "Lebron James", "Lebron_LA_Lakers_23@hotmail.com");
    public CustomerDaoList customerDaoList = new CustomerDaoList();
    @Test
    void create(){
        Customer customer = new Customer(-1, "Neymar jr", "NeymarJunior@gmail.com");
        customerDaoList.create(customer);
        assertEquals("Neymar jr", customerDaoList.findById(0).getName());
    }
    @Test
    void findById(){
        Customer customer1 = new Customer(-1, "Neymar jr", "NeymarJunior@gmail.com");
        Customer customer2 = new Customer(-1, "Lebron James", "Lebron_LA_Lakers_23@hotmail.com");
        customerDaoList.create(customer1);
        customerDaoList.create(customer2);
        assertEquals("Neymar jr", customerDaoList.findById(0).getName());
        assertEquals("Lebron James", customerDaoList.findById(1).getName());
    }


    @Test
    void findMany(){
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer1 = new Customer(-1, "Neymar jr", "NeymarJunior@gmail.com");
        Customer customer2 = new Customer(-1, "Lebron James", "Lebron_LA_Lakers_23@hotmail.com");
        customerDaoList.create(customer1);
        customerDaoList.create(customer2);
        customers = customerDaoList.findMany();
        assertEquals(2, customers.size());

    }
    @Test
    void update(){
        Customer customer1 = new Customer(-1, "Neymar jr", "NeymarJunior@gmail.com");
        Customer customer2 = new Customer(-1, "Lebron James", "Lebron_LA_Lakers_23@hotmail.com");
        customerDaoList.create(customer1);
        customerDaoList.create(customer2);
        customer1.setEmail("NeymarJunior10@gmail.com");
        customerDaoList.update(customer1);
        assertEquals("NeymarJunior10@gmail.com", customerDaoList.findById(0).getEmail());

    }

    @Test
    void deleteById(){
        Customer customer1 = new Customer(-1, "Neymar jr", "NeymarJunior@gmail.com");
        Customer customer2 = new Customer(-1, "Lebron James", "Lebron_LA_Lakers_23@hotmail.com");
        customerDaoList.create(customer1);
        customerDaoList.create(customer2);

    }
    @Test
    void deleteMany(){
        Customer customer1 = new Customer(-1, "Neymar jr", "NeymarJunior@gmail.com");
        Customer customer2 = new Customer(-1, "Lebron James", "Lebron_LA_Lakers_23@hotmail.com");
        customerDaoList.create(customer1);
        customerDaoList.create(customer2);

    }
}
