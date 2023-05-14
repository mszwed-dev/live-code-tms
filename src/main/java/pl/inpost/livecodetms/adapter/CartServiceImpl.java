package pl.inpost.livecodetms.adapter;

import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import pl.inpost.livecodetms.cart.model.CartId;
import pl.inpost.livecodetms.cart.model.CartItemView;
import pl.inpost.livecodetms.cart.model.CartView;
import pl.inpost.livecodetms.cart.model.Product;
import pl.inpost.livecodetms.cart.model.ProductId;
import pl.inpost.livecodetms.adapter.jpa.CartReadRepository;
import pl.inpost.livecodetms.adapter.jpa.CartWriteRepository;
import pl.inpost.livecodetms.adapter.jpa.ProductReadRepository;
import pl.inpost.livecodetms.cart.service.CartAggregateFactory;
import pl.inpost.livecodetms.cart.service.CartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CartServiceImpl implements CartService {
    private final CartWriteRepository cartWriteRepository;
    private final CartReadRepository cartReadRepository;
    private final CartAggregateFactory cartAggregateFactory;
    private final ProductReadRepository productReadRepository;

    public CartServiceImpl(
        @NonNull final CartWriteRepository cartWriteRepository,
        @NonNull final CartReadRepository cartReadRepository,
        @NonNull final CartAggregateFactory cartAggregateFactory,
        @NonNull final ProductReadRepository productReadRepository
    ) {
        this.cartWriteRepository = cartWriteRepository;
        this.cartReadRepository = cartReadRepository;
        this.cartAggregateFactory = cartAggregateFactory;
        this.productReadRepository = productReadRepository;
    }

    @Override
    @Transactional
    public CartId createCart(@NonNull final List<ProductId> productIds) {
        final var items = getCartItemsViews(productIds);

        final var aggregate = CartAggregateFactory.createAggregate();

        final var writeModel = aggregate.addItems(items);

        return cartWriteRepository.save(writeModel);
    }

    @Override
    @Transactional(readOnly = true)
    public CartView getCart(@NonNull final CartId cartId) {
        return cartReadRepository.findById(cartId);
    }


    @Override
    @Transactional
    public void addProductToCart(@NonNull final CartId cartId, @NonNull final List<ProductId> productIds) {
        final var aggregate = cartAggregateFactory.getAggregate(cartId);
        final var items = getCartItemsViews(productIds);

        final var writeModel = aggregate.addItems(items);

        cartWriteRepository.save(writeModel);
    }

    private List<CartItemView> getCartItemsViews(@NonNull final List<ProductId> productIds) {
        final var items = new ArrayList<CartItemView>();
        final var products = productReadRepository.findByIdIn(productIds);

        for (final var productId : productIds) {
            products.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .ifPresentOrElse(
                    product -> items.add(CartItemView.of(product)),
                    () -> {
                        throw new RuntimeException("Product not found: " + productId);
                    }
                );
        }

        return items;
    }

}
