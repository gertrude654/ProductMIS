package com.week4.ProductMIS.service.implementation;

import com.week4.ProductMIS.dto.ProductDTO;
import com.week4.ProductMIS.models.Category;
import com.week4.ProductMIS.models.Product;
import com.week4.ProductMIS.repository.CategoryRepo;
import com.week4.ProductMIS.repository.ProductRepo;
import com.week4.ProductMIS.service.ProductService;
import com.week4.ProductMIS.tree.BinaryTree;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo repo;
    private final CategoryRepo categoryRepo;
    private final BinaryTree<Product> binaryTree = new BinaryTree<>();

    @Autowired
    public ProductServiceImpl(@Qualifier("productRepo") ProductRepo repo, CategoryRepo categoryRepo) {
        this.repo = repo;
        this.categoryRepo = categoryRepo;
    }

    @PostConstruct
    public void init() {
        // Load products into binary tree in a background thread to avoid blocking startup
        new Thread(() -> {
            List<Product> products = repo.findAll();
            for (Product product : products) {
                binaryTree.add(product);
            }
        }).start();
    }

    @Override
    @Cacheable(value = "products", key = "#productId")
    public Product getProduct(int productId) {
        return repo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product id not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    @Cacheable(value = "products", key = "'all'")
    public Page<Product> getAllProductss(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    @Transactional
    @CacheEvict(value = "products", allEntries = true)
    public ProductDTO createProduct(ProductDTO productDTO) {
        Category category = categoryRepo.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        Product savedProduct = repo.save(product);

        // Update binary tree in a background thread
        new Thread(() -> {
            binaryTree.add(savedProduct);
        }).start();

        return convertToDTO(savedProduct);
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategoryId(product.getCategory().getId());
        return productDTO;
    }

    @Override
    @Transactional
    @CacheEvict(value = "products", key = "#product.id")
    public void updateProduct(Product product) {
        repo.save(product);
        // Update binary tree in a background thread
        new Thread(() -> {
            binaryTree.delete(product);
            binaryTree.add(product);
        }).start();
    }

    @Override
    @Transactional
    @CacheEvict(value = "products", key = "#productId")
    public boolean deleteProduct(int productId) {
        Optional<Product> deletedProduct = repo.findById(productId);
        if (deletedProduct.isPresent()) {
            Product product = deletedProduct.get();
            // Update binary tree in a background thread
            new Thread(() -> {
                binaryTree.delete(product);
            }).start();
            repo.delete(product);
            return true;
        }
        return false;
    }

    @Override
    public Page<Product> findProductsByCategory(int categoryId, Pageable pageable) {
        return repo.findByCategory(categoryId, pageable);
    }

    @Override
    public Page<Product> findAllProductsSortedByPriceAsc(Pageable pageable) {
        return repo.findAllOrderByPriceAsc(pageable);
    }

    @Override
    public Page<Product> findAllProductsSortedByPriceDesc(Pageable pageable) {
        return repo.findAllOrderByPriceDesc(pageable);
    }
}
