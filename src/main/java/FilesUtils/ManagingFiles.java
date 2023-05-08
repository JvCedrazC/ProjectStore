package FilesUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ManagingFiles {

     private String filename;

     public ManagingFiles(String name){
         this.filename = name;
     }

     public <T> void save(ArrayList<T> list){
         try {
             FileOutputStream file = new FileOutputStream(this.filename);
             ObjectOutputStream object = new ObjectOutputStream(file);
             object.writeObject(list);
             object.close();

         }catch (IOException e){
             throw new RuntimeException(e);
         }
     }
     public <T> ArrayList<T> retrieve(ArrayList<T> list){
         
     }
}
