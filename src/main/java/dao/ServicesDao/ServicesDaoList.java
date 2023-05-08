package dao.ServicesDao;

import javafx.concurrent.Service;

import java.util.ArrayList;

public class ServicesDaoList  {
    private ArrayList<Service> listServices = new ArrayList<Service>();
    public ServicesDaoList(ArrayList<Service> listServices){
        this.listServices = listServices;

    }

}
