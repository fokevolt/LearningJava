package products;

import java.util.List;

public class Product {

    private List<Category> categoryList;

    private String name;

    private int count;
    private int prise;

    public List<Category> getCategories() {
        return categoryList;
    }
    public String getName() {
        return name;
    }
    public int getCount() {
        return count;
    }
    public int getPrise() {
        return prise;
    }

    Product (List<Category> productCategories, String name, int count, int prise) {
        this.categoryList = productCategories;
        this.name = name;
        this.count = count;
        this.prise = prise;
    }
}
