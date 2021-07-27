package com.idrunk.controller;

import com.idrunk.controller.dtos.RequestDto;
import com.idrunk.controller.dtos.RequestInputDto;
import com.idrunk.exceptions.BadRequestException;
import com.idrunk.models.Request;
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

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public List<RequestDto>  getRequests(@RequestParam(value = "username", required = false) String username) {
        var dtos = new ArrayList<RequestDto>();
        List <Request> requests;
        if (username == null ) {
            requests = requestService.getRequests();
        } else if (username != null ) {
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

    @PostMapping
    public ResponseEntity<Object> createRequest(@RequestBody Request request) {
        Long id = requestService.createRequest(request);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{requestId}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }
}