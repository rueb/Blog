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
import com.api.blog.model.Comentario;
import com.api.blog.model.ResultModel;
import com.api.blog.service.ComentarioService;

@RestController
@RequestMapping("api/v1/comentario")
public class ComentarioController {
	
	@Autowired
	private  ComentarioService comentarioService;
	
	@GetMapping
	public List<Comentario>listarTodo(){
		return comentarioService.getAllComentario();
	}
	
	 @GetMapping(path = "/{id}")
	 public Optional<Comentario> getCityById(@PathVariable("id") Long id)
	 {
	        return this.comentarioService.getById(id);
	   }
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Comentario comentario) 
	{
		try {		
			this.comentarioService.crearComentario(comentario);
			ResultModel res = new ResultModel();
            res.setCod( 200);
            res.setStat("successful");
            res.setMessage("Comentario adicionado exitosamente.");
            return new ResponseEntity(res,  HttpStatus.CREATED);
			
		} catch (Exception e) {
			throw new RequestException("P-402", "Error al registrar el comentario , verifique el comentario." );
		}
	}
	
	@PostMapping("editar/{id}")
	public ResponseEntity<?> editar(@RequestBody Comentario comentario,@PathVariable Long id)
	{
		try {
			comentario.setId(id);
			this.comentarioService.updateComentario(comentario);
			ResultModel res = new ResultModel();
            res.setCod( 200);
            res.setStat("successful");
            res.setMessage("Comentario modificada exitosamente.");
            return new ResponseEntity(res,  HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RequestException("P-402", "Error al modificar , verifique si el Comentario  existe." );
		}
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		 try {
	            this.comentarioService.deleteComentario(id);
	            ResultModel res = new ResultModel();
	            res.setCod( 200);
	            res.setStat("successful");
	            res.setMessage("Visitante se dio de baja exitosamente.");
	            return new ResponseEntity(res,  HttpStatus.UPGRADE_REQUIRED);
	} catch (Exception e) {
		throw new RequestException("P-402", "EL Comentario NO EXISTE, NO SE PUEDE ELIMINAR." + e.getMessage());
	}
	}
}
