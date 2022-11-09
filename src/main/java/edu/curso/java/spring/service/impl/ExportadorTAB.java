package edu.curso.java.spring.service.impl;

import org.springframework.stereotype.Service;

import edu.curso.java.spring.domain.Persona;
import edu.curso.java.spring.service.Exportador;

@Service("exportadorTAB")
public class ExportadorTAB implements Exportador {

	@Override
	public String exportar(Persona persona) {
		return persona.getNombre() + "\t" + persona.getEdad() + "\t" + persona.getDireccion();
	}

}
