package pl.inpost.livecodetms.cart.model;

import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public final class CartItemView {
    private final CartItemId id;
    private final ProductId productId;
    private final String name;
    private final String brand;
    private final BigDecimal price;

    public CartItemView(
        @NonNull final CartItemId id,
        @NonNull final ProductId productId,
        @NonNull final String name,
        @NonNull final String brand,
        @NonNull final BigDecimal price
    ) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public static CartItemView of(@NonNull final Product product) {
        return new CartItemView(
            CartItemId.generate(),
            product.getId(),
            product.getName(),
            product.getBrand(),
            product.getPrice()
        );
    }

    public CartItemId getId() {
        return id;
    }

    public ProductId getProductId() {
        return productId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItemView that = (CartItemView) o;

        if (!id.equals(that.id)) return false;
        if (!productId.equals(that.productId)) return false;
        if (!name.equals(that.name)) return false;
        if (!brand.equals(that.brand)) return false;
        return price.equals(that.price);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + productId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + brand.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CartItemView{" +
            "id=" + id +
            ", productId=" + productId +
            ", name='" + name + '\'' +
            ", brand='" + brand + '\'' +
            ", price=" + price +
            '}';
    }
}
