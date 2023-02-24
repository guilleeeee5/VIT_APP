package com.VITAPP.Backend;

public class Admin extends User{
    private boolean admin;

    public Admin() {

    }

    public Admin(String name, String apellido, String password, String email, int ID, int ID_admin) {
        super(name, apellido, password, email, ID);
        this.admin = admin;
    }

    public boolean getID_admin() {
        return admin;
    }

    public void setID_admin(boolean ID_admin) {
        this.admin = admin;
    }
}
