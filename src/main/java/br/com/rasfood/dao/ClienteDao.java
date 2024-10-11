package br.com.rasfood.dao;

import br.com.rasfood.entity.Cardapio;
import br.com.rasfood.entity.Cliente;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class ClienteDao {
    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Cliente cliente){
        this.entityManager.persist(cliente);
        System.out.println(cliente.getId());
    }

    public Cliente consultar(Integer id){
        return this.entityManager.find(Cliente.class,id);
    }

    public void atualizar(Cliente cliente){
        this.entityManager.merge(cliente);
    }

    public void excluir(Cliente cliente){
        this.entityManager.remove(cliente);
    }

    public List<Cliente> findAll(){
        try {
            String sql = "SELECT c FROM Cliente c";
            return this.entityManager.createQuery(sql, Cliente.class).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }


    public Cliente consultarForNome(String nome){
        try {
            String sql = "SELECT c FROM Cliente c WHERE UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(sql, Cliente.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
}
