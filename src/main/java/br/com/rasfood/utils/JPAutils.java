package br.com.rasfood.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutils {
    private static final EntityManagerFactory restaurante = Persistence.createEntityManagerFactory("restaurante");
    //

    public  static EntityManager getEntityManagerrestaurante(){
        return restaurante.createEntityManager();

    }
}
