package Model;

import java.io.Serializable;

public abstract class User implements Serializable {
    int id;
    String name;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    User(int id, String name){
        setName(name);
        setId(id);
    }
}
