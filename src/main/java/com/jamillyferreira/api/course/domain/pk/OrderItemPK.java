package com.jamillyferreira.api.course.domain.pk;

import com.jamillyferreira.api.course.domain.Product;
import com.jamillyferreira.api.course.domain.Order;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class OrderItemPK implements Serializable {
    @ManyToOne // MUITAS OrderItemPK podem referenciar o MESMO Order
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne // MUITAS OrderItemPK podem referenciar o MESMO Product
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
