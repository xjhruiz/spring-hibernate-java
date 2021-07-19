package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.Dao;
import entities.Producto;

//anotacion de spring similar a @Repository 
//clase relacionado con la capa de servicio y que debe ser un singleton

@Service
public class ServicioProducto {

    // Antipadron poltergeist
    // Estandar sirve tanto para spring como para ejb3.0
    // se indica que se debe de inyectar o inicializar una referencia a la instancia
    // del Dao
    @Resource
    private Dao dao;

    public Producto newProducto() {
        return new Producto();
    }

    public void guardar(Producto producto) {
        dao.guardar(producto);
    }

    public List<Producto> getProductos() {
        final List<Producto> listaProductos = dao.buscarPor(Producto.class);
        return listaProductos;
    }

}
