package edu.curso.java.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.curso.java.spring.service.Exportador;

@Component
public class TipoExportadorDocumento{
	
	@Autowired
	@Qualifier("exportadorXML")
	Exportador exportadorXML;

	@Autowired
	@Qualifier("exportadorCSV")
	Exportador exportadorCSV;

	@Autowired
	@Qualifier("exportadorTAB")
	Exportador exportadorTAB;
	
	protected String tipoDoc;

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	
	public Exportador seleccionarTipoExportador() {
		switch (getTipoDoc()) {
		case "XML":
			return exportadorXML;
		case "CSV":
			return exportadorCSV;
		case "TAB":
			return exportadorTAB;
		default:
			return exportadorXML;
		}
	}
}
