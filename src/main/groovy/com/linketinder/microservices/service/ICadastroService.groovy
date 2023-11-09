package com.linketinder.microservices.service

import com.linketinder.microservices.models.Candidato
import com.linketinder.microservices.models.Empresa

interface ICadastroService {
    void cadastrarCandidato(Candidato candidato);
    void cadastrarEmpresa(Empresa empresa);
}