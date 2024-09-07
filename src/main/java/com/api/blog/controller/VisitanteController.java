package com.api.blog.controller;

import java.util.List;

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
import com.api.blog.model.Visitante;
import com.api.blog.service.VisitanteService;

@RestController
@RequestMapping("api/v1/visitante")
public class VisitanteController {
	
	@Autowired
	private VisitanteService visitanteService;
	
	@GetMapping
	public List<Visitante>listarTodo(){
		return visitanteService.getAllVisitante();
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Visitante visitante) {
		try {
			this.visitanteService.crearVisitante(visitante);
			ResultModel res = new ResultModel();
            res.setCod( 200);
            res.setStat("successful");
            res.setMessage("Visitante adicionada exitosamente.");
            return new ResponseEntity(res,  HttpStatus.CREATED);
			
		} catch (Exception e) {
			throw new RequestException("P-402", "Error al registrar al visitante , verifique el visitante." );
		}
	}
	
	@PostMapping("editar/{id}")
	public ResponseEntity<?>  editar(@RequestBody Visitante visitante,@PathVariable Long id) {
		try {
			visitante.setId(id);
			this.visitanteService.updateVisitante(visitante);
			ResultModel res = new ResultModel();
            res.setCod( 200);
            res.setStat("successful");
            res.setMessage("Visitante modificada exitosamente.");
            return new ResponseEntity(res,  HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RequestException("P-402", "Error al modificara , verifique si el Visitante  existe." );
		}
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {		
			 try {
		            this.visitanteService.deleteVisitante(id);
		            ResultModel res = new ResultModel();
		            res.setCod( 200);
		            res.setStat("successful");
		            res.setMessage("Visitante se dio de baja exitosamente.");
		            return new ResponseEntity(res,  HttpStatus.UPGRADE_REQUIRED);
		} catch (Exception e) {
			throw new RequestException("P-402", "EL Visitante NO EXISTE, NO SE PUEDE ELIMINAR." + e.getMessage());
		}
	
	}

}
