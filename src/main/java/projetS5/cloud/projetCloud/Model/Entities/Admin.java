package projetS5.cloud.projetCloud.Model.Entities;

import projetS5.cloud.projetCloud.Context.PgsqlContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin {

    int adminId;
    String name;
    String firstName;
    int age;
    int genre;
    String address;
    String email;
    String password;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String login(Connection connection, String email, String password) throws Exception {
//        Statement statement = connection.createStatement();
//        PreparedStatement prstmt = connection.prepareStatement("SELECT adminId FROM admin WHERE email = ? AND password = ?");
//        prstmt.setString(1, email);
//        prstmt.setString(2, password);
//
//        ResultSet rs = prstmt.executeQuery();
//        String adminId = null;
//        if (rs.next()) {
//            adminId = rs.getString("adminId");
//        }
        return "";
    }


}
