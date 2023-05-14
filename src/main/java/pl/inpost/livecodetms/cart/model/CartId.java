package pl.inpost.livecodetms.cart.model;


import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.UUID;

public final class CartId {
    private final UUID value;


    @JsonCreator
    public CartId(final UUID value) {
        this.value = value;
    }

    public static CartId generate() {
        return new CartId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }
}
