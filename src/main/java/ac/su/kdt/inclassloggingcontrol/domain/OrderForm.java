package ac.su.kdt.inclassloggingcontrol.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter  @Setter
@ToString
public class OrderForm {
    // id, productId, cartId, userId, quantity
    private Long id;
    private Long productId;
    private Long cartId;
    private Long userId;
    private Integer quantity;
}
