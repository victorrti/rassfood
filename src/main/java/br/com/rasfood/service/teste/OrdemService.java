package br.com.rasfood.service.teste;

import br.com.rasfood.entity.Cliente;
import br.com.rasfood.utils.JPAutils;
import br.com.rasfood.utils.Mock;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAutils.getEntityManagerrestaurante();
        entityManager.getTransaction().begin();
        Mock.cadastrarCategoria(entityManager);
        Mock.cadastrarProdutoCardapio(entityManager);
        Mock.PopularClientes(entityManager);
        Mock.pupularOrdem(entityManager);
    }
}
