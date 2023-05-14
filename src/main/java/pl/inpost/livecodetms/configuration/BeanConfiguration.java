package pl.inpost.livecodetms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import pl.inpost.livecodetms.adapter.CartServiceImpl;
import pl.inpost.livecodetms.adapter.jpa.ProductDatabaseReadRepository;
import pl.inpost.livecodetms.adapter.jpa.CartDatabaseReadRepository;
import pl.inpost.livecodetms.adapter.jpa.CartDatabaseWriteRepository;
import pl.inpost.livecodetms.adapter.jpa.CartEntityRepository;
import pl.inpost.livecodetms.adapter.jpa.CartReadRepository;
import pl.inpost.livecodetms.adapter.jpa.CartWriteRepository;
import pl.inpost.livecodetms.adapter.jpa.ProductEntityRepository;
import pl.inpost.livecodetms.adapter.jpa.ProductReadRepository;
import pl.inpost.livecodetms.cart.service.CartAggregateFactory;
import pl.inpost.livecodetms.cart.service.CartService;

@Configuration
public class BeanConfiguration {

    @Bean
    public CartWriteRepository cartWriteRepository(@NonNull final CartEntityRepository cartEntityRepository) {
        return new CartDatabaseWriteRepository(cartEntityRepository);
    }

    @Bean
    public CartReadRepository cartReadRepository(@NonNull final CartEntityRepository cartEntityRepository) {
        return new CartDatabaseReadRepository(cartEntityRepository);
    }

    @Bean
    public ProductReadRepository productReadRepository(@NonNull final ProductEntityRepository productEntityRepository) {
        return new ProductDatabaseReadRepository(productEntityRepository);
    }

    @Bean
    public CartAggregateFactory cartAggregateFactory(@NonNull final CartReadRepository cartReadRepository) {
        return new CartAggregateFactory(cartReadRepository);
    }

    @Bean
    public CartService cartService(
        @NonNull final CartWriteRepository cartWriteRepository,
        @NonNull final CartReadRepository cartReadRepository,
        @NonNull final CartAggregateFactory cartAggregateFactory,
        @NonNull final ProductReadRepository productReadRepository
    ) {
        return new CartServiceImpl(
            cartWriteRepository,
            cartReadRepository,
            cartAggregateFactory,
            productReadRepository
        );
    }

}
