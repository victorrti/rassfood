package br.com.rasfood.dao;

import br.com.rasfood.entity.Categoria;
import br.com.rasfood.entity.Ordem;
import br.com.rasfood.entity.OrdemCardapio;
import br.com.rasfood.vo.ItensPrincipaisVO;

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

    public List<ItensPrincipaisVO> consultarItensMaisVendidos(){
        String sql = " SELECT New br.com.rasfood.vo.ItensPrincipaisVO(SUM(oc.quantidade),c.nome) FROM Ordem o " +
                " JOIN o.listaOrdemCardapio oc " +
                " JOIN oc.cardapio c " +
                " group by c.nome " +
                " ORDER BY SUM(oc.quantidade) DESC";
        return this.entityManager.createQuery(sql, ItensPrincipaisVO.class).getResultList();

    }

    public Ordem joinFetchCliente(Integer id) {
        String sql = "SELECT o FROM Ordem o JOIN FETCH o.cliente WHERE o.id = :id";
        List<Ordem> ordens = this.entityManager.createQuery(sql, Ordem.class)
                .setParameter("id", id)
                .getResultList();

        if (ordens.isEmpty()) {
            return null; // ou lance uma exceção personalizada, se preferir
        } else {
            return ordens.get(0); // Retorna a primeira ordem encontrada
        }
    }
}
