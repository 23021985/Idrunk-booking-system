package com.idrunk.controller;

import com.idrunk.controller.dtos.RequestDto;
import com.idrunk.controller.dtos.RequestInputDto;
import com.idrunk.exceptions.BadRequestException;
import com.idrunk.models.Request;
import com.idrunk.models.RequestDrinkAmount;
import com.idrunk.models.RequestDrinkAmountKey;
import com.idrunk.services.DrinkService;
import com.idrunk.services.RequestDrinkAmountService;
import com.idrunk.services.RequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {

    private final RequestService requestService;
    private final RequestDrinkAmountService requestDrinkAmountService;


    @Autowired
    public RequestController(RequestService requestService, RequestDrinkAmountService requestDrinkAmountService) {
        this.requestService = requestService;
        this.requestDrinkAmountService = requestDrinkAmountService;

     }

    @GetMapping
    public List<RequestDto>  getRequests(@RequestParam(value = "username", required = false) String username) {
        var dtos = new ArrayList<RequestDto>();
        List <Request> requests;
        System.out.println(username);
        if (username == null ) {
            requests = requestService.getRequests();
        } else if (username != null ) {
            System.out.println(username);
            requests = requestService.getRequestsByUser(username);
        } else {
            throw new BadRequestException("Helaas..");
        }
        for (Request request : requests) {
            dtos.add(RequestDto.fromRequest(request));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public RequestDto getRequest(@PathVariable("id") Long id) {
        var request = requestService.getRequest(id);
        return RequestDto.fromRequest(request);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable("id") Long id) {
        requestService.deleteRequest(id);
    }

    @PutMapping("/{id}")
    public void updateRequest(@PathVariable("id") Long id, Request request) {
        requestService.updateRequest(id, request);
    }

    @GetMapping("/request/amounts")
    public ResponseEntity<Object> getAllAmounts(){
        return ResponseEntity.ok().body(requestDrinkAmountService.getAllAmounts());
    }

    @GetMapping("/request/request_id/{id}")
    public ResponseEntity<Object> getAmountsByRequestId(@PathVariable("id") long id){
        return ResponseEntity.ok().body(requestDrinkAmountService.getAmountsByRequestId(id));
    }

    @GetMapping("/request/drink_id/{id}")
    public ResponseEntity<Object> getAmountsByDrinkId(@PathVariable("id") long id){
        return ResponseEntity.ok().body(requestDrinkAmountService.getAmountsByDrinkId(id));
    }

    @GetMapping("/{request_id}/{drink_id}")
    public ResponseEntity<Object> getAmountById(@PathVariable("request_id") long requestId,
                                                @PathVariable("drink_id") long drinkId){
        return ResponseEntity.ok().body(requestDrinkAmountService.getAmountById(requestId, drinkId));
    }

    @PostMapping
    public void saveRequest(@RequestBody RequestInputDto dto) {
        requestService.saveRequest(dto.username, dto.hasBeenServed, dto.amountSet);
        for( RequestDrinkAmount amount : dto.amountSet){
            requestDrinkAmountService.addAmount(amount.getRequest().getId(), amount.getDrink().getId(), amount);
        }
    }

    @PostMapping("/{request_id}/drinks/{drink_id}")
    public RequestDrinkAmountKey addAmount(@PathVariable("request_id") long requestId,
                                            @PathVariable("drink_id") long drinkId,
                                            @RequestBody RequestDrinkAmount amount) {
        RequestDrinkAmountKey newId = requestDrinkAmountService.addAmount(requestId, drinkId, amount);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
//        return ResponseEntity.created(location).body(location);
        return newId;
    }

//    @PostMapping
//    public void createRequest(@RequestBody RequestInputDto dto) {
//
//     requestService.createRequest(dto.username, dto.drinkIdList, dto.hasBeenServed);
//        for (Long drinkId:dto.drinkIdList) {
//            drinkService.addDrink((long) requestService.getRequests().size(),drinkId);
//        }
//    }
}