package Model;

public class Customer{
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email){
        setId(id);
        setName(name);
        setEmail(email);
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

