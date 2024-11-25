package models;

public class UserBuilder {
    private String name;
    private String password;
    private String email = "EMAIL_NOT_SET";

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public User build(){
        if (name == null || password == null){
            throw new IllegalArgumentException("Name and password have to be set");
        }
        return new User(name,password,email);
    }

}
