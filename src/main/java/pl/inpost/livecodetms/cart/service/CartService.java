package pl.inpost.livecodetms.cart.service;

import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.model.CartId;
import pl.inpost.livecodetms.cart.model.CartView;
import pl.inpost.livecodetms.cart.model.ProductId;

import java.util.List;

public interface CartService {
    CartId createCart(@NonNull final List<ProductId> productIds);

    CartView getCart(@NonNull final CartId cartId);

    void addProductToCart(@NonNull final CartId cartId, @NonNull final List<ProductId> productIds);
}
