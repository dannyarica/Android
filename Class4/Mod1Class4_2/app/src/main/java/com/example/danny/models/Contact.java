package com.example.danny.models;

/**
 * Created by DArica on 30/09/2015.
 */
public class Contact {
    private String _name;
    private String _lastName;
    private int _age;

    public Contact(String name, String lastName, int age) {
        _name = name;
        _lastName = lastName;
        _age = age;
    }

    public String getName() {
        return _name;
    }

    public String getLastName() {
        return _lastName;
    }

    public int getAge() {
        return _age;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public void setLastName(String lastName) {
        this._lastName = lastName;
    }

    public void setAge(int age) {
        this._age = age;
    }
}
