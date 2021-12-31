package co.com.sofka.page;

import co.com.sofka.model.ZonaFitModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class ZonaFitPage extends CommonActionOnPages {

    private final ZonaFitModel zonaFitModel;

    //Constructor
    public ZonaFitPage(ZonaFitModel zonaFitModel, WebDriver webDriver) {
        super(webDriver);
        this.zonaFitModel = zonaFitModel;
        PageFactory.initElements(webDriver, this);
    }
    //Sikulix elements.
    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\page\\zonafit\\picture\\";
    private static final String ADD_CAR = PAGE_BASE_PATCH + "AddCar.PNG";
    private static final String CAR_TO_BUY = PAGE_BASE_PATCH + "CarToBuy.PNG";
    private static final String ADD_PRODUCT = PAGE_BASE_PATCH + "AddProduct.PNG";
    private static final String CHECKOUT = PAGE_BASE_PATCH + "ProceedCheckoutLocator.PNG";


    //Locators
    @CacheLookup
    @FindBy(css = "a[class='dashicons-tag mega-menu-link']")
    WebElement ofertasBottonLocator;
    @CacheLookup
    @FindBy(css = "a[class='dashicons-hourglass mega-menu-link']")
    WebElement outletBottonLocator;

    @CacheLookup
    @FindBy(css = "a[class='checkout-button button alt wc-forward']")
    WebElement checkoutLocator;

    @CacheLookup
    @FindBy(css = "input[data-brand='768']")
    WebElement filtroMarcarLocator;

    @CacheLookup
    @FindBy(id = "billing_myfield12")
    WebElement idNumberLocator;
    @CacheLookup
    @FindBy(id = "billing_email")
    WebElement emailLocator;
    @CacheLookup
    @FindBy(id = "billing_first_name")
    WebElement nameLocator;
    @CacheLookup
    @FindBy(id = "billing_last_name")
    WebElement lastNameLocator;
    @CacheLookup
    @FindBy(id = "select2-billing_state-container")
    WebElement state;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement stateLocator;

    @CacheLookup
    @FindBy(id = "select2-billing_city-container")
    WebElement city;
    @CacheLookup
    @FindBy(css = "input[class='select2-search__field']")
    WebElement cityLocator;
    @CacheLookup
    @FindBy(id = "billing_address_1")
    WebElement addressLocator;
    @CacheLookup
    @FindBy(id = "billing_address_2")
    WebElement complementaryAddressLocator;
    @CacheLookup
    @FindBy(id = "billing_phone")
    WebElement cellphoneLocator;
    @CacheLookup
    @FindBy(id="order_comments")
    WebElement noteLocator;
    @CacheLookup
    @FindBy(xpath = "/html/body/div[1]/main/div[2]/div/div/div[1]/h2")
    WebElement checkPayment;

    //ubicación cero

    @CacheLookup
    @FindBy(id = "payment_method_bank_transfer_1")
    WebElement paymentLocator;

    //ubicacion 2

    @CacheLookup
    @FindBy(id = "terms")
    WebElement termsLocator;

    @CacheLookup
    @FindBy(id="place_order")
    WebElement buttonOrdenLocator;

    //Funtions

    //Scenario 1
    public void productosEnOferta(){
        //ingreso Ofertas
        click(ofertasBottonLocator);
        click(ofertasBottonLocator);

        //Filtrar marca
        click(filtroMarcarLocator);
        scrollDown();
    }

    public void carroDeCompras(){
        //Añadir al carrro
        click(ADD_CAR);
        scrollDown();
        click(ADD_CAR);
        scrollUp();

        //Precionar Carro de compras
        click(CAR_TO_BUY);

        //Agrega otro producto
        click(ADD_PRODUCT);

        //Proceed Checkout
        click(CHECKOUT);
    }

    //Scenario 2
    public void productosEnOutlet(){
        //ingreso Ofertas
        click(outletBottonLocator);
    }

    public void carroDeComprasScenario2(){
        //Añadir al carrro
        click(ADD_CAR);
        scrollDown();
        click(ADD_CAR);
        scrollUp();

        //Precionar Carro de compras
        click(CAR_TO_BUY);

        //Proceed Checkout

        click(checkoutLocator);
    }

    //General Scenario
    public void campoDeCompra(){
        //Information
        typeInto(idNumberLocator,zonaFitModel.getIdNumber());
        typeInto(emailLocator,zonaFitModel.getEmail());
        typeInto(nameLocator,zonaFitModel.getName());
        typeInto(lastNameLocator,zonaFitModel.getLastName());

        scrollDown();
        click(state);
        typeInto(stateLocator,zonaFitModel.getState().getValue());
        pressEnter(stateLocator);

        click(city);
        typeInto(cityLocator,zonaFitModel.getCity().getValue());
        pressEnter(cityLocator);

        typeInto(addressLocator,zonaFitModel.getAddress());
        typeInto(complementaryAddressLocator,zonaFitModel.getComplementaryAddress());
        typeInto(cellphoneLocator, zonaFitModel.getCellPhone());
        typeInto(noteLocator, zonaFitModel.getNote());

        waitForElementToBeInvisible(By.className("blockOverlay"));
        scrollTo(paymentLocator);
        click(paymentLocator);

        waitForElementToBeInvisible(By.className("blockOverlay"));
        scrollTo(termsLocator);
        click(termsLocator);
        click(buttonOrdenLocator);

    }
    public String checkPayment(){
        waitToBeClickable(checkPayment);
        return getText(checkPayment);
    }

}
