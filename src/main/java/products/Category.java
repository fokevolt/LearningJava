package products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category {
    private final CategoryType category;
    private final List<Product> products = new ArrayList<>();

    public CategoryType getCategoryType() {
        return category;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    Category(CategoryType category) {
        this.category = category;
    }

    void addProductToCategory(Product product) {
        products.add(product);
    }
}

