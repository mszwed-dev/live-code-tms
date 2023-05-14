package pl.inpost.livecodetms.cart.model;


import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.UUID;

public final class CartItemId {
    private final UUID value;

    @JsonCreator
    public CartItemId(final UUID value) {
        this.value = value;
    }

    public static CartItemId generate() {
        return new CartItemId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }
}
