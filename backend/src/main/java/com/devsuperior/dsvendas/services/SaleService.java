package com.devsuperior.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDto;
import com.devsuperior.dsvendas.dto.SaleSucessDto;
import com.devsuperior.dsvendas.dto.SaleSumDto;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
	@Transactional(readOnly = true)
	public Page<SaleDto> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> sales =  saleRepository.findAll(pageable);
		return sales.map(x -> new SaleDto(x));
	}
	
	@Transactional
	public List<SaleSumDto> amountGroupedBySeller(){
		return saleRepository.amountGroupedBySeller();
	}
	
	@Transactional
	public List<SaleSucessDto> sucessGroupedBySeller(){
		return saleRepository.sucessGroupedBySeller();
	}

}
