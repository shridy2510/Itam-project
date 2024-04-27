package com.project.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataAsset {
    public void addDataAsset(String name,int quantity,String employeeName,String companyName,String categoryName, String licenseName)  {
        try {
            String sql = "INSERT INTO asset (name,quantity, employee,company,category,license) VALUES (?, ?,?,?,?,?)";
            Connection connection = DataConnection.getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, name);          // Gán giá trị cho tham số đầu tiên
            preparedstatement.setInt(2, quantity);
            preparedstatement.setString(3, employeeName);
            preparedstatement.setString(4, companyName);
            preparedstatement.setString(5, categoryName);
            preparedstatement.setString(6, licenseName);
            preparedstatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sai");
        }
    }
    public void updateRowAsset(int id,String name,int quantity,String employee,String company, String category, String license){
        try {
            String sql = "UPDATE Asset Set Name= ? ,Quantity=?,Employee=?,Company=?,Category=?,License=?   WHERE idAsset = ?";
            Connection connection = DataConnection.getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, name);
            preparedstatement.setInt(2, quantity);
            preparedstatement.setString(3, employee);
            preparedstatement.setString(4, company);
            preparedstatement.setString(5, category);
            preparedstatement.setString(6, license);
            preparedstatement.setInt(7, id);
            preparedstatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sai");
        }


    }
    public void deleteRowFromDB (int number) {
        try {
            String sql = "DELETE FROM Asset WHERE idAsset = ?";
            Connection connection = DataConnection.getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setInt(1, number);
            preparedstatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sai");
        }
    }
    public  ObservableList<Asset> getDataAssetTable() {
        ObservableList<Asset> assetTable = FXCollections.observableArrayList();

        String sql = "SELECT* FROM Asset";

        try (Connection connection = DataConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("idAsset");
                String name = resultSet.getString("Name");
                int quantity = resultSet.getInt("Quantity");
                String employee = resultSet.getString("Employee");
                String company = resultSet.getString("Company");
                String category = resultSet.getString("Category");
                String license = resultSet.getString("License");
                assetTable.add(new Asset(id,name,quantity,employee,company,category,license));
            }
        } catch (SQLException e) {
            System.out.println("sai");
        }

        return assetTable;
    }



}
