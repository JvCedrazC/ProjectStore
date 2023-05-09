package DaoTest;

import Model.Component;
import dao.ComponentDao.ComponentDaoList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestComponentDao {
    @Test
    public void create(){
        ComponentDaoList componentList = new ComponentDaoList();
        componentList.deleteMany();
        Component component1 = new Component(0, 20.0, 30.0, "RAM");
        componentList.create(component1);
        assertEquals(0, componentList.findById(0).getId());
    }

    @Test
    public void findById(){
        ComponentDaoList componentList = new ComponentDaoList();
        componentList.deleteMany();
        Component component1 = new Component(0, 20.0, 30.0, "RAM");
        Component component2 = new Component(1, 25.0, 40.0, "PROCESSADOR");
        componentList.create(component1);
        componentList.create(component2);
        assertEquals(20.0, componentList.findById(0).getCost());
        assertEquals(25.0, componentList.findById(1).getCost());
    }
    @Test
    public void findMany(){
        ComponentDaoList componentList = new ComponentDaoList();
        assertEquals(2, componentList.findMany().size());
    }
    @Test
    public void update(){
        ComponentDaoList componentList = new ComponentDaoList();
        Component component1 = new Component(0, 25.0, 38.0, "RAM");
        componentList.update(component1);
        assertEquals(38.0, componentList.findById(0).getPrice());
    }

}
