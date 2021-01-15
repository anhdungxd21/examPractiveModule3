package model;

public class Product {
    private int id;
    private String productName;
    private double price;
    private int quantity;
    private String color;
    private String descripts;
    private String category;
    private int categoryId;

    public Product( String productName, double price, int quantity, String color, String descripts, int categoryId) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.descripts = descripts;
        this.categoryId = categoryId;
    }

    public Product(int id, String productName, double price, int quantity, String color, String descripts, int categoryId) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.descripts = descripts;
        this.categoryId = categoryId;
    }

    public Product(int id, String productName, double price, int quantity, String color, String descripts, String category, int categoryId) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.descripts = descripts;
        this.category = category;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripts() {
        return descripts;
    }

    public void setDescripts(String descripts) {
        this.descripts = descripts;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
