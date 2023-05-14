package pl.inpost.livecodetms.cart;


import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.model.CartId;
import pl.inpost.livecodetms.cart.model.CartItemView;
import pl.inpost.livecodetms.cart.model.CartView;
import pl.inpost.livecodetms.adapter.jpa.CartWriteModel;
import pl.inpost.livecodetms.cart.policy.DiscountPolicy;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

public final class CartAggregate {
    private final transient DiscountPolicy discountPolicy;
    private final CartId id;
    private final List<CartItemView> items;
    private final BigDecimal totalPrice;

    private CartAggregate(
        @NonNull final CartId id,
        @NonNull final List<CartItemView> items,
        @NonNull final BigDecimal totalPrice,
        @NonNull final DiscountPolicy discountPolicy
    ) {
        this.id = id;
        this.items = List.copyOf(items);
        this.discountPolicy = discountPolicy;
        this.totalPrice = totalPrice;
    }

    public static CartAggregate fromView(
        @NonNull final CartView cartView,
        @NonNull final DiscountPolicy discountPolicy
    ) {
        return new CartAggregate(
            cartView.getId(),
            cartView.getItems(),
            cartView.getTotalPrice(),
            discountPolicy
        );
    }

    public static CartAggregate create(@NonNull final DiscountPolicy discountPolicy) {
        return new CartAggregate(CartId.generate(), List.of(), BigDecimal.ZERO, discountPolicy);
    }

    public CartWriteModel addItems(@NonNull final List<CartItemView> items) {
        final var allItems = Stream.concat(this.items.stream(), items.stream()).toList();
        final var totalPrice = discountPolicy.apply(allItems);

        return new CartWriteModel(id, allItems, totalPrice);
    }

}
