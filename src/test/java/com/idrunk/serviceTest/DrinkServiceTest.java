package com.idrunk.serviceTest;

import com.idrunk.models.Drink;
import com.idrunk.repositories.DrinkRepository;
import com.idrunk.services.DrinkServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class DrinkServiceTest {

    @Mock
    DrinkRepository drinkRepository;

    @InjectMocks
    private DrinkServiceImpl drinkServiceImpl;

    @Captor
    ArgumentCaptor<Drink> drinkCaptor;


    @Test
    public void getAllDrinksTest() {
        when(drinkRepository.findAll()).thenReturn(List.of(new Drink(), new Drink(), new Drink()));
        List<Drink> drinkList = drinkServiceImpl.getDrinks();
        assertEquals(3, drinkList.size());
    }

    @Test
    public void getDrinkTest() {
        Drink drink = new Drink();
        drink.setId(1L);
        Long id = drink.getId();
        when(drinkRepository.findById(id)).thenReturn(Optional.of(drink));
        Optional<Drink> drink1 = drinkServiceImpl.getDrink();
        assertTrue(drink1.isPresent());
        assertEquals(id, drink1.get().getId());
    }

    @Test
    void addDrinkTest() {
        Drink initialDrink = new Drink();
        initialDrink.setId(1L);
        initialDrink.setDrinkName("testglas");
        initialDrink.setRequestId(1L);
//        initialDrink.setQuantityTotal(250);
//        initialDrink.setPricePerDay(55L);
        when(drinkRepository.save(initialDrink)).thenReturn(initialDrink);
        drinkServiceImpl.addDrink(initialDrink);
        verify(drinkRepository).save(drinkCaptor.capture());
        Drink newBike = bikeCaptor.getValue();
        assertThat(initialDrink.getId().equals(newBike.getId()));

    }

    @Test
    public void removeBikeTest() {
        Bike bike = new Bike();
        bike.setId(1L);
        bikeServiceImpl.removeBike(bike.getId());
        verify(bikeRepository).deleteById(bike.getId());
    }

    @Test
    public void updateBikeTest() {
        Bike initialBike = new Bike();
        initialBike.setBikeName("testbike2");
        initialBike.setQuantityTotal(240);
        initialBike.setPricePerDay(25L);
        initialBike.setId(2L);
        Bike update = new Bike();
        update.setQuantityTotal(99);
        when(bikeRepository.existsById(update.getId())).thenReturn(true);
        when(bikeRepository.findById(update.getId())).thenReturn(Optional.of(initialBike));
        bikeServiceImpl.updateBike(update.getId(), update);
        verify(bikeRepository).save(bikeCaptor.capture());
        Bike savedBike = bikeCaptor.getValue();
        assertEquals(savedBike.getQuantityTotal(), update.getQuantityTotal());
    }

}
