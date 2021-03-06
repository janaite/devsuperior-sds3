package net.janaite.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.janaite.dsvendas.dto.SaleDTO;
import net.janaite.dsvendas.dto.SaleSuccessDTO;
import net.janaite.dsvendas.dto.SaleSumDTO;
import net.janaite.dsvendas.entities.Sale;
import net.janaite.dsvendas.repositories.SaleRepository;
import net.janaite.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true)	// No database locks please!
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySaller() {
		return repository.amountGroupedBySaller();
	}

	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySaller() {
		return repository.sucessGroupedBySaller();
	}
}
