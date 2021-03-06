package com.iut.as2021.dao;

import com.iut.as2021.dao.interfaces.IDaoGeneric;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
@Transactional
public abstract class AbstractDao<T0 extends Serializable, T> implements IDaoGeneric<T> {
    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> persistentClass;

    protected  static final Logger logger = Logger.getLogger(AbstractDao.class);

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    protected Class<T> getPersistentClass(){ return persistentClass;}

    protected T getByKey(T0 key) {
        return getSession().get(persistentClass, key);
    }

    @Override
    public void persist(T entity) {
        getSession().persist(entity);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @Override
    public List<T> getList() {
        return getSession().createQuery("from " + getPersistentClass().getSimpleName()).getResultList();
    }

}
