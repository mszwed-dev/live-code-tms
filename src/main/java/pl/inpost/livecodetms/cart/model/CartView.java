package pl.inpost.livecodetms.cart.model;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.List;

public class CartView {
    private final CartId id;
    private final List<CartItemView> items;
    private final BigDecimal totalPrice;

    public CartView(
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartView cartView = (CartView) o;

        if (!id.equals(cartView.id)) return false;
        if (!items.equals(cartView.items)) return false;
        return totalPrice.equals(cartView.totalPrice);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + items.hashCode();
        result = 31 * result + totalPrice.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CartView{" +
            "id=" + id +
            ", items=" + items +
            ", totalPrice=" + totalPrice +
            '}';
    }
}
