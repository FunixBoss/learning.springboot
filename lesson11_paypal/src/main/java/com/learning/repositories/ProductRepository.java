package com.learning.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

}
