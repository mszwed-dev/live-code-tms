package pl.inpost.livecodetms.adapter.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.inpost.livecodetms.cart.model.CartId;
import pl.inpost.livecodetms.cart.model.CartView;
import pl.inpost.livecodetms.cart.model.ProductId;
import pl.inpost.livecodetms.cart.service.CartService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cart")
class CartRestController {

    private final CartService cartService;

    CartRestController(@NonNull final CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CartId> createCart(@NonNull @RequestBody final List<UUID> productsIds) {
        return new ResponseEntity<>(
            cartService.createCart(productsIds.stream().map(ProductId::new).toList()),
            HttpStatusCode.valueOf(HttpStatus.CREATED.value())
        );
    }

    @PutMapping(path = "/{cartId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void addProductToCart(
        @NonNull @PathVariable final UUID cartId,
        @NonNull @RequestBody final List<UUID> productsIds
    ) {
        cartService.addProductToCart(
            new CartId(cartId),
            productsIds.stream().map(ProductId::new).toList()
        );
    }

    @GetMapping(path = "/{cartId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CartView> getCart(@NonNull @PathVariable final UUID cartId) {
        return ResponseEntity.ok(cartService.getCart(new CartId(cartId)));
    }

}
