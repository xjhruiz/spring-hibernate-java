package dao;

import java.io.Serializable;
import java.util.List;

// Sin Spring solo Hibernate
public class Dao implements IDao {

    @Override
    public void guardar(Object entidad) {
        // TODO Auto-generated method stub

    }

    @Override
    public void guardar(Object[] entidades) {
        // TODO Auto-generated method stub

    }

    @Override
    public <T> List<T> buscarPor(Class<T> claseEntidad) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T cargar(Class<T> claseEntidad, Serializable id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> List<T> buscarPor(String jqpl) {
        // TODO Auto-generated method stub
        return null;
    }

}
