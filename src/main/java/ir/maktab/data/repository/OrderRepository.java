package ir.maktab.data.repository;

import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Specialist;
import ir.maktab.data.domain.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Integer>, JpaSpecificationExecutor<CustomerOrder> {
    List<CustomerOrder> findByCustomer(Customer customer);

    List<CustomerOrder> findBySpecialist(Specialist specialist);




}
