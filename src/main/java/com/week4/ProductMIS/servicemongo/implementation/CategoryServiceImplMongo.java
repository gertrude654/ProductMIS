package com.week4.ProductMIS.servicemongo.implementation;

import com.week4.ProductMIS.mongoModels.Category;
import com.week4.ProductMIS.repository.CategoryRepoMongo;
import com.week4.ProductMIS.servicemongo.CategoryServiceMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Profile("dev")
@Service
public class CategoryServiceImplMongo implements CategoryServiceMongo {

    private CategoryRepoMongo repo;

    @Autowired
    public CategoryServiceImplMongo(CategoryRepoMongo repo) {
        this.repo = repo;
    }

    @Override
    public Category getCategory(String categoryId) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return repo.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return repo.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        repo.save(category);
    }

    @Override
    public boolean deleteCategory(String categoryId) {
        Optional<Category> deletedCategory = repo.findById(categoryId);
        if (deletedCategory.isPresent()) {
            Category category = deletedCategory.get();
            repo.delete(category);
            return true;
        }
        return false;
    }
}
