package pl.inpost.livecodetms.cart.policy;

import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.model.CartItemView;

import java.math.BigDecimal;
import java.util.List;

public interface DiscountPolicy {
    BigDecimal apply(@NonNull final List<CartItemView> itemViews);
}
