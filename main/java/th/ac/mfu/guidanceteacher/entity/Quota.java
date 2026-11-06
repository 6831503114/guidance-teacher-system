package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: quota   (used by: FR-12 to FR-14)
 * Admission quota categories.
 * TH: ประเภทโควตา
 */
@Entity
@Table(name = "quota")
public class Quota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quota_id", nullable = false)
    private Integer quotaId;

    @Column(name = "quota_name", nullable = false, length = 150)
    private String quotaName;

    @Column(name = "faculty", nullable = false, length = 150)
    private String faculty;

    public Quota() { }

    public Integer getQuotaId() { return quotaId; }
    public void setQuotaId(Integer quotaId) { this.quotaId = quotaId; }

    public String getQuotaName() { return quotaName; }
    public void setQuotaName(String quotaName) { this.quotaName = quotaName; }

    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }

}
