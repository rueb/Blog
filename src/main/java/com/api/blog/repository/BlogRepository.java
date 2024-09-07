package com.api.blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.blog.model.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long>{

}
