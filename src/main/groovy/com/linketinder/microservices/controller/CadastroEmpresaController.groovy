package com.linketinder.microservices.controller

import com.linketinder.microservices.dao.CadastroDao
import com.linketinder.microservices.db.ConfigDataBase
import com.linketinder.microservices.db.IDatabaseConnection
import com.linketinder.microservices.db.factory.DatabaseFactory
import com.linketinder.microservices.db.factory.IDatabaseConnectionFactory
import com.linketinder.microservices.models.Candidato
import com.linketinder.microservices.models.Empresa
import com.linketinder.microservices.service.CadastroService
import com.linketinder.microservices.servlet.ServletResponse
import com.linketinder.microservices.servlet.ServletUtils

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "CadastroEmpresaController", urlPatterns = "/cadastro/empresa/*")
class CadastroEmpresaController extends HttpServlet {
    private ServletUtils servletUtils = new ServletUtils()
    private ServletResponse servletResponse = new ServletResponse()

    ConfigDataBase configDatabase = new ConfigDataBase()
    DatabaseFactory databaseFactory = new DatabaseFactory()
    IDatabaseConnectionFactory factory = databaseFactory.createConnectionFactory(configDatabase)
    IDatabaseConnection connection = factory.createConnection()
    CadastroDao dao = new CadastroDao(connection)
    CadastroService cadastroService = new CadastroService(dao)

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        servletResponse.methodPost(response, () -> {
            Empresa empresa = servletUtils.parseObjectFromRequest(request, Empresa.class)
            this.cadastroService.cadastrarEmpresa(empresa)
        })
    }
}
