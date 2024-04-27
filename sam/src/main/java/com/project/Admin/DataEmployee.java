package com.project.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataEmployee {
    public ObservableList<String> getDataEmployeeNames() {
        ObservableList<String> employeeNames = FXCollections.observableArrayList();

        String sql = "SELECT name FROM Employee";

        try (Connection connection = DataConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String productName = resultSet.getString("name");
                employeeNames.add(productName);
            }
        } catch (SQLException e) {
            System.out.println("sai");
        }

        return employeeNames;
    }

    public static void addDataEmployee(String name,String address,String city,String email, int number) throws SQLException {
        try {
            String sql = "INSERT INTO Employee (name, address,city,email,contact) VALUES (?, ?,?,?,?)";
            Connection connection = DataConnection.getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, name);          // Gán giá trị cho tham số đầu tiên
            preparedstatement.setString(2, address);
            preparedstatement.setString(3, city);
            preparedstatement.setString(4, email);
            preparedstatement.setInt(5, number);
            preparedstatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sai");
        }
    }
    public void updateRowEmployee(int id,String name,String address, String city,String email,int contact){
        try{
            String sql = "UPDATE Employee Set Name= ? ,Address=?, City=?,Email=?,Contact=? WHERE idEmployee = ?";
            Connection connection = DataConnection.getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, name);
            preparedstatement.setString(2, address);
            preparedstatement.setString(3, city);
            preparedstatement.setString(4, email);
            preparedstatement.setInt(5, contact);
            preparedstatement.setInt(6, id);
            preparedstatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("sai");
        }

    }
    public void deleteRowFromDB (int number) {
        try{
            String sql="DELETE FROM Employee WHERE idEmployee = ?";
            Connection connection = DataConnection.getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setInt(1, number);
            preparedstatement.executeUpdate();}
        catch(SQLException e){
            System.out.println("sai");
        }
    }


    public ObservableList<Employee> getDataEmployeeTable() {
        ObservableList<Employee> companyTable = FXCollections.observableArrayList();

        String sql = "SELECT* FROM Employee";

        try (Connection connection = DataConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("idEmployee");
                String name = resultSet.getString("Name");
                String address = resultSet.getString("Address");
                String city = resultSet.getString("City");
                String email = resultSet.getString("Email");
                int contact = resultSet.getInt("Contact");
                companyTable.add(new Employee(id,name,address,city,email,contact));
            }
        } catch (SQLException e) {
            System.out.println("sai");
        }

        return companyTable;
    }

}
