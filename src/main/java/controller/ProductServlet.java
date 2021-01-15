package controller;

import model.Category;
import model.DAO.CategoryDAO;
import model.DAO.ProductDAO;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    private Product product;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
        categoryDAO = new CategoryDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            default:
                showProductList(request, response);
                break;
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        List<Category> categoryList = categoryDAO.getCategoryList();
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        dispatcher.forward(request,response);
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Product> productList = productDAO.getProductList();
        request.setAttribute("productList",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/products.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.getProductById(id);
        List<Category> categoryList = categoryDAO.getCategoryList();
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/edit.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request,response);
                break;
            default:

                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("nameProduct");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        productDAO.insertProduct(new Product(productName, price, quantity, color, description, categoryId));

        response.sendRedirect("/products");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String productName = request.getParameter("nameProduct");
        int id = Integer.parseInt(request.getParameter("id"));
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        productDAO.updateProduct(new Product(id,productName, price, quantity, color, description, categoryId));

        response.sendRedirect("/products");
    }
}
