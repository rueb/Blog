package com.api.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.blog.model.Autor;
import com.api.blog.model.Blog;
import com.api.blog.repository.BlogRepository;

@Service
public class BlogService {

	@Autowired
	private   BlogRepository blogRepository;
	
	public List<Blog>getAllBlog(){
		return (List<Blog>) blogRepository.findAll();
	}
	
	
	public  Blog crearBlog(Blog blog) {
		return blogRepository.save(blog);
	}
	
	public Blog updateBlog(Blog blog) {
		return blogRepository.save(blog);
	}
	
	public void deleteBlog(Long id) {
		blogRepository.deleteById(id);
	}
	public Optional<Blog> getById(Long id)
	{
	   return blogRepository.findById(id);
	}
}
