package org.vaadin.example;

public class User {
    private String name;
    private String apellido;
    private String password;
    private String email;
    private int ID;

    public User() {
    }

    public User(String name, String apellido, String password, String email) {
        this.name = name;
        this.apellido = apellido;
        this.password = password;
        this.email = email;
    }

    public User(String name, String apellido, String password, String email, int ID) {
        this.name = name;
        this.apellido = apellido;
        this.password = password;
        this.email = email;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", apellido='" + apellido + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", ID=" + ID +
                '}';
    }
}
