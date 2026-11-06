package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: program_interest   (used by: FR-12, FR-13, FR-25, FR-27)
 * An applicant showing interest in a program. Daily counts of interested_at give the trend chart in FR-25.
 * TH: ตารางใหม่: นักเรียนสนใจหลักสูตรไหน เมื่อไหร่ ใช้ทำรายงาน FR-12/13 และกราฟแนวโน้มรายวัน FR-25
 */
@Entity
@Table(name = "program_interest", uniqueConstraints = {@UniqueConstraint(name = "uk_program_interest_applicant_id_program_id", columnNames = {"applicant_id", "program_id"})})
public class ProgramInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interest_id", nullable = false)
    private Integer interestId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "applicant_id", nullable = false)
    private Applicant applicant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @Column(name = "interested_at", nullable = false)
    private LocalDateTime interestedAt;

    public ProgramInterest() { }

    public Integer getInterestId() { return interestId; }
    public void setInterestId(Integer interestId) { this.interestId = interestId; }

    public Applicant getApplicant() { return applicant; }
    public void setApplicant(Applicant applicant) { this.applicant = applicant; }

    public Program getProgram() { return program; }
    public void setProgram(Program program) { this.program = program; }

    public LocalDateTime getInterestedAt() { return interestedAt; }
    public void setInterestedAt(LocalDateTime interestedAt) { this.interestedAt = interestedAt; }

}
