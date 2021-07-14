package com.virginia.springboot.controladorback;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.virginia.springboot.modeloback.Estudiante;
import com.virginia.springboot.repositorioback.RepositorioEstudiante;


@Controller
@RequestMapping("/restColegio/")
public class ControladorEstudianteBack {
	
	@Autowired
	private RepositorioEstudiante repositorioEstudiante;
	
	
	
	//************ LISTAR ESTUDIANTES ************
	
	@GetMapping("estudiantes")
	public String estudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", this.repositorioEstudiante.findAll());
		return "index";
	}
	
	
	
	//************ INSERTAR ****************
	
	@GetMapping("addEstudiante")
	public String mostrarFormularioEstudiante(Estudiante estudiante) {
		return "add-estudiante";
	}
	@PostMapping("nuevo")
	public String addEstudiante(@Valid Estudiante estudiante, BindingResult resultado, Model modelo) { 
		if(resultado.hasErrors()) {
			return "add-estudiante";
		}
		
		this.repositorioEstudiante.save(estudiante);
		return "redirect:lista";
	}
	
	
	//*********** MODIFICAR ************
	@GetMapping("editar/{id}")
	public String mostrarFormularioActualizado(@PathVariable ("id") long id, Model modelo) {
		Estudiante estudiante = this.repositorioEstudiante.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id invalido : " + id));
		
		modelo.addAttribute("estudiante", estudiante);
		return "update-estudiante";
	}
	
	@PostMapping("update/{id}")
	public String updateEstudiante(@PathVariable("id") long id, @Valid Estudiante estudiante, BindingResult resultado, Model modelo) {
		if(resultado.hasErrors()) {
			estudiante.setId(id);
			return "update-estudiante";
		}
		//aquí actualizamos al estudiante
		repositorioEstudiante.save(estudiante);
		
		//aqui devolvemos todos los estudiantes modificados
		modelo.addAttribute("estudiantes", this.repositorioEstudiante.findAll());
		return "index";
	}
	
	
	//************** BORRAR ************
	@GetMapping("borrar/{id}") // hacemos un get para que nos devuelva el index vacio
	public String borrarEstudiante(@PathVariable ("id") long id, Model modelo){
		
		Estudiante estudiante = this.repositorioEstudiante.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id invalido : " + id));
		
		this.repositorioEstudiante.delete(estudiante); //aquí hacemos el delete
		modelo.addAttribute("estudiantes", this.repositorioEstudiante.findAll());
		return "index";
		
	}
	
}
	
		


