package dao.ServicesDao;

import FilesUtils.ManagingFiles;
import Model.Services;
import javafx.concurrent.Service;

import java.util.ArrayList;

public class ServicesDaoList  {
   private ManagingFiles managingFiles;
   ServicesDaoList(){
       this.managingFiles = new ManagingFiles("services.bin");
   }

   public void create(ArrayList<Services> services){
       managingFiles.save(services);

   }
   public ArrayList<Services> retrieve(){
       return managingFiles.retrieve();
   }

}
