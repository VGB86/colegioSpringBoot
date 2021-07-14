package com.virginia.springboot.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virginia.springboot.modelo.Estudiante;

@Repository
public interface RepositorioEstudiante extends JpaRepository<Estudiante,Long> {
	public List<Estudiante> findByNombre(String nombre);
	
	public Estudiante findById(int id);

    public Estudiante save(Estudiante estudiante);

    public void deleteById(int id);
}
