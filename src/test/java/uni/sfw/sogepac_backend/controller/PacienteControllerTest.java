package uni.sfw.sogepac_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.http.MediaType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import org.hamcrest.CoreMatchers;
import uni.sfw.sogepac_backend.Controller.PacienteController;
import uni.sfw.sogepac_backend.Model.Paciente;
import uni.sfw.sogepac_backend.Service.PacienteService;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(controllers = PacienteController.class)
@AutoConfigureMockMvc(addFilters = false)
public class PacienteControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private PacienteService pacienteService;

        @Autowired
        private ObjectMapper objectMapper;

        private Paciente paciente1, paciente2;

        @BeforeEach
        public void init() {
                paciente1 = Paciente.builder()
                                .ID("11")
                                .nombre("PacienteTest")
                                .DNI("11223344")
                                .edad(20)
                                .telefono("999888777")
                                .build();

                paciente2 = Paciente.builder()
                                .ID("12")
                                .nombre("PacienteTest2")
                                .DNI("22334455")
                                .edad(21)
                                .telefono("888777666")
                                .build();
        }

        @Test
        public void PacienteController_insert() throws Exception {
                given(pacienteService.Save(ArgumentMatchers.any()))
                                .willAnswer((invocation -> invocation.getArgument(0)));

                ResultActions response = mockMvc.perform(post("/api/v1/paciente/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(paciente1)));

                response.andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.DNI",
                                                CoreMatchers.is(paciente1.getDNI())));
        }

        @Test
        public void PacienteController_listar() throws Exception {
                List<Paciente> pacientesList = new ArrayList<>();
                pacientesList.add(paciente1);
                pacientesList.add(paciente2);

                when(pacienteService.GetAll()).thenReturn(pacientesList);

                ResultActions response = mockMvc.perform(get("/api/v1/paciente/all")
                                .contentType(MediaType.APPLICATION_JSON));

                response.andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.size()",
                                                CoreMatchers.is(pacientesList.size())))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(2)));
        }
}
