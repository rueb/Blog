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
import com.api.blog.model.ResultModel;
import com.api.blog.service.AutorService;

@RestController
@RequestMapping("api/v1/autor")
public class AutorController {
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping
	public List<Autor>listarTodo(){
		return autorService.getAllAutor();
	}
	
	@PostMapping
	public Autor crear(@RequestBody Autor autor)
	{
		try {
			ResultModel res = new ResultModel();
            res.setCod( 200);
            res.setStat("successful");
            res.setMessage("Autor adicionado exitosamente.");
            return autorService.crearAutor(autor);
		} catch (Exception e) {
			throw new RequestException("P-402", "Error al registrar al autor , verifique el autor." );
		}
	}
	
	@PostMapping("editar/{id}")
	public  Autor editar(@RequestBody Autor autor,@PathVariable Long id) 
	{
		try {
			autor.setId(id);			
			ResultModel res = new ResultModel();
            res.setCod( 200);
            res.setStat("successful");
            res.setMessage("Autor modificado exitosamente.");
            return autorService.updateAutor(autor);
			
		} catch (Exception e) {
			throw new RequestException("P-402", "Error al modificar , verifique si el autor  existe." );
		}
		
		
	}
	

	  @GetMapping(path = "/{id}")
	  public Optional<Autor> getCityById(@PathVariable("id") Long id)
	  {
	        return this.autorService.getById(id);
	   }
	
	@DeleteMapping("eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) 
	{
		try {
			 this.autorService.deleteAutor(id);
	            ResultModel res = new ResultModel();
	            res.setCod( 200);
	            res.setStat("successful");
	            res.setMessage("Autor se dio de baja exitosamente.");
	          //  return new ResponseEntity(res,  HttpStatus.UPGRADE_REQUIRED);
		} catch (Exception e) {
			throw new RequestException("P-402", "EL Autor NO EXISTE, NO SE PUEDE ELIMINAR." + e.getMessage());
		}
	}	

}
