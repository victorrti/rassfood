package br.com.rasfood.dao;

import br.com.rasfood.vo.ClienteVO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

public class EnderecoDAO {

    private EntityManager em;

    public EnderecoDAO(EntityManager em){
        this.em = em;
    }

    public List<ClienteVO> listaClienteByEndereco(String rua,String cidade,String uf){
        String jdbc = "SELECT new br.com.rasfood.vo.ClienteVO(c.nome,c.cpf) FROM  Endereco e "+
                " JOIN  e.cliente c  ";

        if(!Objects.isNull(rua)){
            jdbc = jdbc.concat(" WHERE UPPER(e.rua) = UPPER(:rua) ");
        }
        if(!Objects.isNull(cidade)){
           jdbc = jdbc.concat(" AND UPPER(e.cidade) = UPPER(:cidade) ");
        }
        if(!Objects.isNull(uf)){
           jdbc= jdbc.concat(" AND UPPER(e.uf) = UPPER(:uf) ");
        }
        TypedQuery typedQuery = this.em.createQuery(jdbc, ClienteVO.class);
        if(!Objects.isNull(rua)){
            typedQuery.setParameter("rua",rua);
        }
        if(!Objects.isNull(cidade)){
            typedQuery.setParameter("cidade",cidade);
        }
        if(!Objects.isNull(uf)){
            typedQuery.setParameter("uf",uf);
        }
       return typedQuery.getResultList();


    }
}
