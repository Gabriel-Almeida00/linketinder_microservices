package service

import com.linketinder.microservices.models.Candidato
import com.linketinder.microservices.models.Empresa
import com.linketinder.microservices.service.ICadastroService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import java.sql.SQLException

import static org.mockito.Mockito.mock
import static org.mockito.Mockito.verify

class CadastroServiceTest {
    private ICadastroService cadastroService

    @BeforeEach
    void setup() {
        this.cadastroService = mock(ICadastroService.class)
    }

    @Test
    void testCadastrarCandidato() throws SQLException {
        Candidato candidatoMock = new Candidato(
                "gabriel",
                "gabrel@gmail.com",
                "brasil",
                "32132",
                "descrição",
                "123teste",
                "almeida",
                new Date(System.currentTimeMillis()),
                "teste",
                "11232323",
                "321321311"
        )

        cadastroService.cadastrarCandidato(candidatoMock)

        verify(cadastroService).cadastrarCandidato(candidatoMock)
    }

    @Test
    void testAdicionarEmpresa() throws SQLException {
        Empresa empresaMock = new Empresa(
                "Empresa 1",
                "empresa1@gmail.com",
                "brasil",
                "321123",
                "descrição empresa 1",
                "321teste",
                "1233"
        )

        cadastroService.cadastrarEmpresa(empresaMock)

        verify(cadastroService).cadastrarEmpresa(empresaMock)
    }

}
