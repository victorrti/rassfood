package br.com.rasfood.utils;

import br.com.rasfood.dao.CardapioDao;
import br.com.rasfood.dao.CategoriaDao;
import br.com.rasfood.entity.Cardapio;
import br.com.rasfood.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.Collectors;

public class Mock {



    public static void cadastrarProdutoCardapio(EntityManager em){
        CardapioDao cardapioDao = new CardapioDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        Integer tamanhoLista = categoriaDao.findAll().size();
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));
        Random randomrisoto = new Random();
        int numeroAleatorio = randomrisoto.nextInt(tamanhoLista);
        risoto.setCategoria(categoriaDao.findAll().get(numeroAleatorio));

        Cardapio salmao = new Cardapio();
        salmao.setNome("salmao ao molho de maracuja");
        salmao.setDescricao("salmao grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(70.00));
        Random randomSalmao = new Random();
        int numeroAleatoriosalmao = randomSalmao.nextInt(tamanhoLista);
        salmao.setCategoria(categoriaDao.findAll().get(numeroAleatoriosalmao));

        Cardapio lasanha = new Cardapio();
        lasanha.setNome("lasanha");
        lasanha.setDescricao("lasanha a bolonhesa");
        lasanha.setDisponivel(true);
        lasanha.setValor(BigDecimal.valueOf(70.00));

        Random randomLasanha = new Random();
        int numeroAleatorioLasanha = randomLasanha.nextInt(tamanhoLista);
        lasanha.setCategoria(categoriaDao.findAll().get(numeroAleatorioLasanha));

        Cardapio pizza = new Cardapio();
        pizza.setNome("pizza");
        pizza.setDescricao("lasanha a bolonhesa");
        pizza.setDisponivel(true);
        pizza.setValor(BigDecimal.valueOf(35.00));

        Random randomPizza = new Random();
        int numeroAleatorioPizza = randomPizza.nextInt(tamanhoLista);
        pizza.setCategoria(categoriaDao.findAll().get(numeroAleatorioPizza));



        em.getTransaction().begin();
        cardapioDao.cadastrar(risoto);
        cardapioDao.cadastrar(salmao);
        cardapioDao.cadastrar(pizza);
        cardapioDao.cadastrar(lasanha);
        em.getTransaction().commit();
        em.clear();

    }
    public static void  cadastrarCategoria(EntityManager em){
        CategoriaDao categoriaDao = new CategoriaDao(em);
        Categoria petisco = new Categoria();
        petisco.setNome("petisco");
        Categoria principal = new Categoria();
        principal.setNome("principal");
        Categoria entrada = new Categoria();
        entrada.setNome("entrada");
        em.getTransaction().begin();
        categoriaDao.cadastrar(petisco);
        categoriaDao.cadastrar(principal);
        categoriaDao.cadastrar(entrada);
        em.getTransaction().commit();
        em.clear();



    }
}
