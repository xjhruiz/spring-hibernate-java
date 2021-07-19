package controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import entities.Producto;
import service.ServicioProducto;

@Controller
@Scope("session")
public class EditarProducto {

    @Resource
    private ServicioProducto servicioProducto;
    private Producto producto;

    public String guardar() {
        servicioProducto.guardar(producto);
        // redirige a home
        return "home";
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
