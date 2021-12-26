package co.com.sofka.stepdefinition;

import co.com.sofka.model.ZonaFitModel;
import co.com.sofka.page.ZonaFitPage;
import co.com.sofka.setup.WebUI;
import co.com.sofka.util.City;
import co.com.sofka.util.State;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ZonaFitTestStepdefinition extends WebUI {

    private ZonaFitModel cliente;


    //Scenario 1
    @Given("El usuario esta en la pagina principal de ZonaFit")
    public void elUsuarioEstaEnLaPaginaPrincipalDeZonaFit() {
        try {
            generalSetup();
            generateClient();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
        }
    }

    @When("el cliente da click en la categoria de Oferta donde filtra y escoge dos productos")
    public void elClienteDaClickEnLaCategoriaDeOfertaDondeFiltraYEscogeDosProductos() {
        try {
            ZonaFitPage zonaFitPage = new ZonaFitPage(cliente, super.driver);
            zonaFitPage.productosEnOferta();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
        }
    }

    @When("en el carrito de compra agrega otro pruducto y presiona finalizar compra")
    public void enElCarritoDeCompraPresionaFinalizarCompra() {
        try {
            ZonaFitPage zonaFitPage = new ZonaFitPage(cliente, super.driver);
            zonaFitPage.carroDeCompras();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
        }
    }

    @When("llena los campos para realizar la compra y realiza su pedido")
    public void llenaLosCamposParaRealizarLaCompra() {
        try {
            ZonaFitPage zonaFitPage = new ZonaFitPage(cliente, super.driver);
            zonaFitPage.campoDeCompra();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
        }
    }

    @Then("el cliete debera ver un mensaje de confirmacion")
    public void elClieteDeberaVerUnMensajeDeConfirmacion() {
        try {
            ZonaFitPage zonaFitPage = new ZonaFitPage(cliente, super.driver);

            Assertions.assertEquals("CONVENIO RECAUDO ZONA FIT – BALOTO", zonaFitPage.checkPayment());
            quitDrive();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
        }
    }

    //Scenario 2
    @Given("El usuario entra en la pagina principal de ZonaFit")
    public void elUsuarioEstaEnLaPaginaPrincipalDeZona() {
        try {
            generalSetup();
            generateClient();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
        }
    }
    @When("el cliente da click en la categoria de Outlet donde filtra y escoge 2 productos")
    public void elClienteDaClickEnLaCategoriaDeOutletDondeFiltraYEscoge2Productos() {
        try {
            ZonaFitPage zonaFitPage = new ZonaFitPage(cliente, super.driver);
            zonaFitPage.productosEnOutlet();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
        }
    }
    @When("en el carrito de compra presiona finalizar compra")
    public void enElCarritoDeCompraPresionaFinalizar() {
        try {
            ZonaFitPage zonaFitPage = new ZonaFitPage(cliente, super.driver);
            zonaFitPage.carroDeComprasScenario2();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
        }
    }
    @When("llena los campos para realizar la compra y realiza sus pedidos")
    public void llenaLosCamposParaRealizarCompra() {
        try {
            ZonaFitPage zonaFitPage = new ZonaFitPage(cliente, super.driver);
            zonaFitPage.campoDeCompra();

        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
        }
    }
    @Then("el cliete debera ve un mensaje de confirmacion")
    public void elClieteDeberaVeUnMensajeDeConfirmacionn() {
        try {
            ZonaFitPage zonaFitPage = new ZonaFitPage(cliente, super.driver);

            Assertions.assertEquals("CONVENIO RECAUDO ZONA FIT – BALOTO", zonaFitPage.checkPayment());
            quitDrive();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
        }
    }

    private void generateClient () {
        cliente = new ZonaFitModel();
        cliente.setIdNumber("112128128128");
        cliente.setEmail("pedidos.falsos@pruebasQA.com");
        cliente.setName("Ivan");
        cliente.setLastName("Zapata");
        cliente.setState(State.CAUCA);
        cliente.setCity(City.POPAYAN_CAU);
        cliente.setAddress("Cl. 12 ###30-80");
        cliente.setComplementaryAddress("Apt 302");
        cliente.setCellPhone("3005554486");
        cliente.setNote("Es un pedido falso, de pruebas de QA");
    }
}
