package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}
	/*
	@Bean
	CommandLineRunner initData(ProductoService productoService, CategoriaService categoriaService) {
		return args -> {
			categoriaService.agregar(
					new Categoria(1L, "muebles"));
			categoriaService.agregar(
					new Categoria(2L, "accesorios"));
			productoService.agregar(
					new Producto(1L, "mesa", true, NORMAL, 100d,categoriaService.obtenerPorId(1L)));
			productoService.agregar(
					new Producto(2L, "silla", false, NORMAL, 50d,categoriaService.obtenerPorId(1L)));
			productoService.agregar(
					new Producto(3L, "estanteria", true, REDUCIDO, 70d,categoriaService.obtenerPorId(1L)));
			productoService.agregar(
					new Producto(4L, "cojin", true, NORMAL, 20d,categoriaService.obtenerPorId(2L)));
			productoService.agregar(
					new Producto(4L, "jarrón", true, NORMAL, 5d,categoriaService.obtenerPorId(2L)));

		};
	}
*/

}