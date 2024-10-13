package br.com.rasfood.dao;

import br.com.rasfood.vo.ClienteVO;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDAO {

    private EntityManager em;

    public EnderecoDAO(EntityManager em){
        this.em = em;
    }

    public List<ClienteVO> listaClienteByEndereco(String rua,String cidade,String uf){
        String jdbc = "SELECT new br.com.rasfood.vo.ClienteVO(c.nome,c.cpf) FROM  Endereco e "+
                " JOIN  e.cliente c  "+
                " WHERE UPPER(e.rua) = UPPER(:rua) "+
                " AND UPPER(e.cidade) = UPPER(:cidade) "+
                " AND UPPER(e.uf) = UPPER(:uf) ";

        return this.em.createQuery(jdbc, ClienteVO.class)
                .setParameter("rua",rua)
                .setParameter("cidade",cidade)
                .setParameter("uf",uf)
                .getResultList();


    }
}
