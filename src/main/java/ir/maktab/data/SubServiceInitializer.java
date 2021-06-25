package ir.maktab.data;

import ir.maktab.data.domain.Service;
import ir.maktab.data.domain.SubService;
import ir.maktab.data.repository.ServiceRepository;
import ir.maktab.data.repository.SubServiceRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component
public class SubServiceInitializer {
    private final ServiceRepository serviceRepository;
    private final SubServiceRepository subServiceRepository;

    public SubServiceInitializer(ServiceRepository serviceRepository, SubServiceRepository subServiceRepository) {
        this.serviceRepository = serviceRepository;
        this.subServiceRepository = subServiceRepository;
    }


    @PostConstruct
    public void insetData() {
        if (subServiceRepository.findAll().isEmpty()) {
            Service home_appliances = serviceRepository.findByName("Home Appliances");
            subServiceRepository.save(new SubService().setService(home_appliances).setName("Kitchen appliances"));
            subServiceRepository.save(new SubService().setService(home_appliances).setName("clothes Laundry"));
            subServiceRepository.save(new SubService().setService(home_appliances).setName("audio and video equipment"));
            Service cleaning_and_hygiene = serviceRepository.findByName("Cleaning and hygiene");
            subServiceRepository.save(new SubService().setService(cleaning_and_hygiene).setName("Cleaning"));
            subServiceRepository.save(new SubService().setService(cleaning_and_hygiene).setName("home spraying"));
            subServiceRepository.save(new SubService().setService(cleaning_and_hygiene).setName("carpet and upholstery"));
            subServiceRepository.save(new SubService().setService(cleaning_and_hygiene).setName("laundry and car wash"));
        }
    }
    @PreDestroy
    public void deleteData() {
        //subServiceRepository.deleteAll();
    }
}
