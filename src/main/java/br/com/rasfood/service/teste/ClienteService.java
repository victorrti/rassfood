package br.com.rasfood.service.teste;

import br.com.rasfood.dao.EnderecoDAO;
import br.com.rasfood.utils.JPAutils;
import br.com.rasfood.utils.Mock;

import javax.persistence.EntityManager;

public class ClienteService {
    public static void main(String[] args) {

        EntityManager entityManager = JPAutils.getEntityManagerrestaurante();
        entityManager.getTransaction().begin();
        EnderecoDAO enderecoDAO = new EnderecoDAO(entityManager);
        Mock.cadastrarCategoria(entityManager);
        Mock.cadastrarProdutoCardapio(entityManager);
        Mock.PopularClientes(entityManager);
        Mock.pupularOrdem(entityManager);
        System.out.println(enderecoDAO.listaClienteByEndereco("rua dos scrum","cidade dos scrum","DV"));


    }

}
