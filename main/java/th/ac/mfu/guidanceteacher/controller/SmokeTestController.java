package th.ac.mfu.guidanceteacher.controller;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import th.ac.mfu.guidanceteacher.repository.ApplicantRepository;
import th.ac.mfu.guidanceteacher.repository.PostRepository;
import th.ac.mfu.guidanceteacher.repository.ProvinceRepository;
import th.ac.mfu.guidanceteacher.repository.SchoolRepository;

/**
 * Smoke test: open http://localhost:8080/health
 * If you see numbers, the app started, the tables exist and data.sql was loaded.
 * You can delete this class once real pages exist.
 */
@RestController
public class SmokeTestController {

    private final ProvinceRepository provinces;
    private final SchoolRepository schools;
    private final ApplicantRepository applicants;
    private final PostRepository posts;

    public SmokeTestController(ProvinceRepository provinces, SchoolRepository schools,
                               ApplicantRepository applicants, PostRepository posts) {
        this.provinces = provinces;
        this.schools = schools;
        this.applicants = applicants;
        this.posts = posts;
    }

    @GetMapping("/health")
    public String health() {
        return "Guidance Teacher System is running. provinces=" + provinces.count()
                + ", schools=" + schools.count()
                + ", applicants=" + applicants.count()
                + ", visiblePostsToday=" + posts.findVisible(LocalDate.now()).size();
    }
}
