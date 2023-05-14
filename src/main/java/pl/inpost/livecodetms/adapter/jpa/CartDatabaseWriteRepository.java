package pl.inpost.livecodetms.adapter.jpa;

import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.model.CartId;

public final class CartDatabaseWriteRepository implements CartWriteRepository {
    private final CartEntityRepository cartEntityRepository;

    public CartDatabaseWriteRepository(@NonNull final CartEntityRepository cartEntityRepository) {
        this.cartEntityRepository = cartEntityRepository;
    }

    @Override
    public CartId save(@NonNull final CartWriteModel writeModel) {
        return new CartId(cartEntityRepository.save(CartEntity.of(writeModel)).getId());
    }
}
