package dao.ComponentDao;

import Model.Component;
import dao.CRUD;

import java.util.List;

public interface ComponentDAO extends CRUD<Component>{
    public Component create(Component component);
    public Component findById(int id);
    public List<Component> findMany();
    public void deleteById(int id);
    public void deleteMany();
    public void update(Component component);
}
