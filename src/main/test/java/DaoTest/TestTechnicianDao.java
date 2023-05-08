package DaoTest;

import Model.Technician;

import dao.TechnicianDao.TechnicianDaoList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestTechnicianDao {
    public TechnicianDaoList technicianDaoList = new TechnicianDaoList();
    @Test
    void create(){
        Technician technician = new Technician(-1, "Lionel Messi");
        technicianDaoList.create(technician);
        assertEquals("Lionel Messi", technicianDaoList.findById(0).getName());
    }
    @Test
    void findById(){
        Technician technician1 = new Technician(-1, "Lionel Messi");
        technicianDaoList.create(technician1);
        Technician technician2 = new Technician(-1, "Joe Biden");
        technicianDaoList.create(technician2);
        assertEquals("Lionel Messi", technicianDaoList.findById(0).getName());
        assertEquals("Joe Biden", technicianDaoList.findById(1).getName());
    }

    @Test
    void findByName(){
        Technician technician1 = new Technician(-1, "Vladimir Putin");
        technicianDaoList.create(technician1);
        Technician technician2 = new Technician(-1, "Ivete Sangalo");
        technicianDaoList.create(technician2);
        assertEquals(0, technicianDaoList.findByName("Vladimir Putin").getId());
        assertEquals(1, technicianDaoList.findByName("Ivete Sangalo").getId());
    }

    @Test
    void findMany(){
        ArrayList<Technician> technicians = new ArrayList<Technician>();
        Technician technician1 = new Technician(-1, "Vladimir Putin");
        technicianDaoList.create(technician1);
        Technician technician2 = new Technician(-1, "Ivete Sangalo");
        technicianDaoList.create(technician2);
        technicians = technicianDaoList.findMany();
        assertEquals(2, technicians.size());
        assertEquals("Vladimir Putin", technicians.get(0).getName());
        assertEquals("Ivete Sangalo", technicians.get(1).getName());
    }
    @Test
    void update(){
        Technician technician1 = new Technician(-1, "Vladimir Putin");
        technicianDaoList.create(technician1);
        Technician technician2 = new Technician(-1, "Ivete Sangalo");
        technicianDaoList.create(technician2);
        technician2.setName("Marta");
        technicianDaoList.update(technician2);

        assertEquals("Marta", technicianDaoList.findById(1).getName());
    }

    @Test
    void deleteById(){
        Technician technician1 = new Technician(-1, "Vladimir Putin");
        technicianDaoList.create(technician1);
        Technician technician2 = new Technician(-1, "Ivete Sangalo");
        technicianDaoList.create(technician2);
        technicianDaoList.deleteById(1);
        assertEquals(1, technicianDaoList.findMany().size());
    }
    @Test
    void deleteMany(){
        Technician technician1 = new Technician(-1, "Vladimir Putin");
        technicianDaoList.create(technician1);
        Technician technician2 = new Technician(-1, "Ivete Sangalo");
        technicianDaoList.create(technician2);
        technicianDaoList.deleteMany();
        assertEquals(0, technicianDaoList.findMany().size());
    }
}
