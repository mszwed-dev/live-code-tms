package pl.inpost.livecodetms.adapter.jpa;

import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.model.CartId;
import pl.inpost.livecodetms.cart.model.CartView;

public final class CartDatabaseReadRepository implements CartReadRepository {
    private final CartEntityRepository cartEntityRepository;

    public CartDatabaseReadRepository(@NonNull final CartEntityRepository cartEntityRepository) {
        this.cartEntityRepository = cartEntityRepository;
    }

    @Override
    public CartView findById(@NonNull final CartId cartId) {
        return cartEntityRepository.findById(cartId.getValue())
            .map(CartEntity::toView)
            .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

}
