package model.DAO;

import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/exammodule3?useSSL=false";
    private String jdbcUsername = "admin";
    private String jdbcPassword = "Admin@123";

    private static final String SELECT_ALL_CATEGORY =  "select * from category;";

    public CategoryDAO(){}

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

    public List<Category> getCategoryList(){
        List<Category> categoryList = new ArrayList<>();

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY)){

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String categoryDevice = rs.getString("categoryDevice");

                categoryList.add(new Category(id,categoryDevice));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categoryList;
    }
}
