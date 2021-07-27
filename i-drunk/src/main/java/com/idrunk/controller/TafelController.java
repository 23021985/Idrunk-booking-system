package com.idrunk.controller;
import com.idrunk.controller.dtos.TafelDto;
import com.idrunk.controller.dtos.TafelInputDto;
import com.idrunk.models.Tafel;
import com.idrunk.services.TafelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tafels")
public class TafelController {

    private final TafelService tafelService;

    public TafelController(TafelService tafelService) {
        this.tafelService = tafelService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getTafel() {return ResponseEntity.ok(tafelService.getTafel());}

    @PostMapping
    public TafelDto saveTafel(@RequestBody TafelInputDto dto) {
        var tafel = tafelService.saveTafel(dto.toTafel());
        return TafelDto.fromTafel(tafel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTafel(@PathVariable("id") long id) {
        Tafel tafel = (Tafel) tafelService.getTafel(id);
        return ResponseEntity.ok(tafel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> removeTafel(@PathVariable("id") long id) {
        tafelService.deleteTafel(id);
        return ResponseEntity.noContent().build();
    }
}