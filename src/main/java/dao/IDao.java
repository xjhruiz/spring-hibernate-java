package dao;

import java.io.Serializable;
import java.util.List;

public interface IDao {
    public void guardar(Object entidad);

    public void guardar(Object[] entidades);

    public <T> List<T> buscarPor(Class<T> claseEntidad);

    public <T> T cargar(Class<T> claseEntidad, Serializable id);

    public <T> List<T> buscarPor(String jqpl);
}
