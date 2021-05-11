package com.roganov.service;

import com.roganov.entity.Product;
import com.roganov.init.EntityManagerInit;

import javax.persistence.*;
import java.util.List;

public class ProductDao {

   EntityManager em  = new EntityManagerInit().initialize();

    public Product findById(Long id){
        Product currentProduct = em.find(Product.class,id);
        if(currentProduct == null){
            throw new EntityNotFoundException("Can't find product for id " + id);
        }

        return currentProduct;
    }

    public List findAll(){
        try{
            Query query = em.createQuery("select * from 'hibernate_educational.Person'");
            return query.getResultList();
        }catch (Exception e){
            throw new NoResultException("There are no products in the database");
        }
    }

    public boolean deleteById(int id){
        try {
            em.getTransaction().begin();
            em.remove(id);
            em.getTransaction().commit();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean saveOrUpdate(Long id, String title, Integer price ){
        Query query = em.createQuery("INSERT INTO 'hibernate_educational.Person'(id,title,price) values(:id,:title,:price)");
        query.setParameter("id", id);
        query.setParameter("title",title);
        query.setParameter("price",price);
        try{
            query.getSingleResult();
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
