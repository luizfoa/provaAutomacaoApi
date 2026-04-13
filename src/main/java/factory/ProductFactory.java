package factory;

import model.Product;

import java.util.List;

public class ProductFactory {
    public static Product createProduct() {
        Product product = new Product();
        product.title = "Produto Teste " + System.currentTimeMillis();
        product.price = 50;
        product.brand = "Marca Teste";
        product.category = "skincare";
        product.images = List.of("https://i.dummyjson.com/data/products/1/1.jpg");
        product.thumbnail = "https://i.dummyjson.com/data/products/1/thumbnail.jpg";
        product.description = "Produto criado automaticamente";
        return product;
    }
}
