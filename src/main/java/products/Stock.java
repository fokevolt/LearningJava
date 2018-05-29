package products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {

    private Map<Categories, Category> categories = new HashMap<>();
    private List<Product> products = new ArrayList<>();

    private List<Category> makeCategoryList(Categories[] category) {
        List<Category> categoriesOfProduct = new ArrayList<>();
        for(Categories current: category) {
            categoriesOfProduct.add(categories.get(current));
        }
        return categoriesOfProduct;
    }

    public void addProduct (Categories[] category, String name, int count, int price){

        for(Categories current: category) {
            if(!categories.containsKey(current)) {
                categories.put(current, new Category(current));
            }
        }
        List<Category> productCategories= makeCategoryList(category);
        Product product = new Product(productCategories, name, count, price);
        products.add(product);

        for(Category current: productCategories) {
            current.addProductToCategory(product);
        }
    }

    public List<Product> findAllProducts() {
        return products;
    }

    public List<Product> findProductsByCategory(Categories category) {
        return categories.get(category).getProducts();
    }
}
