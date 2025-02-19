package vn.id.quanghuydevfs.drcomputer.model.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private long price;
    private int storage;
    private double sale;
    private String img1;
    private String img2;

}
