package th.ac.mfu.guidanceteacher.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import th.ac.mfu.guidanceteacher.entity.*;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("select p from Post p where p.hidden = false and p.visibleStartDate <= :today and p.visibleEndDate >= :today order by p.publishedAt desc")
    List<Post> findVisible(@Param("today") LocalDate today);
}
