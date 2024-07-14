package com.week4.ProductMIS.servicemongo;

import com.week4.ProductMIS.mongoModels.Product;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("dev")
public interface ProductServiceMongo {

    Product getProduct(String ProductId);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    void updateProduct(Product product);
    boolean deleteProduct(String ProductId);
}
