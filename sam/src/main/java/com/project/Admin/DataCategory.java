package com.project.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataCategory {

    public static void addDataCategory(String name,String description) throws SQLException {
        try{ String sql= "INSERT INTO Category (name, description) VALUES (?, ?)";
            Connection connection=DataConnection.getConnection();
            PreparedStatement preparedstatement= connection.prepareStatement(sql);
            preparedstatement.setString(1, name);          // Gán giá trị cho tham số đầu tiên
            preparedstatement.setString(2, description);
            preparedstatement.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("sai");

        }

    }
    public ObservableList<String> getDataCategoryNames() {
        ObservableList<String> categoryNames = FXCollections.observableArrayList();

        String sql = "SELECT name FROM Category";

        try (Connection connection = DataConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String productName = resultSet.getString("name");
                categoryNames.add(productName);
            }
        } catch (SQLException e) {
            System.out.println("sai");
        }

        return categoryNames;
    }
    public void updateRowCategory(int id,String name,String description){
        try{
        String sql = "UPDATE Category Set Name= ? ,Description=?  WHERE idCategory = ?";
        Connection connection = DataConnection.getConnection();
        PreparedStatement preparedstatement = connection.prepareStatement(sql);
        preparedstatement.setString(1, name);
        preparedstatement.setString(2, description);
        preparedstatement.setInt(3, id);
        preparedstatement.executeUpdate();
        }
        catch (SQLException e) {
        System.out.println("sai");
        }
    }
    public void deleteRowFromDB (int number) {
        try {
            String sql = "DELETE FROM Category WHERE idCategory = ?";
            Connection connection = DataConnection.getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setInt(1, number);
            preparedstatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sai");
        }
    }
    public  ObservableList<Category> getDataCategoryTable()  {
        ObservableList<Category> categoryTable = FXCollections.observableArrayList();
        String sql=" SELECT * FROM Category";
        try {

            Connection connection = DataConnection.getConnection();
            Statement statement= connection.createStatement();
            ResultSet resultset= statement.executeQuery(sql);
            while(resultset.next()){
                int id = resultset.getInt("idCategory");
                String name= resultset.getString("Name");
                String description= resultset.getString("Description");
                categoryTable.add(new Category(id,name,description));

            }
        }
        catch(SQLException e){
            System.out.println("sai");
        }
        return categoryTable;

    }

}
