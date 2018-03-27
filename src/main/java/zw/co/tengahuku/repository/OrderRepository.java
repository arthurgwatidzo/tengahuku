package zw.co.tengahuku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zw.co.tengahuku.model.Order;

@Repository("orderRepository")
public interface OrderRepository  extends JpaRepository<Order,Long>{

}
