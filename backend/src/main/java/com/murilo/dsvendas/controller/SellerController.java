package com.murilo.dsvendas.controller;

import com.murilo.dsvendas.dto.SellerDTO;
import com.murilo.dsvendas.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    private SellerService service;

    @GetMapping
    public ResponseEntity<List<SellerDTO>> finAll() {
        List<SellerDTO> list = service.findAll();
        return  ResponseEntity.ok(list);
    }
}
