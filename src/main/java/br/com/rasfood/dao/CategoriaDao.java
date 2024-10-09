package br.com.rasfood.dao;

import br.com.rasfood.entity.Cardapio;
import br.com.rasfood.entity.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {
    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager){
        this.entityManager =entityManager;
    }

    public void cadastrar(Categoria categoria){
        this.entityManager.persist(categoria);
        System.out.println(categoria.getId());
    }

    public Categoria consultar(Integer id){
        return this.entityManager.find(Categoria.class,id);
    }

    public void atualizar(Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void excluir(Categoria categoria){
        this.entityManager.remove(categoria);
    }
}
