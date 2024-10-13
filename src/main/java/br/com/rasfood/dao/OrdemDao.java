package br.com.rasfood.dao;

import br.com.rasfood.entity.Categoria;
import br.com.rasfood.entity.Ordem;
import br.com.rasfood.entity.OrdemCardapio;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

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

    public List<Object[]> consultarItensMaisVendidos(){
        String sql = " SELECT SUM(oc.quantidade),c.nome FROM Ordem o " +
                " JOIN o.listaOrdemCardapio oc " +
                " JOIN oc.cardapio c " +
                " group by c.nome " +
                " ORDER BY SUM(oc.quantidade) DESC";
        return this.entityManager.createQuery(sql, Object[].class).getResultList();

    }
}
