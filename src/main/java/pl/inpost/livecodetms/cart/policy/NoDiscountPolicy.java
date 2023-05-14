package pl.inpost.livecodetms.cart.policy;

import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.model.CartItemView;

import java.math.BigDecimal;
import java.util.List;

public final class NoDiscountPolicy implements DiscountPolicy {

    @Override
    public BigDecimal apply(@NonNull final List<CartItemView> items) {
        return items.stream().map(CartItemView::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
