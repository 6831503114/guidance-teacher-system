package th.ac.mfu.guidanceteacher.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import th.ac.mfu.guidanceteacher.entity.*;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
    List<Applicant> findBySchool_SchoolId(Integer schoolId);
}
