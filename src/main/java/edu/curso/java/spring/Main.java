package edu.curso.java.spring;

import java.util.ResourceBundle;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.component.GeneradorDeDocumento;
import edu.curso.java.spring.configuration.SpringConfigurador;
import edu.curso.java.spring.domain.Persona;
import edu.curso.java.spring.service.Exportador;

public class Main {

	public static void main(String[] args) {

		Persona persona = new Persona("Victoria", 37, "Lugones 4402");
		
		ResourceBundle resource = ResourceBundle.getBundle("application");
		
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(SpringConfigurador.class);
		applicationContext.refresh();
		
//		GeneradorDeDocumento generadorDeDocumento = (GeneradorDeDocumento) applicationContext
//				.getBean("generadorDeDocumento");

		GeneradorDeDocumento generadorDeDocumento = null;
				
		generadorDeDocumento = (GeneradorDeDocumento) applicationContext
				.getBean("generadorDeDocumento", resource.getString("exportador.XML"));
		generadorDeDocumento.exportarDatos(persona);
		
		generadorDeDocumento = (GeneradorDeDocumento) applicationContext
				.getBean("generadorDeDocumento", resource.getString("exportador.CSV"));
		generadorDeDocumento.exportarDatos(persona);
		
		generadorDeDocumento = (GeneradorDeDocumento) applicationContext
				.getBean("generadorDeDocumento", resource.getString("exportador.TAB"));
		generadorDeDocumento.exportarDatos(persona);
		
		Exportador e =  (Exportador) applicationContext.getBean(resource.getString("exportador"));
		System.out.println(e.exportar(persona));
	}

}
