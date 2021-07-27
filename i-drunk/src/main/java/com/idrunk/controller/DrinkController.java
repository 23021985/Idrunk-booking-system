package com.idrunk.controller;

import com.idrunk.controller.dtos.DrinkDto;
import com.idrunk.controller.dtos.DrinkInputDto;
import com.idrunk.exceptions.BadRequestException;
import com.idrunk.models.Drink;
import com.idrunk.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/drinks")
public class DrinkController {

    private final DrinkService drinkService;

    @Autowired
    private DrinkController(DrinkService drinkService){
        this.drinkService = drinkService;
    }

    @GetMapping
    public List<DrinkDto>getDrinks() {
        var dtos = new ArrayList<DrinkDto>();
        var drinks = drinkService.getDrinks();

        for (Drink drink:drinks) {
            dtos.add(DrinkDto.fromDrink(drink));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public DrinkDto getDrink(@PathVariable("id") Long id) {
        var drink = drinkService.getDrink(id);
        return DrinkDto.fromDrink(drink);
    }


    @PostMapping
    public DrinkDto saveDrink(@RequestBody DrinkInputDto dto) {
        var drink = drinkService.saveDrink(dto.toDrink());
        return DrinkDto.fromDrink(drink);
    }

    @DeleteMapping("/{id}")
    public void deleteDrink(@PathVariable("id") Long id) {
        drinkService.deleteDrink(id);
    }

    @PutMapping("/{id}")
    public void updateDrink(@PathVariable("id") Long id,
                            @RequestBody Drink drink) {
        drinkService.updateDrink(id, drink);
    }

    @GetMapping(value = "/{requestId}/drinks")
    public ResponseEntity<Object> getRequestDrinks(@PathVariable("requestId") Long requestId) {
        return ResponseEntity.ok().body(drinkService.getDrinkSet(requestId));
    }

    @PostMapping(value = "/{requestId}/drinks")
    public ResponseEntity<Object> addRequestDrink(@PathVariable("requestId") Long requestId, @RequestBody Map<String, Object> fields, @RequestBody int amount) {
        try {
            Long id = (Long) fields.get("id");
            drinkService.addDrink(requestId, id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{requestId}/drinkset/{drink}")
    public ResponseEntity<Object> deleteRequestDrink(@PathVariable("requestId") Long requestId, @PathVariable("id") Long id) {
        drinkService.removeDrink(requestId, id);
        return ResponseEntity.noContent().build();
    }

}