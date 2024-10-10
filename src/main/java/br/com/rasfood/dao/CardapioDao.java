package br.com.rasfood.dao;

import br.com.rasfood.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CardapioDao {
    private EntityManager entityManager;
    public CardapioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Cardapio cardapio){
        this.entityManager.persist(cardapio);
        System.out.println(cardapio.getId());
    }

    public Cardapio consultar(Integer id){
       return this.entityManager.find(Cardapio.class,id);
    }

    public void atualizar(Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void excluir(Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }

    public List<Cardapio> findAll(){
        try {
            String sql = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(sql, Cardapio.class).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }

    public List<Cardapio> consultarForValor(BigDecimal valor){
        try{
            String sql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
            return this.entityManager.createQuery(sql,Cardapio.class)
                    .setParameter("valor",valor)
                    .getResultList();

        }catch (Exception e){
            return Collections.emptyList();
        }


    }
    public Cardapio consultarForNome(String nome){
        try {
            String sql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(sql, Cardapio.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
}
