package ir.maktab.data;


import ir.maktab.data.domain.Service;
import ir.maktab.data.domain.SubService;
import ir.maktab.data.repository.ServiceRepository;
import ir.maktab.data.repository.SubServiceRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ServiceInitializer {

    private final ServiceRepository serviceRepository;
    private final SubServiceRepository subServiceRepository;

    public ServiceInitializer(ServiceRepository serviceRepository, SubServiceRepository subServiceRepository) {
        this.serviceRepository = serviceRepository;
        this.subServiceRepository = subServiceRepository;
    }


    @PostConstruct
    public void insetData() {
        if (serviceRepository.findAll().isEmpty()) {
            serviceRepository.save(new Service().setName("Home Appliances"));
            serviceRepository.save(new Service().setName("Building decoration"));
            serviceRepository.save(new Service().setName("building installations"));
            serviceRepository.save(new Service().setName("vehicles"));
            serviceRepository.save(new Service().setName("furniture and cargo"));
            serviceRepository.save(new Service().setName("Cleaning and hygiene"));
        }
    }
    @PreDestroy
    public void deleteData() {
        //serviceRepository.deleteAll();
    }
}
