package pl.inpost.livecodetms.adapter.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.model.CartId;
import pl.inpost.livecodetms.cart.model.CartView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cart")
public class CartEntity {
    @Id
    private UUID id;
    @OneToMany(mappedBy = "cart", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CartItemEntity> items;
    @NonNull
    private BigDecimal totalPrice;

    public CartEntity() {
    }

    public static CartEntity of(@NonNull final CartWriteModel writeModel) {
        final var entity = new CartEntity();
        entity.setId(writeModel.getId().getValue());
        entity.setItems(writeModel.getItems().stream()
            .map(
                product -> CartItemEntity.of(
                    product,
                    entity
                )
            )
            .toList());
        entity.setTotalPrice(writeModel.getTotalPrice());

        return entity;
    }

    public CartView toView() {
        return new CartView(
            new CartId(id),
            items.stream()
                .map(CartItemEntity::toView)
                .toList(),
            totalPrice.setScale(2, RoundingMode.HALF_UP)
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(@NonNull final UUID id) {
        this.id = id;
    }

    public void setItems(@NonNull final List<CartItemEntity> items) {
        this.items = items;
    }

    public void setTotalPrice(@NonNull final BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartEntity that = (CartEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(items, that.items)) return false;
        return totalPrice.equals(that.totalPrice);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + totalPrice.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
            "id=" + id +
            ", items=" + items +
            ", totalPrice=" + totalPrice +
            '}';
    }
}
