package dao.ServicesDao;

import Model.Services;
import dao.CRUD;

public interface ServicesDAO extends CRUD {
    void create(Services services);
}
