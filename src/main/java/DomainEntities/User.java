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
        // this.password = password;
        this.salt = PasswordUtils.generateSalt();
        this.password = PasswordUtils.hashedPassword(password, this.salt);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean verifyPassword(String passwordEntered){
        return PasswordUtils.verifyUserPassword(passwordEntered, salt, password);
    }

    public void setPassword(String password){
        this.password = PasswordUtils.hashedPassword(password, salt);
    }
}
