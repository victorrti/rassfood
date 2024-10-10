package br.com.rasfood.service.teste;

import br.com.rasfood.dao.CardapioDao;
import br.com.rasfood.dao.CategoriaDao;
import br.com.rasfood.entity.Cardapio;
import br.com.rasfood.entity.Categoria;
import br.com.rasfood.utils.JPAutils;
import br.com.rasfood.utils.Mock;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.stream.Collectors;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager em = JPAutils.getEntityManagerrestaurante();
        Mock.cadastrarCategoria(em);
        Mock.cadastrarProdutoCardapio(em);
        CardapioDao cardapioDao = new CardapioDao(em);

        cardapioDao.consultarForValor(BigDecimal.valueOf(35.00))
                .stream().peek(System.out::println).collect(Collectors.toList());

        System.out.println(cardapioDao.consultarForNome("laSanhA"));


    }



}
