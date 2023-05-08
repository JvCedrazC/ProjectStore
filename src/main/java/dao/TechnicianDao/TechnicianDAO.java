package dao.TechnicianDao;

import dao.CRUD;
import Model.Technician;

public interface TechnicianDAO extends CRUD<Technician> {
    public Technician create(Technician technician);
    public Technician findByName(String name);
}
