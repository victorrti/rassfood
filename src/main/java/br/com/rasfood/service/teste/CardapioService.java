package br.com.rasfood.service.teste;

import br.com.rasfood.dao.CardapioDao;
import br.com.rasfood.entity.Cardapio;
import br.com.rasfood.utils.JPAutils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        salmao.setNome("salmao ao molho de maracuja");
        salmao.setDescricao("salmao grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(60.00));

        EntityManager em = JPAutils.getEntityManagerrestaurante();
        CardapioDao cardapioDao = new CardapioDao(em);
        em.getTransaction().begin();
        cardapioDao.cadastrar(risoto);
        em.flush();
        cardapioDao.cadastrar(salmao);
        em.flush();
        em.clear();
        salmao.setValor(BigDecimal.valueOf(30.00));
        em.merge(salmao);
        System.out.println(cardapioDao.consultar(2));



    }
}
