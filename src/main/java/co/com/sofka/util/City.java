package co.com.sofka.util;

public enum City {

    MEDELLIN_ANT("Medellin"),
    SABANETA_ANT("Sabaneta"),
    ENVIGADO_ANT("Envigado"),
    BOGOTA_CUND("Bogota"),
    CALI_VDC("Cali"),
    POPAYAN_CAU("Popayan"),
    BOYACA_BOY("Boyaca");

    private final String value;

    public String getValue() {
        return value;
    }

    City(String value) {
        this.value = value;
    }
}
