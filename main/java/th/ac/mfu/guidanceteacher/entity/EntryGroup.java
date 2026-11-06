package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: entrygroup   (used by: FR-09, FR-10, FR-22)
 * Admission rounds (e.g. Quota, Portfolio) with the calendar dates.
 * TH: รอบรับสมัคร + วันสำคัญสำหรับปฏิทิน
 */
@Entity
@Table(name = "entrygroup", uniqueConstraints = {@UniqueConstraint(name = "uk_entrygroup_academic_year_entrygroup_name", columnNames = {"academic_year", "entrygroup_name"})})
public class EntryGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrygroup_id", nullable = false)
    private Integer entrygroupId;

    @Column(name = "academic_year", nullable = false)
    private Integer academicYear;

    @Column(name = "entrygroup_name", nullable = false, length = 100)
    private String entrygroupName;

    @Column(name = "apply_start_date", nullable = false)
    private LocalDate applyStartDate;

    @Column(name = "apply_end_date", nullable = false)
    private LocalDate applyEndDate;

    @Column(name = "result_announce_date", nullable = true)
    private LocalDate resultAnnounceDate;

    @Column(name = "rights_confirm_date", nullable = true)
    private LocalDate rightsConfirmDate;

    public EntryGroup() { }

    public Integer getEntrygroupId() { return entrygroupId; }
    public void setEntrygroupId(Integer entrygroupId) { this.entrygroupId = entrygroupId; }

    public Integer getAcademicYear() { return academicYear; }
    public void setAcademicYear(Integer academicYear) { this.academicYear = academicYear; }

    public String getEntrygroupName() { return entrygroupName; }
    public void setEntrygroupName(String entrygroupName) { this.entrygroupName = entrygroupName; }

    public LocalDate getApplyStartDate() { return applyStartDate; }
    public void setApplyStartDate(LocalDate applyStartDate) { this.applyStartDate = applyStartDate; }

    public LocalDate getApplyEndDate() { return applyEndDate; }
    public void setApplyEndDate(LocalDate applyEndDate) { this.applyEndDate = applyEndDate; }

    public LocalDate getResultAnnounceDate() { return resultAnnounceDate; }
    public void setResultAnnounceDate(LocalDate resultAnnounceDate) { this.resultAnnounceDate = resultAnnounceDate; }

    public LocalDate getRightsConfirmDate() { return rightsConfirmDate; }
    public void setRightsConfirmDate(LocalDate rightsConfirmDate) { this.rightsConfirmDate = rightsConfirmDate; }

}
