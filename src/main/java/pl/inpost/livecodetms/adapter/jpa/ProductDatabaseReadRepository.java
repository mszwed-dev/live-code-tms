package pl.inpost.livecodetms.adapter.jpa;

import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.cart.model.Product;
import pl.inpost.livecodetms.cart.model.ProductId;

import java.util.List;

public final class ProductDatabaseReadRepository implements ProductReadRepository {
    private final ProductEntityRepository productEntityRepository;

    public ProductDatabaseReadRepository(@NonNull final ProductEntityRepository productEntityRepository) {
        this.productEntityRepository = productEntityRepository;
    }

    @Override
    public Product findById(@NonNull final ProductId productId) {
        return productEntityRepository.findById(productId.getValue())
            .map(ProductEntity::toDomainModel)
            .orElseThrow(() -> new RuntimeException("Product not found: " + productId));
    }

    @Override
    public List<Product> findByIdIn(@NonNull final List<ProductId> productsIds) {
        return productEntityRepository.findProductEntitiesByIdIn(productsIds.stream().map(ProductId::getValue).toList())
            .stream()
            .map(ProductEntity::toDomainModel)
            .toList();
    }
}
