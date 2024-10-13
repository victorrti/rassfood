package br.com.rasfood.service.teste;

import br.com.rasfood.dao.OrdemDao;
import br.com.rasfood.entity.Cliente;
import br.com.rasfood.utils.JPAutils;
import br.com.rasfood.utils.Mock;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {

        EntityManager entityManager = JPAutils.getEntityManagerrestaurante();
        entityManager.getTransaction().begin();
        OrdemDao ordemDao = new OrdemDao(entityManager);
        Mock.cadastrarCategoria(entityManager);
        Mock.cadastrarProdutoCardapio(entityManager);
        Mock.PopularClientes(entityManager);
        Mock.pupularOrdem(entityManager);
        ordemDao.consultarItensMaisVendidos().forEach(item-> System.out.println("quantidade: "+item[0]+" item: "+item[1]));
    }
}
