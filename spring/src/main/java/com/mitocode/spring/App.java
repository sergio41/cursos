package com.mitocode.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.beans.Jugador;
import com.mitocode.beans.Persona;

public class App {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/beans.xml");
		//ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class, AppConfig2.class);
		/*AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.register(AppConfig.class);
		appContext.register(AppConfig2.class);
		appContext.refresh();*/

		Persona per = (Persona)appContext.getBean("persona");
		Persona per2 = (Persona)appContext.getBean("persona");
		
		System.out.println(per.getId() +" " + per.getNombre() + " " + per.getApodo() + " " + per.getPais().getNombre() + " " + per.getCiudad().getNombre());
		System.out.println(per2.getId() +" " + per2.getNombre() + " " + per2.getApodo() + " " + per2.getPais().getNombre() + " " + per2.getCiudad().getNombre());

		System.out.println(per);
		System.out.println(per2);

		((ConfigurableApplicationContext)appContext).close();

		appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/beans2.xml");
		
		/*IEquipo bar = (IEquipo)appContext.getBean("juventus");
		System.out.println(bar.mostrar());*/

		Jugador jug = (Jugador)appContext.getBean("messi");
		
		System.out.println(jug.getNombre() +" - " + jug.getEquipo().mostrar());

		((ConfigurableApplicationContext)appContext).close();
	}

}
