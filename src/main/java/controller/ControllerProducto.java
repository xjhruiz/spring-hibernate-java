package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.faces.component.UIData;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import entities.Producto;
import service.ServicioProducto;

@Controller
@Scope("session")
public class ControllerProducto {

    @Resource
    private ServicioProducto servicioProducto;

    @Resource
    private EditarProducto editarProducto;

    private UIData tablaProducto;

    public String editarProducto() {
        Producto producto;
        try {
            producto = (Producto) tablaProducto.getRowData();
        } catch (IllegalArgumentException e) {
            // se añade un nuevo elemento
            producto = servicioProducto.newProducto();
        }
        editarProducto.setProducto(producto);
        return "editarProducto";
    }

    public List<Producto> getProductos() {
        return servicioProducto.getProductos();
    }

    public EditarProducto getEditarProducto() {
        return editarProducto;
    }

    public void setEditarProducto(EditarProducto editarProducto) {
        this.editarProducto = editarProducto;
    }

}
