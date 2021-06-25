package ir.maktab.service.mapper;

import ir.maktab.data.domain.Offer;
import ir.maktab.dto.OfferDto;

public interface OfferMapper {
    Offer toOffer(OfferDto dto);

    OfferDto toOfferDto(Offer offer);

}
