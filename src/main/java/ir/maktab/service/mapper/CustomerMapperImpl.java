package ir.maktab.service.mapper;

import ir.maktab.data.domain.Customer;
import ir.maktab.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {


    @Override
    public Customer toCustomer(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setDate(dto.getRegistrationDay());
        customer.setWallet(dto.getWallet());
        customer.setEmail(dto.getEmail());
        customer.setPassword(dto.getPassword());
        customer.setLastName(dto.getLastName());

        customer.setRole(dto.getRole());
        customer.setSituation(dto.getSituation());


        return customer;
    }

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setPassword(customer.getPassword());
        dto.setRegistrationDay(customer.getDate());
        dto.setName(customer.getName());
        dto.setSituation(customer.getSituation());
        dto.setWallet(customer.getWallet());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());

        dto.setRole(customer.getRole());

        return dto;
    }
}
