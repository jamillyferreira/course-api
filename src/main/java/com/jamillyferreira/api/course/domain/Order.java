package com.jamillyferreira.api.course.domain;

import com.jamillyferreira.api.course.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private OrderStatus orderStatus;

    @ManyToOne // MUITOS pedidos pertencem a UM cliente
    @JoinColumn(name = "client_id") // coluna que guarda o ID do cliente
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>(); // Uso SET para que nao permita duplicadas

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order(Instant moment, User client) {
        this.moment = moment;
        this.client = client;
    }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public Double getTotal() {
        double sum = 0.0;
        for(OrderItem x : items) {
            sum =+ x.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
