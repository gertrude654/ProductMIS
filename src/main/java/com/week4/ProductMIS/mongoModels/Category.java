package com.week4.ProductMIS.mongoModels;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Profile("dev")
@Document(collection = "categories")
public class Category {
    @Id
    private String id;
    private String name;
    @DBRef
    private List<Product> products;
}
