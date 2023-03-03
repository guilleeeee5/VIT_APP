package org.vaadin.example;

public class Admin extends User{


    public Admin() {

    }

    public Admin(String name, String apellido, String password, String email, int ID, int ID_admin) {
        super(name, apellido, password, email, ID);
    }
}
