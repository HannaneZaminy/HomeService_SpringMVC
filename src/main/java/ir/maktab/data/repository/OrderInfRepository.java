package ir.maktab.data.repository;

import ir.maktab.data.domain.OrderInf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInfRepository extends JpaRepository<OrderInf, Integer> {
}
