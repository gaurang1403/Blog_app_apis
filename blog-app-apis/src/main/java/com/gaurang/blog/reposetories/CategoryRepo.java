package com.gaurang.blog.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaurang.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
