package com.prasad.evchargingstation.service;

import com.prasad.evchargingstation.exception.EvChargingStationNotFoundException;
import com.prasad.evchargingstation.model.EvChargingStation;
import com.prasad.evchargingstation.repository.EvChargingStationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EvChargingStationServiceImplTest {

    @Mock
    private EvChargingStationRepository repository;

    @InjectMocks
    private EvChargingStationServiceImpl service;

    private EvChargingStation testStation;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        testStation = new EvChargingStation();
        testStation.setId(1L);
        testStation.setName("Test Station");
        testStation.setImageUrl("https://example.com/image.jpg");
        testStation.setPricing(0.2);
        testStation.setAddress("123 Main St, Anytown USA");
    }

    @Test
    public void testFindAll() {
        List<EvChargingStation> expectedStations = new ArrayList<>();
        expectedStations.add(testStation);

        when(repository.findAll()).thenReturn(expectedStations);

        List<EvChargingStation> actualStations = service.findAll();

        assertEquals(expectedStations, actualStations);

        verify(repository, times(1)).findAll();
    }

    @Test
    public void testFindByIdSuccess() {
        when(repository.findById(1L)).thenReturn(Optional.of(testStation));

        EvChargingStation actualStation = service.findById(1L);

        assertEquals(testStation, actualStation);

        verify(repository, times(1)).findById(1L);
    }

    @Test
    public void testFindByIdNotFound() {
        when(repository.findById(any())).thenReturn(Optional.empty());

        assertThrows(EvChargingStationNotFoundException.class, () -> {
            service.findById(1L);
        });

        verify(repository, times(1)).findById(1L);
    }

    @Test
    public void testSave() {
        when(repository.save(any())).thenReturn(testStation);

        EvChargingStation actualStation = service.save(testStation);

        assertEquals(testStation, actualStation);

        verify(repository, times(1)).save(testStation);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(repository).deleteById(1L);

        service.deleteById(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
