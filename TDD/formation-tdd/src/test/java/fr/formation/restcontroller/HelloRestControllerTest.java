package fr.formation.restcontroller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc // Permet d'injecter un MockMvc dans le contexte de Spring
public class HelloRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

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

        result.andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }
}
