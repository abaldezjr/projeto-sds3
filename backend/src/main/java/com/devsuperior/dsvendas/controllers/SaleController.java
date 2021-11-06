package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDto;
import com.devsuperior.dsvendas.dto.SaleSucessDto;
import com.devsuperior.dsvendas.dto.SaleSumDto;
import com.devsuperior.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<Page<SaleDto>> findAll(Pageable pageable){
		Page<SaleDto> saleDto = saleService.findAll(pageable);
		return ResponseEntity.ok(saleDto);
	}
	
	@GetMapping("/amount-by-seller")
	public ResponseEntity<List<SaleSumDto>> amountGroupedBySeller(){
		List<SaleSumDto> saleSumDto = saleService.amountGroupedBySeller();
		return ResponseEntity.ok(saleSumDto);
	}
	
	@GetMapping("/sucess-by-seller")
	public ResponseEntity<List<SaleSucessDto>> sucessGroupedBySeller(){
		List<SaleSucessDto> saleSucessDto = saleService.sucessGroupedBySeller();
		return ResponseEntity.ok(saleSucessDto);
	}

}
