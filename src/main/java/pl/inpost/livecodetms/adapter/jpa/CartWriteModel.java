package pl.inpost.livecodetms.adapter.jpa;

import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.model.CartId;
import pl.inpost.livecodetms.cart.model.CartItemView;

import java.math.BigDecimal;
import java.util.List;

public final class CartWriteModel {
    private final CartId id;
    private final List<CartItemView> items;
    private final BigDecimal totalPrice;

    public CartWriteModel(
        @NonNull final CartId id,
        @NonNull final List<CartItemView> items,
        @NonNull final BigDecimal totalPrice
    ) {
        this.id = id;
        this.items = List.copyOf(items);
        this.totalPrice = totalPrice;
    }

    public CartId getId() {
        return id;
    }

    public List<CartItemView> getItems() {
        return List.copyOf(items);
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
