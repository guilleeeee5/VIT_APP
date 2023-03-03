package com.VITAPP.Backend;

public class Admin extends User{


    public Admin() {

    }

    public Admin(int ID, String name, String apellido, String password, String email) {
        super(ID, name, apellido, password, email);
    }
}
