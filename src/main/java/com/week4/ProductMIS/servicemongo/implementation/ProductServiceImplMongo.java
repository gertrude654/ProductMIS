package com.week4.ProductMIS.servicemongo.implementation;

import com.week4.ProductMIS.mongoModels.Product;
import com.week4.ProductMIS.repository.ProductRepoMongo;
import com.week4.ProductMIS.servicemongo.ProductServiceMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Profile("dev")
@Service
public class ProductServiceImplMongo implements ProductServiceMongo {

    private ProductRepoMongo repo;

    @Autowired
    public ProductServiceImplMongo(ProductRepoMongo repo) {
        this.repo = repo;
    }

    @Override
    public Product createProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public Product getProduct(String productId) {
        return repo.findById(productId).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public void updateProduct(Product product) {
         repo.save(product);
    }

    @Override
    public boolean deleteProduct(String ProductId) {
        Optional<Product> deletedProduct = repo.findById(ProductId);
        if (deletedProduct.isPresent()) {
            Product product = deletedProduct.get();
            repo.delete(product);
            return true;
        }
        return false;
    }
}
