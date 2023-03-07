package com.prasad.evchargingstation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prasad.evchargingstation.exception.EvChargingStationNotFoundException;
import com.prasad.evchargingstation.model.EvChargingStation;
import com.prasad.evchargingstation.service.EvChargingStationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class EvChargingStationControllerTest {

    @InjectMocks
    private EvChargingStationController evChargingStationController;

    @Mock
    private EvChargingStationService evChargingStationService;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private EvChargingStation evChargingStation1, evChargingStation2;

    @BeforeEach
    public void setUp() {
        evChargingStation1 = new EvChargingStation(1L, "Station 1", "image1.png", "$1/hour", "123 Main St");
        evChargingStation2 = new EvChargingStation(2L, "Station 2", "image2.png", "$2/hour", "456 Elm St");
    }

    @Test
    public void testGetAllStations() throws Exception {
        when(evChargingStationService.getAllStations()).thenReturn(Arrays.asList(evChargingStation1, evChargingStation2));

        mockMvc.perform(MockMvcRequestBuilders.get("/stations"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].stationId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].stationName").value("Station 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].stationImage").value("image1.png"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].stationPricing").value("$1/hour"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].stationAddress").value("123 Main St"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].stationId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].stationName").value("Station 2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].stationImage").value("image2.png"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].stationPricing").value("$2/hour"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].stationAddress").value("456 Elm St"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testGetStationById() throws Exception {
       
