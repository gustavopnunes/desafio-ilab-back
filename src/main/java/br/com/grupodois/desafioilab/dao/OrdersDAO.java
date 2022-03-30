package br.com.grupodois.desafioilab.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.grupodois.desafioilab.model.Orders;

public interface OrdersDAO extends PagingAndSortingRepository<Orders, Number> {
    
  public List<Orders> findAllByOrderStatus(String status, Pageable p);
  public Orders findById(Long id); 

}
