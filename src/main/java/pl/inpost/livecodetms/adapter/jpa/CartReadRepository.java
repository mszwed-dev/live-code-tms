package pl.inpost.livecodetms.adapter.jpa;

import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.model.CartId;
import pl.inpost.livecodetms.cart.model.CartView;

public interface CartReadRepository {

    CartView findById(@NonNull final CartId cartId);

}
