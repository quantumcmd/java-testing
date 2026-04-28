package DomainEntities;

public class User {
    private String name;
    private String password;

    public User(){
        this("Thomas", "secret");
    }

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
