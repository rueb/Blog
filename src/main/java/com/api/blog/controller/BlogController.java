package com.api.blog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.blog.exception.RequestException;
import com.api.blog.model.Autor;
import com.api.blog.model.Blog;
import com.api.blog.model.ResultModel;
import com.api.blog.service.BlogService;

@RestController
@RequestMapping("api/v1/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping
	public List<Blog>listarTodo()
	{
		return blogService.getAllBlog();
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Blog blog) 
	{
		try {
			this.blogService.crearBlog(blog);
			ResultModel res = new ResultModel();
            res.setCod( 200);
            res.setStat("successful");
            res.setMessage("Blog adicionado exitosamente.");
            return new ResponseEntity(res,  HttpStatus.CREATED);
			
		} catch (Exception e) {
			throw new RequestException("P-402", "Error al crear el blog , verifique el blog." );
		}
	}
	
	  @GetMapping(path = "/{id}")
	  public Optional<Blog> getCityById(@PathVariable("id") Long id)
	  {
	        return this.blogService.getById(id);
	   }
	
	@PostMapping("editar/{id}")
	public ResponseEntity<?> editar(@RequestBody Blog blog,@PathVariable Long id) 
	{
		blog.setId(id);
		try {
			blog.setId(id);
			this.blogService.updateBlog(blog);
			ResultModel res = new ResultModel();
            res.setCod( 200);
            res.setStat("successful");
            res.setMessage("blog modificado exitosamente.");
            return new ResponseEntity(res,  HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RequestException("P-402", "Error al modificara , verifique si el Blog  existe." );
		}
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id)
	{
		 try 
		 {
	            this.blogService.deleteBlog(id);
	            ResultModel res = new ResultModel();
	            res.setCod( 200);
	            res.setStat("successful");
	            res.setMessage("Blog se dio de baja exitosamente.");
	            return new ResponseEntity(res,  HttpStatus.UPGRADE_REQUIRED);
		 }catch (Exception e) 
		 {
			 throw new RequestException("P-402", "EL Blog NO EXISTE, NO SE PUEDE ELIMINAR." + e.getMessage());
		 }
	}

}
