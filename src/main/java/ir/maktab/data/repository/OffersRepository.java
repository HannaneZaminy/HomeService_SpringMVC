package ir.maktab.data.repository;

import ir.maktab.data.domain.Offer;
import ir.maktab.data.domain.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OffersRepository extends JpaRepository<Offer, Integer>, JpaSpecificationExecutor<Offer> {

    Optional<Offer> findByOrders(CustomerOrder order);

}
