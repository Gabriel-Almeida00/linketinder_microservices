package com.linketinder.microservices.models

class Candidato extends Pessoa {

    private String sobrenome
    private Date dataNascimento
    private String cpf
    private String redeSocial
    private String telefone


    Candidato(
            String nome,
            String email,
            String pais,
            String cep,
            String descricao,
            String senha,
            String sobrenome,
            Date dataNascimento,
            String redeSocial,
            String telefone,
            String cpf
    ) {
        super(nome, email, pais, cep, descricao, senha)
        this.sobrenome = sobrenome
        this.dataNascimento = dataNascimento
        this.redeSocial = redeSocial
        this.telefone = telefone
        this.cpf = cpf

    }

    String getTelefone() {
        return telefone
    }

    String getRedeSocial() {
        return redeSocial
    }

    String getSobrenome() {
        return sobrenome
    }


    Date getDataNascimento() {
        return dataNascimento
    }

    String getCpf() {
        return cpf
    }
}
