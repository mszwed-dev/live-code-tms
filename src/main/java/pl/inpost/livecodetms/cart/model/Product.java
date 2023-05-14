package pl.inpost.livecodetms.cart.model;


import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public final class Product {
    private final ProductId id;
    private final String name;
    private final String brand;
    private final BigDecimal price;

    public Product(
        @NonNull final ProductId id,
        @NonNull final String name,
        @NonNull final String brand,
        @NonNull final BigDecimal price
    ) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public ProductId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
