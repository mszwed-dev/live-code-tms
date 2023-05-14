package pl.inpost.livecodetms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.inpost.livecodetms.cart.model.CartId;
import pl.inpost.livecodetms.cart.model.CartView;
import pl.inpost.livecodetms.adapter.jpa.CartEntityRepository;
import pl.inpost.livecodetms.cart.service.CartService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CartIntegrationTest {
    @Autowired
    private CartService cartService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CartEntityRepository cartEntityRepository;

    @BeforeEach
    void cleanup() {
        cartEntityRepository.deleteAll();
    }

    @Test
    void whenCreateCartWithTwoProducts_thenExpectedCartIsCreated() throws Exception {
        final var cartId =
            objectMapper.readValue(
                mockMvc.perform(post("/api/cart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            [
                              "67a5ca69-453c-45b1-bd38-a3eeb466a4a3",
                              "7a3ecea4-7184-4c3c-b70e-2b1525ca9537"
                            ]"""))
                    .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(),
                CartId.class
            );

        final var cart = objectMapper.readValue(
            mockMvc.perform(get("/api/cart/{cartId}", cartId.getValue()))
                .andReturn().getResponse().getContentAsString(),
            CartView.class
        );

        Assertions.assertThat(cart).extracting(CartView::getId).extracting(CartId::getValue).isEqualTo(cartId.getValue());
        Assertions.assertThat(cart.getItems()).satisfiesExactlyInAnyOrder(
            item -> Assertions.assertThat(item.getProductId().getValue()).isEqualTo(UUID.fromString(
                "67a5ca69-453c-45b1-bd38-a3eeb466a4a3")),
            item -> Assertions.assertThat(item.getProductId().getValue()).isEqualTo(UUID.fromString(
                "7a3ecea4-7184-4c3c-b70e-2b1525ca9537"))
        );
        Assertions.assertThat(cart.getTotalPrice())
            .isEqualTo(BigDecimal.valueOf(2400).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    @Disabled
    void whenCreateCartWithMoreThanThreeProducts_thenTotalPriceCalculatedBasedOnDiscountPolicy() throws Exception {
        // TODO: implement
    }

}