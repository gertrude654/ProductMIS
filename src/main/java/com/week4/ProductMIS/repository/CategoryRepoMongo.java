package com.week4.ProductMIS.repository;

import com.week4.ProductMIS.mongoModels.Category;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Profile("dev")
@Repository
public interface CategoryRepoMongo extends MongoRepository<Category, String> {
}
