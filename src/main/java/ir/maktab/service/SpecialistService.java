package ir.maktab.service;

import ir.maktab.data.domain.SubService;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.exception.DuplicatedEmailAddressException;
import ir.maktab.service.exception.InvalidPasswordException;
import ir.maktab.service.exception.NotFoundSpecialistException;
import ir.maktab.service.exception.NotFoundSubServiceException;


import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface SpecialistService {
    SpecialistDto saveNewSpecialist(SpecialistDto expert) throws DuplicatedEmailAddressException;

    void updateSpecialistRate(SpecialistDto specialistDto, Double rate);

    void changePassword(SpecialistDto dto);

    SpecialistDto findByEmail(String email) throws NotFoundSpecialistException;

    SpecialistDto loginSpecialist(SpecialistDto dto) throws NotFoundSpecialistException, InvalidPasswordException;

    List<SpecialistDto> fetchAllSpecialist();

    void updateSpecialist(SpecialistDto specialistDto);

    void selectService(SpecialistDto dto);

    void selectServiceForSpecialist(SubServiceDto service, SpecialistDto specialistDto);
    void updateSpecialistWallet(SpecialistDto toSpecialistDto, Double wallet);
}
