package products;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StockTest {
    private Stock stock;

    @Before
    public void set_up() {
        stock = new Stock();
    }

    @Test
    public void add_products() {
        stock.addProduct("Snickers", 10, 15, CategoryType.Chocolate);
        Assert.assertEquals(stock.findAllProducts().get(0).getName(), "Snickers");

        stock.addProduct("Milk", 1, 20, CategoryType.Healthy, CategoryType.Children, CategoryType.Natural);
        Assert.assertEquals(stock.findAllProducts().get(1).getCount(), 1);

        stock.addProduct("Hum", 10, 80, CategoryType.Healthy, CategoryType.Meat);
        Assert.assertEquals(stock.findAllProducts().get(2).getPrise(), 80);
        Assert.assertEquals(stock.findAllProducts().get(2).getName(), "Hum");
    }

    @Test
    public void get_products_in_category() {
        stock.addProduct("Milk", 1, 20, CategoryType.Healthy, CategoryType.Children, CategoryType.Natural);
        stock.addProduct("Hum", 10, 80, CategoryType.Healthy, CategoryType.Meat);

        List<Product> products = stock.findProductsByCategory(CategoryType.Healthy);

        Assert.assertEquals(products.get(0).getName(), "Milk");
        Assert.assertEquals(products.get(1).getName(), "Hum");
    }

    @Test
    public void get_categories_of_product() {
        stock.addProduct("Milk", 1, 20, CategoryType.Healthy, CategoryType.Children, CategoryType.Natural);

        List<Category> categories = stock.findAllProducts().get(0).getCategories();

        Assert.assertEquals(categories.size(), 3);
        Assert.assertEquals(categories.get(0).getCategoryType(), CategoryType.Healthy);
        Assert.assertEquals(categories.get(1).getCategoryType(), CategoryType.Children);
        Assert.assertEquals(categories.get(2).getCategoryType(), CategoryType.Natural);
    }
}

