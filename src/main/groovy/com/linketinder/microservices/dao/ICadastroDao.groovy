package com.linketinder.microservices.dao

import com.linketinder.microservices.models.Candidato
import com.linketinder.microservices.models.Empresa

interface ICadastroDao {
    void adicionarCandidato(Candidato candidato)
    void adicionarEmpresa(Empresa empresa);
}