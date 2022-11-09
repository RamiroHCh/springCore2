package edu.curso.java.spring.service.impl;

import org.springframework.stereotype.Service;

import edu.curso.java.spring.domain.Persona;
import edu.curso.java.spring.service.Exportador;

@Service("exportadorCSV")
public class ExportadorCSV implements Exportador {

	@Override
	public String exportar(Persona persona) {
		String datosCSV = persona.getNombre() + "," + persona.getEdad() + "," + persona.getDireccion();
		return datosCSV;
	}

}
