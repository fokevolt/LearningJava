package products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product {

    private final List<Category> categoryList;

    private final String name;

    private int count;
    private int prise;

    public List<Category> getCategories() {
        return Collections.unmodifiableList(categoryList);
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

    Product(List<Category> productCategories, String name, int count, int prise) {
        this.categoryList = new ArrayList<>(productCategories);
        this.name = name;
        this.count = count;
        this.prise = prise;
    }
}
