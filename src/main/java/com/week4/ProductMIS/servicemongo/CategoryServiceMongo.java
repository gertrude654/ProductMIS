package com.week4.ProductMIS.servicemongo;

import com.week4.ProductMIS.mongoModels.Category;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("dev")
public interface CategoryServiceMongo {

    Category getCategory(String categoryId);
    List<Category> getAllCategories();
    Category createCategory(Category category);
    void updateCategory(Category category);
    boolean deleteCategory(String categoryId);
}
