package th.ac.mfu.guidanceteacher.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import th.ac.mfu.guidanceteacher.entity.*;

public interface SubdistrictRepository extends JpaRepository<Subdistrict, Integer> {
    List<Subdistrict> findByDistrict_DistrictIdOrderByName(Integer districtId);
}
