package pl.inpost.livecodetms.adapter.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.model.CartItemId;
import pl.inpost.livecodetms.cart.model.CartItemView;
import pl.inpost.livecodetms.cart.model.ProductId;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "cart_item")
class CartItemEntity {
    @Id
    private UUID id;
    @Column(nullable = false)
    private UUID productId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToOne(optional = false, targetEntity = CartEntity.class, fetch = FetchType.LAZY)
    private CartEntity cart;

    protected CartItemEntity() {
    }

    static CartItemEntity of(
        @NonNull final CartItemView cartItemView,
        @NonNull final CartEntity cartEntity
    ) {
        final var entity = new CartItemEntity();
        entity.setId(cartItemView.getId().getValue());
        entity.setProductId(cartItemView.getProductId().getValue());
        entity.setName(cartItemView.getName());
        entity.setBrand(cartItemView.getBrand());
        entity.setPrice(cartItemView.getPrice());
        entity.setCart(cartEntity);

        return entity;
    }

    CartItemView toView() {
        return new CartItemView(
            new CartItemId(id),
            new ProductId(productId),
            name,
            brand,
            price
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }
}
