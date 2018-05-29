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
        stock.addProduct(new Categories[]{Categories.Chocolate}, "Snickers", 10, 15);
        Assert.assertEquals(stock.findAllProducts().get(0).getName(), "Snickers");

        stock.addProduct(new Categories[]{Categories.Healthy, Categories.Children, Categories.Natural}, "Milk", 1, 20);
        Assert.assertEquals(stock.findAllProducts().get(1).getCount(), 1);

        stock.addProduct(new Categories[]{Categories.Healthy, Categories.Meat}, "Hum", 10, 80);
        Assert.assertEquals(stock.findAllProducts().get(2).getPrise(), 80);
        Assert.assertEquals(stock.findAllProducts().get(2).getName(), "Hum");
    }

    @Test
    public void get_products_in_category() {
        stock.addProduct(new Categories[]{Categories.Healthy, Categories.Children, Categories.Natural}, "Milk", 1, 20);
        stock.addProduct(new Categories[]{Categories.Healthy, Categories.Meat}, "Hum", 10, 80);

        List<Product> products = stock.findProductsByCategory(Categories.Healthy);

        Assert.assertEquals(products.get(0).getName(), "Milk");
        Assert.assertEquals(products.get(1).getName(), "Hum");
    }

    @Test
    public void get_categories_of_product() {
        stock.addProduct(new Categories[]{Categories.Healthy, Categories.Children, Categories.Natural}, "Milk", 1, 20);

        List<Category> categories = stock.findAllProducts().get(0).getCategories();

        Assert.assertEquals(categories.size(), 3);
        Assert.assertEquals(categories.get(0).getCategory(), Categories.Healthy);
        Assert.assertEquals(categories.get(1).getCategory(), Categories.Children);
        Assert.assertEquals(categories.get(2).getCategory(), Categories.Natural);
    }
}

