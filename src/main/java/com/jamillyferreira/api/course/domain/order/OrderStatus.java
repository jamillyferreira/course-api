package com.jamillyferreira.api.course.domain.order;

public enum OrderStatus {
    WAITING_PAYMENT("Aguardando pagamento"),
    PAID("Pago"),
    SHIPPED("Enviado"),
    DELIVERED("Entregue"),
    CANCELED("Cancelado");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
