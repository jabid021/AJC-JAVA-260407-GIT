package fr.formation.restcontroller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import fr.formation.repo.HelloRepository;

// @SpringBootTest
// @AutoConfigureMockMvc // Permet d'injecter un MockMvc dans le contexte de Spring

// Avec WebMvcTest, le MockMvc est injecté par défaut
@WebMvcTest(controllers = HelloRestController.class)
public class HelloRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean // On précise à Spring Test que le HelloRepository est simulé par Mockito
    private HelloRepository repository;

    @Test
    @WithMockUser // Permet de simuler un utilisateur connecté
    void shouldFindAllStatusOk() throws Exception {
        // given
        String url = "/api/hello";

        // when
        ResultActions result = this.mockMvc.perform(
            MockMvcRequestBuilders.get(url)
        );

        // then
        // On vérifie si le status HTTP est 200 OK
        result.andExpect(MockMvcResultMatchers.status().isOk());

        // On vérifie que le contenu JSON existe bien
        result.andExpect(MockMvcResultMatchers.jsonPath("$").exists());

        // On vérifie si on a appelé UNE FOIS ET UNE SEULE FOIS le findAll
        Mockito.verify(this.repository).findAll();
    }
}
