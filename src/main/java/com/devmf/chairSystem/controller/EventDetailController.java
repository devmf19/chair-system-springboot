package com.devmf.chairSystem.controller;

import com.devmf.chairSystem.dto.*;
import com.devmf.chairSystem.service.implementation.*;
import com.devmf.chairSystem.util.mapper.EventMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/events/detail")
@AllArgsConstructor
public class EventDetailController {
    private final EventDetailService eventDetailService;
    private final EventService eventService;
    private final ProductService productService;
    private final SettingService settingService;
    private final EventMapper eventMapper;

    @PostMapping("")
    public ResponseEntity<?> saveDetail(@RequestBody EventDetailDto eventDetailDto) {
        //precio no puede ser menor a 0 y la cantidad del producto no puede ser menor a 1
        if (eventDetailDto.getPrice() < 0 || eventDetailDto.getAmount() < 1)
            return new ResponseEntity<>(
                    new Message("The price can't be less than " + settingService.getSetting().getMoney().getShortName() + " 0. Quantity must be greater than 0"),
                    HttpStatus.BAD_REQUEST
            );

        //se valida que el evento exista en la base de datos
        EventDto event = eventMapper.entityToDto(eventService.getEventById(eventDetailDto.getEventId()));
        if (eventService.validateEvent(event))
            return new ResponseEntity<>(new Message("Not found event"), HttpStatus.NOT_FOUND);

        //se valida que el producto exista en la base de datos
        ProductDto product = productService.getProductById(eventDetailDto.getProduct().getId());
        if (productService.validateProduct(product))
            return new ResponseEntity<>(new Message("Not found product"), HttpStatus.NOT_FOUND);

        //se consulta la cantidad del producto disponibles para las fechas del evento
        Map<String, Object> availableUnits = productService.availableProducts(event.getInitialDate().toString(), event.getEndDate().toString())
                .stream()
                .filter(e -> Long.parseLong(e.get("productId").toString()) == product.getId())
                .collect(Collectors.toList()).get(0);

        //se le notifica al usuario si ingresó una cantidad mayor a la disponible
        if (eventDetailDto.getAmount() > Long.parseLong(availableUnits.get("available").toString()))
            return new ResponseEntity<>(
                    new Message(
                            "The quantity of " + availableUnits.get("productName").toString() + " exceeds that available for the indicated date." +
                                    " Available: " + availableUnits.get("available").toString() +
                                    ", Date: " + event.getInitialDate().toString() + " - " + event.getEndDate()
                    ),
                    HttpStatus.BAD_REQUEST
            );

        //se regitra el pedido
        eventDetailService.saveEventDetail(eventDetailDto);

        return new ResponseEntity<>(new Message("Saved event detail"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDetail(@PathVariable("id") long id, @RequestBody EventDetailDto eventDetailDto) {
        EventDetailDto eventDetail = eventDetailService.getEventDetailById(id);
        if (eventDetail == null)
            return new ResponseEntity<>(new Message("Not found detail"), HttpStatus.NOT_FOUND);

        eventDetail.setAmount(eventDetailDto.getAmount());
        eventDetail.setPrice(eventDetailDto.getPrice());
        eventDetailService.updateEventDetail(eventDetail);

        return new ResponseEntity<>(new Message("Updated event detail"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDetail(@PathVariable("id") long id) {
        EventDetailDto eventDetail = eventDetailService.getEventDetailById(id);
        if (eventDetail == null)
            return new ResponseEntity<>(new Message("Not found detail"), HttpStatus.NOT_FOUND);

        eventDetailService.deleteEventDetail(eventDetail);

        return new ResponseEntity<>(new Message("Deleted detail"), HttpStatus.OK);
    }
}
