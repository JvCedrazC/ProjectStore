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
}
