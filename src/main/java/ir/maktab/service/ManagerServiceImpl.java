package ir.maktab.service;

import ir.maktab.data.domain.Manager;
import ir.maktab.data.repository.ManagerRepository;
import ir.maktab.dto.ManagerDto;
import ir.maktab.service.exception.InvalidPasswordException;
import ir.maktab.service.exception.NotFoundManagerException;
import ir.maktab.service.mapper.ManagerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;

    public ManagerServiceImpl(ManagerRepository managerRepository, ManagerMapper managerMapper) {
        this.managerRepository = managerRepository;
        this.managerMapper = managerMapper;
    }

    @Override
    public void saveNewManager(ManagerDto dto) {
        managerRepository.save(managerMapper.toManager(dto));
    }

    @Override
    public void deleteManager(ManagerDto dto) {
        managerRepository.delete(managerMapper.toManager(dto));
    }

    @Override
    public void updateManager(ManagerDto dto) {
        managerRepository.save(managerMapper.toManager(dto));
    }

    @Override
    public List<ManagerDto> fetchAllManagers() {
        return managerRepository.findAll()
                .stream().map(managerMapper::toManagerDto)
                .collect(Collectors.toList());
    }

    @Override
    public ManagerDto findByUserName(String userName) {
        Optional<Manager> manager = managerRepository.findByUserName(userName);
        if (manager.isPresent()) {
            return managerMapper.toManagerDto(manager.get());
        }
        return null;
    }

    @Override
    public ManagerDto loginManager(ManagerDto dto) throws NotFoundManagerException, InvalidPasswordException {
        Optional<Manager> manager = managerRepository.findByUserName(dto.getUserName());
        if (manager.isPresent()) {
            if ( manager.get().getPassword().equals(dto.getPassword())) {
                return managerMapper.toManagerDto( manager.get());
            } else {
                throw new InvalidPasswordException("Password Is Incorrect ! Please Try Again...");
            }
        } else {
            throw new NotFoundManagerException("This manager Is Not Available ! Please Try Again...");
        }
    }
}

