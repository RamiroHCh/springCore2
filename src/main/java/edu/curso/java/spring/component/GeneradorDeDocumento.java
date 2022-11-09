package edu.curso.java.spring.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.curso.java.spring.domain.Persona;
//import edu.curso.java.spring.service.Exportador;

@Component
@Scope("prototype")
public class GeneradorDeDocumento extends TipoExportadorDocumento{

//	private Exportador exportador;

	GeneradorDeDocumento(String TipoDoc){
		super.setTipoDoc(TipoDoc);		
	}
	
	public void exportarDatos(Persona persona) {
		//System.out.println(exportador.exportar(persona));
		System.out.println(seleccionarTipoExportador().exportar(persona));
		System.out.println("");
	}
//
//	public Exportador getExportador() {
//		return this.exportador;
//	}

//	public void setExportador(Exportador exportador) {
//		this.exportador = exportador;
//	}
}
