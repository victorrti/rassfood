package br.com.rasfood.dao;

import br.com.rasfood.entity.Categoria;
import br.com.rasfood.entity.Ordem;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemDao {
    private EntityManager entityManager;

    public OrdemDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public void cadastrar(Ordem ordem){
        this.entityManager.persist(ordem);
        System.out.println(ordem.getId());
    }

    public Ordem consultar(Integer id){
        return this.entityManager.find(Ordem.class,id);
    }

    public void atualizar(Ordem ordem){
        this.entityManager.merge(ordem);
    }

    public void excluir(Ordem ordem){
        this.entityManager.remove(ordem);
    }

    public List<Ordem> findAll(){

        String sql = "SELECT o FROM Ordem o";
        return this.entityManager.createQuery(sql,Ordem.class).getResultList();
    }
}
