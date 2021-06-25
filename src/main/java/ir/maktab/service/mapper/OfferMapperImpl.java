package ir.maktab.service.mapper;

import ir.maktab.data.domain.Offer;
import ir.maktab.dto.OfferDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OfferMapperImpl implements OfferMapper {
    private SpecialistMapper specialistMapper;
    private  OrderMapper orderMapper;

    public SpecialistMapper getSpecialistMapper() {
        return specialistMapper;
    }
    @Autowired
    public void setSpecialistMapper(SpecialistMapper specialistMapper) {
        this.specialistMapper = specialistMapper;
    }

    public OrderMapper getOrderMapper() {
        return orderMapper;
    }


    @Autowired
    public void setOrderMapper( OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public Offer toOffer(OfferDto dto) {
        Offer offer = new Offer();
        offer.setId(dto.getId());
        offer.setOfferPrice(dto.getOfferPrice());
        offer.setSubmitOffer(dto.getSubmitOffer());

        offer.setDurationOfWork(dto.getDurationOfWork());
        offer.setStartTime(dto.getStartTime());
        offer.setOfferSituation(dto.getOfferStatus());
        offer.setSpecialist(specialistMapper.toSpecialist(dto.getSpecialistDto()));
        offer.setOrders(orderMapper.toOrder(dto.getOrders()));
        return offer;
    }

    @Override
    public OfferDto toOfferDto(Offer offer) {
        OfferDto dto = new OfferDto();
        dto.setDurationOfWork(offer.getDurationOfWork());
        dto.setId(offer.getId());
        dto.setStartTime(offer.getStartTime());
        dto.setSpecialistDto(specialistMapper.toSpecialistDto(offer.getSpecialist()));

        dto.setSubmitOffer(offer.getSubmitOffer());

        dto.setOrders(orderMapper.toOrderDto(offer.getOrders()));
        dto.setOfferStatus(offer.getOfferSituation());
        dto.setOfferPrice(offer.getOfferPrice());
        return dto;
    }
}
