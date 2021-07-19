package dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate.support.HibernateDaoSupport;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sf.hibernate.SessionFactory;

// Anotacion de Spring HibernateDaoSupport hace una sola instancia de la clase con relacion con la capa de persistencia y usara un Singleton y todos los hilos de la app los compartiran
@Repository
public class DaoSpring extends HibernateDaoSupport implements IDao {

    // indica a spring que debe de inyectar una referencia de sessionFactory cuando
    // se cree la instancia de HibernateDaoSupport
    @Autowired
    public SpringHibernateDao(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    // Spring comprueba si existe una transacción abierta si existe se une a ella
    // sino crea una nueva transaccion
    // de esta forma todas las operaciones de base de datos se queda en una
    // transaccion y si ocurre un error, se lanza una excepcion runtime
    // haciendose un rollback de la transaccion
    @Transactional
    public void guardar(Object entidad) {
        getHibernateTemplate().saveOrUpdate(entidad);
    }

    @Transactional
    public void guardar(Object[] entidades) {
        for (Object i : entidades) {
            guardar(i);
        }
    }

    @Transactional(readOnly = true)
    public <T> List<T> buscarPor(Class<T> claseEntidad) {
        final List<T> entidadades = getHibernateTemplate().loadAll(claseEntidad);
        return entidadades;
    }

    @Transactional(readOnly = true)
    public <T> T cargar(Class<T> claseEntidad, Serializable id) {
        final T entidad = (T) getHibernateTemplate().load(claseEntidad, id);
        return entidad;
    }

    @Transactional(readOnly = true)
    public <T> List<T> buscarPor(String jqpl) {
        final List<T> entidades = getHibernateTemplate().find(jqpl);
        return entidades;
    }

}
