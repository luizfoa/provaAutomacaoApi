package service;

import io.restassured.response.Response;
import model.Product;

import static io.restassured.RestAssured.given;

public class ProductService {
    public Response getProduct(int id) {
        return given()
                .when()
                .get("/products/" + id);
    }

    public Response createProduct(Product product) {
        return given()
                .contentType("application/json")
                .body(product)
                .when()
                .post("/products/add");
    }

    public Response updateProduct(int id, Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .put("/products/" + id);
    }

    public Response deleteProduct(int id) {
        return given()
                .when()
                .delete("/products/" + id);
    }
}
