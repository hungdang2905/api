package vn.id.quanghuydevfs.drcomputer.model.comment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.id.quanghuydevfs.drcomputer.model.product.Product;
import vn.id.quanghuydevfs.drcomputer.model.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    private User user;
}
