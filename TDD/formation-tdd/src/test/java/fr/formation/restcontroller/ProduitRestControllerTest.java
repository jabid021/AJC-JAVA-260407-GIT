package fr.formation.restcontroller;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import fr.formation.model.Produit;
import fr.formation.repo.ProduitRepository;

@WebMvcTest(controllers = ProduitRestController.class)
public class ProduitRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProduitRepository repository;

    @Test
    @WithMockUser
    void shouldFindAllStatusOk() throws Exception {
        // given
        String url = "/api/produit";

        // when
        ResultActions result = this.mockMvc.perform(
            MockMvcRequestBuilders.get(url)
        );

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
        result.andExpect(MockMvcResultMatchers.jsonPath("$").exists());

        Mockito.verify(this.repository).findAll();
    }

    @Test
    @WithMockUser
    void shouldDeleteByIdStatusOk() throws Exception {
        // given
        int id = 1;
        String url = "/api/produit/" + id;

        // when
        ResultActions result = this.mockMvc.perform(
            MockMvcRequestBuilders
                .delete(url)
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        );

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(this.repository).deleteById(id);
    }

    @Test
    @WithMockUser
    void shouldDeleteById2StatusOk() throws Exception {
        // given
        int id = 1;
        String url = "/api/produit/2/" + id;

        // when
        ResultActions result = this.mockMvc.perform(
            MockMvcRequestBuilders
                .delete(url)
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        );

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(this.repository).deleteById(id);
    }

    @Test
    @WithMockUser
    void shouldDeleteById3StatusOk() throws Exception {
        // given
        int id = 1;
        String url = "/api/produit/3/" + id;
        Produit produit = new Produit();

        produit.setId(id);

        // Quand on appelle repository.findById
        // On demande à Mockito de retourner un Optional qui contient notre produit
        Mockito
            .when(this.repository.findById(id))
            .thenReturn(Optional.of(produit))
        ;

        // when
        ResultActions result = this.mockMvc.perform(
            MockMvcRequestBuilders
                .delete(url)
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        );

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(this.repository).delete(Mockito.any());
    }
}
