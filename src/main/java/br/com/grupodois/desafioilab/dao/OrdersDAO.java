package br.com.grupodois.desafioilab.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.grupodois.desafioilab.model.Orders;

public interface OrdersDAO extends PagingAndSortingRepository<Orders, Integer> {
    
  public List<Orders> findByOrderStatus(String status, Pageable p);

}
