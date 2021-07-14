package com.virginia.springboot.controlador;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.virginia.springboot.modelo.Estudiante;
import com.virginia.springboot.repositorio.RepositorioEstudiante;

@Controller
@RequestMapping("/restColegio/")
public class ControladorEstudiante {

	@Autowired
	private RepositorioEstudiante repositorioEstudiante;

	// ********** WELCOME PAGE *************
	@GetMapping("")
	public String index(Model model) {
		return "index";
	}

	//************* ADD ********************
	@GetMapping("addEstudiante")
	public String mostrarFormularioEstudiante(Estudiante estudiante) {
		return "add-estudiante";
	}

	@PostMapping("nuevo")
	public String addEstudiante(@Valid Estudiante estudiante, BindingResult resultado, Model modelo, @ModelAttribute("estudiante") Estudiante estudianteAtribute) {
		if (resultado.hasErrors()) {
			return "add-estudiante";
		}

		this.repositorioEstudiante.save(estudiante);
		return "redirect:perfil" + "/"+ String.valueOf(estudianteAtribute.getId());
	}
	
	//************** READ *****************
	
	@GetMapping(value = "perfil/{id}")
	public String unestudiante(@PathVariable("id") long id,  @ModelAttribute("estudiante") Estudiante estudianteAtribute, Model modelo) {
		modelo.addAttribute("estudiante", this.repositorioEstudiante.findById(id));
		return "perfil";
	}

	// *************** UPDATE ******************
	@GetMapping("perfil/{id}/editar")
	public String mostrarFormularioActualizado(@PathVariable long id, @ModelAttribute("estudiante") Estudiante estudianteAtribute, Model modelo) {
		Estudiante estudiante = this.repositorioEstudiante.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id invalido : " + id));

		modelo.addAttribute("estudiante", estudiante);
		return "update-estudiante";
	}

	
	@PostMapping("perfil/{id}/update")
	public String updateEstudiante(@PathVariable long id, @ModelAttribute("estudiante") Estudiante estudianteAtribute,  
			@Valid Estudiante estudiante, BindingResult resultado, Model modelo) {
		if (resultado.hasErrors()) {
			estudiante.setId(id);
			return "update-estudiante";//+ "/"+ String.valueOf(estudianteAtribute.getId());
		}
		
		
		//estudiante.setId(id);
        //repositorioEstudiante.save(estudiante);
        //return "redirect:" + String.valueOf(estudiante.getId());
		
		// aquí actualizamos al estudiante
		repositorioEstudiante.save(estudiante);

		// aqui devolvemos todos los estudiantes modificados
		modelo.addAttribute("estudiante", this.repositorioEstudiante.findById(id));
		return "perfil"+ "/"+ String.valueOf(estudianteAtribute.getId());
	}
	

}