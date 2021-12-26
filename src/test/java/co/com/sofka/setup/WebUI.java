package co.com.sofka.setup;

import co.com.sofka.util.Log4jValues;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;



public class WebUI {
    private static final String WEB_DRIVER_EDGE_DRIVER = "webdriver.chrome.driver";
    private static final String WEB_DRIVER_EDGE_DRIVER_PATH = "src/test/resources/driver/windows/chrome/chromedriver.exe";

    private static final String DEMO_QA_URL = "https://zonafit.co/";

    protected WebDriver driver;

    private void setupWebDriver() {
        System.setProperty(WEB_DRIVER_EDGE_DRIVER, WEB_DRIVER_EDGE_DRIVER_PATH);
    }

    private void setupWebDriverChromeDriverUrl() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DEMO_QA_URL);
    }

    protected void generalSetup() {
//        setUplog4();
        setupWebDriver();
        setupWebDriverChromeDriverUrl();
    }

    protected void quitDrive() {
        driver.quit();
    }

//    protected void setUplog4() {
//        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
//    }
}
