package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: applicant_selection   (used by: FR-11 to FR-14, FR-17, FR-24, FR-29)
 * An application of one applicant to one admission round, program and quota, with its current status. (Called APPLICATION in the early SRS draft.)
 * TH: การสมัคร 1 ครั้ง = ผู้สมัคร + รอบ + หลักสูตร + โควตา + สถานะ (ตารางศูนย์กลางของรายงานทั้งหมด)
 */
@Entity
@Table(name = "applicant_selection", uniqueConstraints = {@UniqueConstraint(name = "uk_applicant_selection_applicant_id_entrygroup_id", columnNames = {"applicant_id", "entrygroup_id"})})
public class ApplicantSelection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id", nullable = false)
    private Integer applicationId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "applicant_id", nullable = false)
    private Applicant applicant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entrygroup_id", nullable = false)
    private EntryGroup entrygroup;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "quota_id", nullable = false)
    private Quota quota;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "status_code", nullable = false)
    private ApplicantStatus status;

    @Column(name = "applied_at", nullable = false)
    private LocalDate appliedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "admin_id", nullable = true)
    private Admin admin;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "dataset_id", nullable = true)
    private ResultDataset dataset;

    @Column(name = "published_at", nullable = true)
    private LocalDateTime publishedAt;

    public ApplicantSelection() { }

    public Integer getApplicationId() { return applicationId; }
    public void setApplicationId(Integer applicationId) { this.applicationId = applicationId; }

    public Applicant getApplicant() { return applicant; }
    public void setApplicant(Applicant applicant) { this.applicant = applicant; }

    public EntryGroup getEntrygroup() { return entrygroup; }
    public void setEntrygroup(EntryGroup entrygroup) { this.entrygroup = entrygroup; }

    public Quota getQuota() { return quota; }
    public void setQuota(Quota quota) { this.quota = quota; }

    public Program getProgram() { return program; }
    public void setProgram(Program program) { this.program = program; }

    public ApplicantStatus getStatus() { return status; }
    public void setStatus(ApplicantStatus status) { this.status = status; }

    public LocalDate getAppliedAt() { return appliedAt; }
    public void setAppliedAt(LocalDate appliedAt) { this.appliedAt = appliedAt; }

    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }

    public ResultDataset getDataset() { return dataset; }
    public void setDataset(ResultDataset dataset) { this.dataset = dataset; }

    public LocalDateTime getPublishedAt() { return publishedAt; }
    public void setPublishedAt(LocalDateTime publishedAt) { this.publishedAt = publishedAt; }

}
