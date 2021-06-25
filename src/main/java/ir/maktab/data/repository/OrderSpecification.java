package ir.maktab.data.repository;

import ir.maktab.data.domain.CustomerOrder;
import ir.maktab.data.domain.Service;
import ir.maktab.data.domain.SubService;
import ir.maktab.dto.OrderFilterDto;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public interface OrderSpecification {

    static Specification<CustomerOrder> filterOrders(OrderFilterDto dto) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            CriteriaQuery<CustomerOrder> query = criteriaBuilder.createQuery(CustomerOrder.class);
            List<Predicate> predicates = new ArrayList<>();
            Join<CustomerOrder, SubService> subServiceJoin = root.join("subService");
            Join<SubService, Service> serviceJoin = subServiceJoin.join("service");

            if (dto.getOrderStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("situation"), dto.getOrderStatus()));
            }
            if (dto.getSubServiceName() != null) {
                predicates.add(criteriaBuilder.equal(subServiceJoin.get("name"), dto.getSubServiceName()));
            }
            if (dto.getServiceName() != null) {
                predicates.add(criteriaBuilder.equal(serviceJoin.get("name"), dto.getServiceName()));
            }
            if (dto.getMinDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dateOfOrderRegistration"), dto.getMinDate()));
            }
            if (dto.getMaxDate() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dateOfOrderRegistration"), dto.getMaxDate()));
            }
            query.select(root).where(predicates.toArray(new Predicate[0]));
            return query.getRestriction();


        };
    }
}
