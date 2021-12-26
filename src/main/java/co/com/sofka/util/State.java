package co.com.sofka.util;

public enum State {
    ANTIOQUIA("Antioquia"),
    CUNDINAMARCA("Cundinamarca"),
    VALLE_DEL_CAUCA("Valle del Cauca"),
    CAUCA("Cauca"),
    BOYACA("Boyaca");

    private final String value;

    public String getValue() {
        return value;
    }

    State(String value) {
        this.value = value;
    }
}
