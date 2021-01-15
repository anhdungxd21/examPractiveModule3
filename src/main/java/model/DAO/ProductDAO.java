package model.DAO;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/exammodule3?useSSL=false";
    private String jdbcUsername = "admin";
    private String jdbcPassword = "Admin@123";

    private static final String SELECT_ALL_PRODUCT =  "SELECT products.id, products.productName, products.price, products.quantity, products.color, products.descripts, category.categoryDevice,products.categoryId"
                                + " FROM products"
                                + " INNER JOIN category ON products.categoryId=category.id;";

    private static final String INSERT_PRODUCT = "INSERT INTO products(productName, price, quantity, color, descripts, categoryId) VALUES"
                                                + " (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_PRODUCT_BY_ID = "SELECT products.id, products.productName, products.price, products.quantity, products.color, products.descripts, category.categoryDevice,products.categoryId " +
                                                        "FROM products " +
                                                        "INNER JOIN category ON products.categoryId=category.id WHERE products.id = ?;";

    private static final String UPDATE_PRODUCT_BY_ID = "UPDATE products SET productName = ?, price = ?, quantity = ?, color = ?, descripts = ?, categoryId = ? WHERE id = ?;";

    private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM products where id = ?";

    private static final String SEARCH_PRODUCT = "SELECT products.id, products.productName, products.price, products.quantity, products.color, products.descripts, category.categoryDevice,products.categoryId " +
                                                "FROM products " +
                                                "INNER JOIN category ON products.categoryId=category.id WHERE LIKE ?;";

    public ProductDAO(){}

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

    public List<Product> getProductList(){
        List<Product> productList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)){
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int id = rs.getInt("products.id");
                String productName = rs.getString("products.productName");
                double price = rs.getDouble("products.price");
                int quantity = rs.getInt("products.quantity");
                String color = rs.getString("products.color");
                String descripts = rs.getString("products.descripts");
                String category = rs.getString("category.categoryDevice");
                int cateforyId = rs.getInt("products.categoryId");
                productList.add(new Product(id,productName,price,quantity,color,descripts,category,cateforyId));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return productList;
    }
    public List<Product> searchProduct(String search){

        List<Product> productList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)){
            preparedStatement.setString(1,"%"+search+"%");
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int id = rs.getInt("products.id");
                String productName = rs.getString("products.productName");
                double price = rs.getDouble("products.price");
                int quantity = rs.getInt("products.quantity");
                String color = rs.getString("products.color");
                String descripts = rs.getString("products.descripts");
                String category = rs.getString("category.categoryDevice");
                int cateforyId = rs.getInt("products.categoryId");
                productList.add(new Product(id,productName,price,quantity,color,descripts,category,cateforyId));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return productList;

    }

    public Product getProductById(int productId){
        Product product = null;

        try(Connection connection = getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)){
            preparedStatement.setInt(1,productId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("products.id");
                String productName = rs.getString("products.productName");
                double price = rs.getDouble("products.price");
                int quantity = rs.getInt("products.quantity");
                String color = rs.getString("products.color");
                String descripts = rs.getString("products.descripts");
                String category = rs.getString("category.categoryDevice");
                int cateforyId = rs.getInt("products.categoryId");
                product =  new Product(id,productName,price,quantity,color,descripts,category,cateforyId);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return product;
    }

    public boolean insertProduct(Product product){
        boolean isInsert = false;

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)){
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getCategory());
            preparedStatement.setInt(6,product.getCategoryId());
            isInsert = preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return  isInsert;
    }

    public boolean updateProduct(Product product){
        boolean rowUpdate = false;

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_BY_ID)){

            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getCategory());
            preparedStatement.setInt(6,product.getCategoryId());
            preparedStatement.setInt(7,product.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return rowUpdate;
    }

    public boolean deleteProduct(int id){
        boolean rowUpdate = false;

        try(Connection connection= getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID)){
            preparedStatement.setInt(1,id);

            rowUpdate = preparedStatement.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return rowUpdate;
    }
}
