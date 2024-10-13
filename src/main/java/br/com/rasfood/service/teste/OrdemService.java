package br.com.rasfood.service.teste;

import br.com.rasfood.dao.ClienteDao;
import br.com.rasfood.dao.OrdemDao;
import br.com.rasfood.entity.Cliente;
import br.com.rasfood.entity.Ordem;
import br.com.rasfood.utils.JPAutils;
import br.com.rasfood.utils.Mock;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemService {
    public static void main(String[] args) {

        EntityManager entityManager = JPAutils.getEntityManagerrestaurante();
        entityManager.getTransaction().begin();
        OrdemDao ordemDao = new OrdemDao(entityManager);
        Mock.cadastrarCategoria(entityManager);
        Mock.cadastrarProdutoCardapio(entityManager);
        Mock.PopularClientes(entityManager);
        Mock.pupularOrdem(entityManager);
        ordemDao.consultarItensMaisVendidos().forEach(System.out::println);
        Ordem ordem = ordemDao.joinFetchCliente(1);
        System.out.println(ordem.getCliente().getNome());
        ClienteDao clienteDao = new ClienteDao(entityManager);
        List<Cliente> clientes = clienteDao.clientesBynome("vic");
        System.out.println(clientes);
    }
}
