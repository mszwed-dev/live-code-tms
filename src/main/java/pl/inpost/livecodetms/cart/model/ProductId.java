package pl.inpost.livecodetms.cart.model;


import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;
import java.util.UUID;

public final class ProductId {
    private final UUID value;

    @JsonCreator
    public ProductId(final UUID value) {
        this.value = value;
    }

    public static ProductId generate() {
        return new ProductId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductId productId = (ProductId) o;

        return Objects.equals(value, productId.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ProductId{" +
            "value=" + value +
            '}';
    }
}
