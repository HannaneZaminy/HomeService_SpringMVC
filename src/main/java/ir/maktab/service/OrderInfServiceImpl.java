package ir.maktab.service;

import ir.maktab.data.repository.OrderInfRepository;
import ir.maktab.dto.OrderInfDto;
import ir.maktab.service.mapper.OrderInfMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderInfServiceImpl implements OrderInfoService {
    private final OrderInfRepository repository;
    private final OrderInfMapper infMapper;

    public OrderInfServiceImpl(OrderInfRepository repository, OrderInfMapper infMapper) {
        this.repository = repository;
        this.infMapper = infMapper;
    }

    @Override
    public void save(OrderInfDto dto) {
        repository.save(infMapper.toOrderInf(dto));
    }
}
