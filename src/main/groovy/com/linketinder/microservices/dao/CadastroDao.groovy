package com.linketinder.microservices.dao

import com.linketinder.microservices.db.IDatabaseConnection
import com.linketinder.microservices.exception.DataBaseException
import com.linketinder.microservices.models.Candidato
import com.linketinder.microservices.models.Empresa

import java.sql.PreparedStatement
import java.sql.SQLException

class CadastroDao implements ICadastroDao{
    private IDatabaseConnection databaseConnection

    CadastroDao(IDatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection
    }

    @Override
    void adicionarCandidato(Candidato candidato) {
        String sql = "INSERT INTO candidatos (nome, sobrenome, dataNascimento, email,redeSocial, telefone, cpf, pais, cep, descricao, senha) " +
                "VALUES (?, ?,? ,?,?, ?, ?, ?, ?, ?, ?)"

        try (PreparedStatement statement = databaseConnection.prepareStatement(sql)) {
            statement.setString(1, candidato.getNome())
            statement.setString(2, candidato.getSobrenome())
            statement.setDate(3, new java.sql.Date(candidato.getDataNascimento().time))
            statement.setString(4, candidato.getEmail())
            statement.setString(5, candidato.getRedeSocial())
            statement.setString(6, candidato.getTelefone())
            statement.setString(7, candidato.getCpf())
            statement.setString(8, candidato.getPais())
            statement.setString(9, candidato.getCep())
            statement.setString(10, candidato.getDescricao())
            statement.setString(11, candidato.getSenha())
            statement.executeUpdate()

        } catch (SQLException e) {
            throw new DataBaseException("Erro ao acessar o banco de dados: " + e.getMessage())
        }
    }

    @Override
    void adicionarEmpresa(Empresa empresa) throws SQLException {
        String sql = "INSERT INTO empresas (nome, cnpj, email, descricao, pais, cep, senha) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"

        try (PreparedStatement statement = databaseConnection.prepareStatement(sql)) {
            statement.setString(1, empresa.getNome())
            statement.setString(2, empresa.getCnpj())
            statement.setString(3, empresa.getEmail())
            statement.setString(4, empresa.getDescricao())
            statement.setString(5, empresa.getPais())
            statement.setString(6, empresa.getCep())
            statement.setString(7, empresa.getSenha())

            statement.executeUpdate()
        } catch (SQLException e) {
            throw new DataBaseException("Erro ao acessar o banco de dados: " + e.getMessage())
        }
    }
}
