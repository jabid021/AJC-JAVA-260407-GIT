package quest.restcontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeFreeRestController.class)
@AutoConfigureMockMvc(addFilters = false)
class HomeFreeRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void free_shouldReturnMessage() throws Exception {
        mockMvc.perform(get("/api/home/free"))
                .andExpect(status().isOk())
                .andExpect(content().string("FREEEE Mathieu !!"));
    }
}