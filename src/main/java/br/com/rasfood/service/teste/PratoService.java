package br.com.rasfood.service.teste;

import br.com.rasfood.dao.PratoDAO;
import br.com.rasfood.entity.Prato;
import br.com.rasfood.utils.JPAutils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {
        Prato risoto = new Prato();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));
        EntityManager em = JPAutils.getEntityManagerrestaurante();
        PratoDAO pratoDao = new PratoDAO(em);
        em.getTransaction().begin();
        pratoDao.cadastrar(risoto);
        em.getTransaction().commit();
        em.close();
    }
}
