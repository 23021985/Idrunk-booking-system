package com.idrunk.serviceTest;

import com.idrunk.models.Tafel;
import com.idrunk.repositories.TafelRepository;
import com.idrunk.services.TafelServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class TafelServiceImplTest {

    @Mock
    TafelRepository tafelRepository;

    @InjectMocks
    private TafelServiceImpl tafelServiceImpl;

    @Captor
    ArgumentCaptor<Tafel> tafelCaptor;


    @Test
    public void getTafelsTest() {
        when(tafelRepository.findAll()).thenReturn(List.of(new Tafel(), new Tafel(), new Tafel()));
        List<Tafel> tafelsList = (List<Tafel>) tafelServiceImpl.getTafels();
        assertEquals(3, tafelsList.size());
    }


    @Test
    public void getTafelTest() {
        Tafel tafel = new Tafel();
        tafel.setId(1L);
        Long id = tafel.getId();
        when(tafelRepository.findById(id)).thenReturn(Optional.of(tafel));
        Optional<Tafel> tafelOptional = Optional.ofNullable(tafelServiceImpl.getTafel(id));
        assertTrue(tafelOptional.isPresent());
        assertEquals(id, tafelOptional.get().getId());
    }

    @Test
    void saveTafelTest() {
        Tafel initialTafel = new Tafel();
        initialTafel.setId(1L);
        initialTafel.setTafelNr(1L);
//        initialTafel.setQuantityTotal(8);
        when(tafelRepository.save(initialTafel)).thenReturn(initialTafel);
        tafelServiceImpl.saveTafel(initialTafel);
        verify(tafelRepository).save(tafelCaptor.capture());
        Tafel newTafel = tafelCaptor.getValue();
        assertThat(initialTafel.getId().equals(newTafel.getId()));

    }

    @Test
    public void deleteTafelTest() {
        Tafel tafel = new Tafel();
        tafel.setId(1L);
        tafelServiceImpl.deleteTafel(tafel.getId());
        verify(tafelRepository).deleteById(tafel.getId());
    }

//    @Test
//    public void updateBikeTest() {
//        Bike initialBike = new Bike();
//        initialBike.setBikeName("testbike2");
//        initialBike.setQuantityTotal(240);
//        initialBike.setPricePerDay(25L);
//        initialBike.setId(2L);
//        Bike update = new Bike();
//        update.setQuantityTotal(99);
//        when(bikeRepository.existsById(update.getId())).thenReturn(true);
//        when(bikeRepository.findById(update.getId())).thenReturn(Optional.of(initialBike));
//        bikeServiceImpl.updateBike(update.getId(), update);
//        verify(bikeRepository).save(bikeCaptor.capture());
//        Bike savedBike = bikeCaptor.getValue();
//        assertEquals(savedBike.getQuantityTotal(), update.getQuantityTotal());
//    }

}