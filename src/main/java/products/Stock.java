package products;

import java.util.*;

public class Stock {

    private final Map<CategoryType, Category> categories = new HashMap<>();
    private final List<Product> products = new ArrayList<>();

    private List<Category> makeCategoryList(CategoryType... categoryTypes) {
        List<Category> categoriesOfProduct = new ArrayList<>();
        for (CategoryType current : categoryTypes) {
            Category category = categories.get(current);
            if (category == null) {
                category = new Category(current);
                categories.put(current, category);
            }
            categoriesOfProduct.add(category);
        }
        return categoriesOfProduct;
    }

    public void addProduct(String name, int count, int price, CategoryType... category) {

        List<Category> productCategories = makeCategoryList(category);
        Product product = new Product(productCategories, name, count, price);
        products.add(product);

        for (Category current : productCategories) {
            current.addProductToCategory(product);
        }
    }

    public List<Product> findAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public List<Product> findProductsByCategory(CategoryType category) {
        Category current = categories.get(category);
        if (current == null) {
            return Collections.emptyList();
        }
        return categories.get(category).getProducts();
    }
}
