package pl.inpost.livecodetms.cart.service;

import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.policy.NoDiscountPolicy;
import pl.inpost.livecodetms.cart.CartAggregate;
import pl.inpost.livecodetms.cart.model.CartId;
import pl.inpost.livecodetms.adapter.jpa.CartReadRepository;

public final class CartAggregateFactory {
    private final CartReadRepository cartReadRepository;

    public CartAggregateFactory(@NonNull final CartReadRepository cartReadRepository) {
        this.cartReadRepository = cartReadRepository;
    }

    public static CartAggregate createAggregate() {
        return CartAggregate.create(new NoDiscountPolicy());
    }

    public CartAggregate getAggregate(@NonNull final CartId cartId) {
        final var cartView = cartReadRepository.findById(cartId);
        return CartAggregate.fromView(cartView, new NoDiscountPolicy());
    }
}
