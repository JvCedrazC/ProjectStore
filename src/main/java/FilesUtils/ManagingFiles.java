package FilesUtils;

import java.io.*;
import java.util.ArrayList;

public class ManagingFiles implements Serializable {

     private String fileName;

     public ManagingFiles(String name){
         this.fileName = name;
     }

     public <T> void save(ArrayList<T> list){
         try {
             FileOutputStream file = new FileOutputStream(this.fileName);
             ObjectOutputStream object = new ObjectOutputStream(file);
             object.writeObject(list);
             object.close();

         }catch (IOException e){
             throw new RuntimeException(e);
         }
     }
     public <T> ArrayList<T> retrieve(){
         try{
             ArrayList<T> list;
             File file = new File(fileName);
             if (!file.exists()){
                 save(new ArrayList<T>());
             }
             FileInputStream fileStream = new FileInputStream(this.fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);
             list = (ArrayList<T>) objectInputStream.readObject();
             objectInputStream.close();
             return list;

         }catch (IOException | ClassNotFoundException exception){
             throw new RuntimeException(exception);
         }
     }
}
