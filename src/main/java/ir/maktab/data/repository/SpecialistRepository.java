package ir.maktab.data.repository;

import ir.maktab.data.domain.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist, Integer> {
//    @Query("UPDATE Specialist AS s SET s.rate = :rate WHERE s.id = :id")
//    void updateRate(@Param("id") Integer id, @Param("rate") Double rate);
    Optional<Specialist> findByEmail(String email);
//    @Query("UPDATE Specialist AS s SET s.wallet = :rate WHERE s.id = :id")
//    void updateWallet(@Param("id") Integer id, @Param("wallet") Double wallet);
}
