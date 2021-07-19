package entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

//Estandar JPA implementacion Hibernate o Mybatis
@Entity
@Table(name = "products") // mapear la tabla S: y renombrarla
public class Producto implements Serializable {

    @Id
    @GeneratedValue
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private float precio;

    // es necesario un constructor sin parametro para que trabaje el framework
    // internamente
    public Producto() {
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    // El que consume más
    public String toStringMalo() {
        return "Producto [ idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", descripcion="
                + descripcion + "]";
    }

    @Override // el bueno
    public String toString() {
        return new StringBuilder().append("Producto:  { idProducto: ").append(this.idProducto).append(", Nombre: ")
                .append(this.nombre).append(", Precio: ").append(this.precio).append(", Descripcion: ")
                .append(this.descripcion + " } ").toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((idProducto == null) ? 0 : idProducto.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + Float.floatToIntBits(precio);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Producto other = (Producto) obj;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (idProducto == null) {
            if (other.idProducto != null)
                return false;
        } else if (!idProducto.equals(other.idProducto))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
            return false;
        return true;
    }

}
