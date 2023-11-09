package com.linketinder.microservices.models

class Empresa extends Pessoa{
    private String cnpj

    Empresa(
            String nome,
            String email,
            String pais,
            String cep,
            String descricao,
            String senha,
            String cnpj
    ) {
        super(nome, email, pais, cep, descricao, senha)
        this.cnpj = cnpj
    }

    String getCnpj() {
        return cnpj
    }

}
