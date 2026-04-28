package DomainEntities;

import resources.PasswordUtils;

public class User {
    private String name;
    private String password;
    private String salt;

    public User(){
        this("Thomas", "secret");
    }

    public User(String name, String password){
        this.name = name;
        this.password = password;
        this.salt = PasswordUtils.generateSalt();
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
