package products;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private Categories category;
    private List<Product> products = new ArrayList<>();

    public Categories getCategory() {
        return category;
    }

    public List<Product> getProducts() {
        return products;
    }

    Category (Categories category) {
        this.category = category;
    }

    void addProductToCategory (Product product) {
        products.add(product);
    }
}

