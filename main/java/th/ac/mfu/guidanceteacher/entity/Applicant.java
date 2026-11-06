package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: applicant   (used by: FR-11 to FR-14, FR-17, FR-29)
 * Students applying through a school. Contains personal data (PDPA): never log or expose national_id outside the owning school/admin.
 * TH: นักเรียนผู้สมัคร (ข้อมูลส่วนบุคคล PDPA: ห้ามโชว์ข้ามโรงเรียน)
 */
@Entity
@Table(name = "applicant", uniqueConstraints = {@UniqueConstraint(name = "uk_applicant_national_id_academic_year", columnNames = {"national_id", "academic_year"})})
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id", nullable = false)
    private Integer applicantId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    @Column(name = "national_id", nullable = false, length = 13)
    private String nationalId;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "academic_year", nullable = false)
    private Integer academicYear;

    @Column(name = "term", nullable = true, length = 20)
    private String term;

    public Applicant() { }

    public Integer getApplicantId() { return applicantId; }
    public void setApplicantId(Integer applicantId) { this.applicantId = applicantId; }

    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }

    public String getNationalId() { return nationalId; }
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Integer getAcademicYear() { return academicYear; }
    public void setAcademicYear(Integer academicYear) { this.academicYear = academicYear; }

    public String getTerm() { return term; }
    public void setTerm(String term) { this.term = term; }

}
