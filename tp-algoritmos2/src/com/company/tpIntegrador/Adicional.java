package com.company.tpIntegrador;

import java.math.BigDecimal;

public class Adicional {
    private String name;
    private BigDecimal charge;

    public Adicional(String name, BigDecimal charge) {
        this.name = name;
        this.charge = charge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }
}
