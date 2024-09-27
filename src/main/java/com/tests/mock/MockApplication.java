package com.tests.mock;

import com.tests.mock.entities.Categoria;
import com.tests.mock.entities.Tarea;
import com.tests.mock.repositories.CategoriaRepository;
import com.tests.mock.repositories.TareaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.Set;

@SpringBootApplication
public class MockApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockApplication.class, args);


	}

	/*@Bean
	CommandLineRunner initData(TareaRepository tareaRepository, CategoriaRepository categoriaRepository){
		return args -> {
				Tarea tarea1 = Tarea.builder()
						.nombre("ejemplo")
						.descripcion("nada")
						.isCompleted(false)
						.build();
			Categoria categoria1 = Categoria.builder().nombre("Ejercicio").build();
			tarea1.setCategoria(categoriaRepository.save(categoria1));

			tareaRepository.save(tarea1);

			tareaRepository.findAll().forEach( tarea -> System.out.println(tarea.getCategoria().getNombre()));
		};
	}*/

}
