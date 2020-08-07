package com.lizhen.pojo;

public class User {
    private int id;
    private String name;
    private String pwd;
    private String permis;

    public User() {
    }

    public User(int id, String name, String pwd, String permis) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.permis = permis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", permis='" + permis + '\'' +
                '}';
    }
}
