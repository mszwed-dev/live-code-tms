package pl.inpost.livecodetms.adapter.jpa;

import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.model.CartId;

public interface CartWriteRepository {
    CartId save(@NonNull final CartWriteModel writeModel);
}
