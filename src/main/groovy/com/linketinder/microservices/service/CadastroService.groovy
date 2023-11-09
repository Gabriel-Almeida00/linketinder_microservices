package com.linketinder.microservices.service

import com.linketinder.microservices.dao.ICadastroDao
import com.linketinder.microservices.models.Candidato
import com.linketinder.microservices.models.Empresa

class CadastroService implements ICadastroService{
    private final ICadastroDao cadastroDao

    CadastroService(ICadastroDao cadastroDao) {
        this.cadastroDao = cadastroDao
    }

    @Override
    void cadastrarCandidato(Candidato candidato) {
        this.cadastroDao.adicionarCandidato(candidato)
    }

    @Override
    void cadastrarEmpresa(Empresa empresa) {
        this.cadastroDao.adicionarEmpresa(empresa)
    }
}
