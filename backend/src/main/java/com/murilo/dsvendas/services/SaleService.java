package com.murilo.dsvendas.services;

import com.murilo.dsvendas.dto.SaleDTO;
import com.murilo.dsvendas.entities.Sale;
import com.murilo.dsvendas.repository.SaleRepository;
import com.murilo.dsvendas.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> result = repository.findAll(pageable);
        //return result.stream().map(x -> new SaleDTO(x)).collect(Collectors.toList());
        return result.map(SaleDTO::new);
    }
}
