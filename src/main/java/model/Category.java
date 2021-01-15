package model;

public class Category {
    private int id;
    private String categoryDevice;

    public Category(int id, String categoryDevice) {
        this.id = id;
        this.categoryDevice = categoryDevice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryDevice() {
        return categoryDevice;
    }

    public void setCategoryDevice(String categoryDevice) {
        this.categoryDevice = categoryDevice;
    }
}
