package th.ac.mfu.guidanceteacher.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import th.ac.mfu.guidanceteacher.entity.*;

public interface ApplicantSelectionRepository extends JpaRepository<ApplicantSelection, Integer> {
    List<ApplicantSelection> findByApplicant_School_SchoolId(Integer schoolId);
    long countByApplicant_School_SchoolId(Integer schoolId);
}
