package br.com.rasfood.vo;

import java.math.BigDecimal;

public class ItensPrincipaisVO {
    private String nome;
    private long quantidade;

    public ItensPrincipaisVO(){}

    public ItensPrincipaisVO( long quantidade,String nome) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItensPrincipaisVO{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
