package br.com.rasfood.utils;

import br.com.rasfood.dao.CardapioDao;
import br.com.rasfood.dao.CategoriaDao;
import br.com.rasfood.dao.ClienteDao;
import br.com.rasfood.dao.OrdemDao;
import br.com.rasfood.entity.*;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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




        cardapioDao.cadastrar(risoto);
        cardapioDao.cadastrar(salmao);
        cardapioDao.cadastrar(pizza);
        cardapioDao.cadastrar(lasanha);
        em.flush();
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
        categoriaDao.cadastrar(petisco);
        categoriaDao.cadastrar(principal);
        categoriaDao.cadastrar(entrada);
        em.flush();
        em.clear();



    }

    public static void PopularClientes(EntityManager em){
        ClienteDao clienteDao = new ClienteDao(em);
        Cliente victor = new Cliente();
        victor.setNome("Victor");
        victor.setCpf("11111111111");
        victor.setCep("112123345");
        Endereco endereco = new Endereco("rua dos devs","222","222222222","bairro dos devs","cidade dos devs","DV",victor);
        victor.addEndereco(endereco);
        clienteDao.cadastrar(victor);
        Cliente vanessa = new Cliente();
        vanessa.setNome("Vanessa");
        vanessa.setCpf("222222222");
        vanessa.setCep("123456789");
        Endereco  enderecoVanessa = new Endereco("rua dos devs","222","222222222","bairro dos devs","cidade dos devs","DV",victor);
        vanessa.addEndereco(enderecoVanessa);
        clienteDao.cadastrar(vanessa);
        Cliente pedro = new Cliente();
        pedro.setNome("Pedro");
        pedro.setCpf("333333333");
        pedro.setCep("456789876");
        Endereco  enderecoPedro= new Endereco("rua dos devs","222","222222222","bairro dos devs","cidade dos devs","DV",victor);
        pedro.addEndereco(enderecoPedro);
        clienteDao.cadastrar(pedro);
        Cliente jessica = new Cliente();
        jessica.setNome("jessica");
        jessica.setCpf("444444444");
        jessica.setCep("123345676");
        Endereco  enderecoJessica= new Endereco("rua dos devs","222","222222222","bairro dos devs","cidade dos devs","DV",victor);
        jessica.addEndereco(enderecoJessica);
        clienteDao.cadastrar(jessica);
        em.flush();
        em.clear();

    }

    public static void pupularOrdem(EntityManager em){
        ClienteDao clienteDao = new ClienteDao(em);
        CardapioDao cardapioDao = new CardapioDao(em);
        OrdemDao ordemDao = new OrdemDao(em);

        List<Cliente> clientes =  clienteDao.findAll();
        for(Cliente cliente : clientes){
            Ordem ordem = new Ordem();
            ordem.setCliente(cliente);
            List<Cardapio> cardapios = cardapioDao.findAll();
            for(Cardapio cardapio : cardapios){
                OrdemCardapio ordemCardapio = new OrdemCardapio();
                ordemCardapio.setCardapio(cardapio);
                Random random = new Random();
                Integer numero = random.nextInt(0,10);
                ordemCardapio.setQuantidade(numero);
                ordemCardapio.setValor(cardapio.getValor().multiply(BigDecimal.valueOf(ordemCardapio.getQuantidade())));
                ordem.addOrdemCardapio(ordemCardapio);
                ordem.getValorTotal().add(ordemCardapio.getValor());
            }
            ordemDao.cadastrar(ordem);

        }
        em.flush();
        em.clear();

    }
}
