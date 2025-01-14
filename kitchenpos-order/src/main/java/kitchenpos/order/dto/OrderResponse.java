package kitchenpos.order.dto;

import kitchenpos.order.domain.Order;
import kitchenpos.order.domain.OrderStatus;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class OrderResponse {
    private Long id;
    private Long orderTableId;
    private OrderStatus orderStatus;
    private List<OrderLineItemResponse> orderLineItems;

    public OrderResponse() {}

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.orderTableId = order.getOrderTableId();
        this.orderStatus = order.getOrderStatus();
        this.orderLineItems = OrderLineItemResponse.list(order.getOrderLineItems().getOrderLineItems());
    }

    public static OrderResponse of(Order order) {
        return new OrderResponse(order);
    }

    public static List<OrderResponse> list(List<Order> orders) {
        return orders.stream()
                .map(OrderResponse::new)
                .collect(toList());
    }

    public Long getId() {
        return id;
    }

    public Long getOrderTableId() {
        return orderTableId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<OrderLineItemResponse> getOrderLineItems() {
        return orderLineItems;
    }
}
