/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_package;

public class User {
    private String email;
    private String name;
    private String address;

    public User(String email, String name, String address) {
        this.email = email;
        this.name = name;
        this.address = address;
    }

    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
