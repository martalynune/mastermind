package com.example.app;

import com.example.app.entity.Categoria;
import com.example.app.entity.Producto;
import com.example.app.services.CategoriaService;
import com.example.app.services.ProductoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.app.entity.TipoIva.NORMAL;
import static com.example.app.entity.TipoIva.REDUCIDO;

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}
	@Bean
	CommandLineRunner initData(ProductoService productoService, CategoriaService categoriaService) {
		return args -> {

			productoService.agregar(
					new Producto(1L, "mesa", true, NORMAL, 100d,1L));
			productoService.agregar(
					new Producto(2L, "silla", false, NORMAL, 50d,1L));
			productoService.agregar(
					new Producto(3L, "estanteria", true, REDUCIDO, 70d,1L));
			categoriaService.agregar(
					new Categoria(1L, "muebles"));
			categoriaService.agregar(
					new Categoria(2L, "alfombras"));
			categoriaService.agregar(
					new Categoria(3L, "accesorios"));
		};
	}
}
