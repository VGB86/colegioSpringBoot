package com.virginia.springboot.repositorioback;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virginia.springboot.modeloback.Estudiante;

@Repository
public interface RepositorioEstudiante extends JpaRepository<Estudiante,Long> {
	List<Estudiante> findByNombre(String nombre);
}
