package ac.su.kdt.inclassloggingcontrol.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartForm {
    // id, productId, userId, quantity
    private Long id;
    private Long productId;
    private Long userId;
    private Integer quantity;

    @Override
    public String toString() {
        return "CartForm{" +
                "id=" + id +
                ", productId=" + productId +
                ", userId=" + userId +
                ", quantity=" + quantity +
                '}';
    }
}
