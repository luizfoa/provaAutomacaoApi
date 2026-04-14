package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import model.Product;
import factory.ProductFactory;
import service.ProductService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProductSteps {
    ProductService service = new ProductService();
    Response response;
    Product product;
    int productId;

    @Given("que eu possuo um produto válido")
    public void produtoValido() {
        productId = 1;
    }

    @When("eu buscar o produto")
    public void buscarProduto() {
        response = service.getProduct(productId);
    }

    @Given("que eu tenho dados de produto válidos")
    public void dadosProduto() {
        product = ProductFactory.createProduct();
    }

    @When("eu criar um produto")
    public void criarProduto() {
        response = service.createProduct(product);
    }

    @Given("que eu criei um produto")
    public void criarProdutoAntes() {
        product = ProductFactory.createProduct();
        productId = service.createProduct(product)
                .then()
                .extract()
                .path("id");
    }

    @When("eu atualizar o produto")
    public void atualizarProduto() {
        String body = "{\n" +
                "  \"price\": 99\n" +
                "}";

        response = service.updateProduct(productId, body);
    }

    @When("eu deletar o produto")
    public void deletarProduto() {
        response = service.deleteProduct(productId);
    }

    @Then("os campos obrigatorios devem estar presentes")
    public void validarCamposObrigatorios() {
        response.then()
                .body("id", notNullValue())
                .body("title", notNullValue())
                .body("title", not(emptyString()));
    }

    @Then("o status code deve ser {int}")
    public void validarStatusCode(int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

    @Then("o status code deve ser 200 ou 404")
    public void validarStatusCodeFlexivel() {
        assertThat(response.getStatusCode(), anyOf(is(200), is(404)));
    }
}
