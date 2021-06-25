package ir.maktab.data.repository;

import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Specialist;
import ir.maktab.data.domain.Users;
import ir.maktab.dto.FilterUsersDto;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.ArrayList;
import java.util.List;

public interface UserSpecification {
    static Specification<Users> filterUsers(FilterUsersDto dto) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            CriteriaQuery<Users> resultCriteria = criteriaBuilder.createQuery(Users.class);
            List<Predicate> predicates = new ArrayList<>();
            Subquery<Customer> customerSubquery = resultCriteria.subquery(Customer.class);
            Subquery<Specialist> specialistSubquery = resultCriteria.subquery(Specialist.class);
            Root<Specialist> specialistRoot = specialistSubquery.from(Specialist.class);
            Root<Customer> customerRoot = customerSubquery.from(Customer.class);
            Predicate customerPredicate = criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            Predicate specialistPredicate = criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            Subquery<Customer> customerSelect = customerSubquery.select(customerRoot.get("id"));
            Subquery<Specialist> expertSelect = specialistSubquery .select(specialistRoot.get("id"));
            if (dto.getName() != null) {
                predicates.add(criteriaBuilder.equal(root.get("name"), dto.getName()));
            }
            if (dto.getLastName() != null) {
                predicates.add(criteriaBuilder.equal(root.get("lastName"), dto.getLastName()));
            }

            if (dto.getRole() != null) {
                predicates.add(criteriaBuilder.equal(root.get("userRole"), dto.getRole()));
            }
            if (dto.getMaxDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("date"), dto.getMaxDate()));
            }
            if (dto.getMinDate() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("date"), dto.getMinDate()));
            }
            if (dto.getMaxNumberOfOrder()!=null){
                customerPredicate=criteriaBuilder.and(
                        customerPredicate,criteriaBuilder.lessThanOrEqualTo(criteriaBuilder.size(customerRoot.get("orders")),dto.getMaxNumberOfOrder()));

            }if (dto.getMinNumberOfOrder()!=null){
                customerPredicate=criteriaBuilder.and(customerPredicate,criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.size(customerRoot.get("orders")),dto.getMinNumberOfOrder()));
            }if (dto.getMaxNumberOfOffer()!=null){
                specialistPredicate=criteriaBuilder.and(specialistPredicate,criteriaBuilder.lessThanOrEqualTo(criteriaBuilder.size(specialistRoot.get("offers")), dto.getMaxNumberOfOffer()));
            }
            if (dto.getMinNumberOfOffer() != null) {
                specialistPredicate=criteriaBuilder.and(specialistPredicate,criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.size(specialistRoot.get("offers")), dto.getMinNumberOfOffer()));
            }
            if (customerPredicate.getExpressions().size()>0){
                customerSelect.where(customerPredicate);
                predicates.add(root.get("id").in(customerSubquery));
            }
            if (specialistPredicate.getExpressions().size()>0){
                expertSelect.where(specialistPredicate);
                predicates.add(root.get("id").in(specialistSubquery));
            }
            resultCriteria.select(root).where(predicates.toArray(new Predicate[0]));
            return resultCriteria.getRestriction();

        };
    }


}
