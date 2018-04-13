/*
 * To change this license header, choose License Headers in Project Properties.     
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa2.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa2.model.User;
/**
 *
 * @author Rachmad
 */
public class DaoUser {
    public void save(User user){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistance");
        
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        
        entitymanager.persist(user);
        entitymanager.getTransaction().commit();
        
        entitymanager.close();
        emfactory.close();
    }
    
    public void update(long id, User user){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistance");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        User editUser = entitymanager.find(User.class, id);
        
        //edit semua field kecuali id
        editUser.setName((user.getName()));
        entitymanager.getTransaction().commit();
        
        entitymanager.close();
        emfactory.close();
    }
    
    public void delete(long id){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistance");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        
        User user = entitymanager.find(User.class, id);
        entitymanager.remove(user);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
    }
    
    public User findById(long id){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistance");
        EntityManager entitymanager = emfactory.createEntityManager();
        User user = entitymanager.find(User.class,id);
        
        return user;
    }
    
    public List<User> findAll(){
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistance");
        EntityManager entitymanager = emfactory.createEntityManager();
        
        CriteriaBuilder cb = entitymanager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        
        TypedQuery<User> allQuery = entitymanager.createQuery(all);
        return allQuery.getResultList();
    }
}
