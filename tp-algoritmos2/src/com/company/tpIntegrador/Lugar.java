package com.company.tpIntegrador;

public class Lugar {
    private String name;
    private String description; //Puede funcionar como origen o destino en tabla destinos

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Lugar(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
