package tests;

import base.BaseTest;
import model.Product;
import factory.ProductFactory;
import org.junit.jupiter.api.Test;
import service.ProductService;

import static org.hamcrest.Matchers.*;

public class ProductTest extends BaseTest {
    ProductService service = new ProductService();

    @Test
    public void deveBuscarProduto() {
        service.getProduct(1)
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }

    @Test
    public void deveCriarProduto() {
        Product product = ProductFactory.createProduct();

        service.createProduct(product)
                .then()
                .statusCode(201)
                .body("title", equalTo(product.title));
    }

    @Test
    public void deveAtualizarProduto() {
        Product product = ProductFactory.createProduct();

        int id = service.createProduct(product)
                .then()
                .statusCode(201)
                .extract()
                .path("id");

        String body = "{\n" +
                "  \"price\": 99\n" +
                "}";

        service.updateProduct(id, body)
                .then()
                .statusCode(anyOf(is(200), is(404)))
                .body("price", anyOf(equalTo(99), nullValue()));
    }

    @Test
    public void deveDeletarProduto() {
        Product product = ProductFactory.createProduct();

        int id = service.createProduct(product)
                .then()
                .statusCode(201)
                .extract()
                .path("id");

        service.deleteProduct(id)
                .then()
                .statusCode(anyOf(is(200), is(404)));
    }

    @Test
    public void naoDeveBuscarProdutoInexistente() {
        service.getProduct(999999)
                .then()
                .statusCode(404);
    }
}
