package com.quoteExpress.quoteExpress;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.quoteExpress.quoteExpress.controler.UtilisateurControler;
import com.quoteExpress.quoteExpress.model.Utilisateur;
import com.quoteExpress.quoteExpress.repository.UtilisateurRepository;
import com.quoteExpress.quoteExpress.service.UtilisateurService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UtilisateurControler.class)
public class UtilisateurTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UtilisateurService utilisateurService;

    private Utilisateur utilisateur;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        utilisateur = new Utilisateur(
                "Elsam",
                "Fawzy",
                "elsam@outlook.fr",
                "12345678",
                "FawzyTech",
                "0781360832",
                "1 allee nation",
                7500,
                "Paris",
                "france",
                Utilisateur.Status.Particulier,
                "789454",
                null,
                null
        );
        utilisateur.setId(10L);
    }

    @Test
    void testGetAllUtilisateur() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/utilisateurs")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetUtilisateur() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/utilisateur/10")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testAddUtilisateur() throws Exception {

        when(utilisateurService.addUtilisateur(utilisateur)).thenReturn(ResponseEntity.ok(true));

        String json = objectMapper.writeValueAsString(utilisateur);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/utilisateur")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void testDeleteUtilisateur() throws Exception {
        when(utilisateurService.deleteUtilisateur(utilisateur.getId())).thenReturn(ResponseEntity.ok(true));

        mockMvc.perform(MockMvcRequestBuilders.delete("/utilisateur/10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
