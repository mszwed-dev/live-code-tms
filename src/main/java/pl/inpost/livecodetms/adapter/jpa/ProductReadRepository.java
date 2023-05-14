package pl.inpost.livecodetms.adapter.jpa;

import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.model.Product;
import pl.inpost.livecodetms.cart.model.ProductId;

import java.util.List;

public interface ProductReadRepository {
    Product findById(@NonNull final ProductId id);

    List<Product> findByIdIn(@NonNull final List<ProductId> productsIds);
}
