package net.janaite.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.janaite.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
