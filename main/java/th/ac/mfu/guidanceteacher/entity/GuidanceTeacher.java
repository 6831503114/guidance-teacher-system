package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: guidance_teacher   (used by: FR-01 to FR-07, FR-15, FR-16, FR-18, FR-28)
 * Guidance teacher account. One school can have only one account.
 * TH: บัญชีครูแนะแนว 1 โรงเรียน = 1 บัญชี (school_id เป็น UNIQUE) สถานะ Active/Pending คำนวณจาก is_email_verified + pdpa_consent ไม่ต้องเก็บคอลัมน์
 */
@Entity
@Table(name = "guidance_teacher")
public class GuidanceTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", nullable = false)
    private Integer teacherId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "school_id", nullable = false, unique = true)
    private School school;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prefix_id", nullable = false)
    private Prefix prefix;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "position_title", nullable = true, length = 100)
    private String positionTitle;

    @Column(name = "phone", nullable = true, length = 20)
    private String phone;

    @Column(name = "email", nullable = false, length = 150, unique = true)
    private String email;

    @Column(name = "username", nullable = true, length = 50, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = true, length = 100)
    private String passwordHash;

    @Column(name = "pdpa_consent", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean pdpaConsent = false;

    @Column(name = "is_email_verified", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean emailVerified = false;

    @Column(name = "thaid_sub", nullable = true, length = 100)
    private String thaidSub;

    @Column(name = "registered_at", nullable = false)
    private LocalDate registeredAt;

    @Column(name = "active_academic_year", nullable = true)
    private Integer activeAcademicYear;

    public GuidanceTeacher() { }

    public Integer getTeacherId() { return teacherId; }
    public void setTeacherId(Integer teacherId) { this.teacherId = teacherId; }

    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }

    public Prefix getPrefix() { return prefix; }
    public void setPrefix(Prefix prefix) { this.prefix = prefix; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPositionTitle() { return positionTitle; }
    public void setPositionTitle(String positionTitle) { this.positionTitle = positionTitle; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public Boolean getPdpaConsent() { return pdpaConsent; }
    public void setPdpaConsent(Boolean pdpaConsent) { this.pdpaConsent = pdpaConsent; }

    public Boolean getEmailVerified() { return emailVerified; }
    public void setEmailVerified(Boolean emailVerified) { this.emailVerified = emailVerified; }

    public String getThaidSub() { return thaidSub; }
    public void setThaidSub(String thaidSub) { this.thaidSub = thaidSub; }

    public LocalDate getRegisteredAt() { return registeredAt; }
    public void setRegisteredAt(LocalDate registeredAt) { this.registeredAt = registeredAt; }

    public Integer getActiveAcademicYear() { return activeAcademicYear; }
    public void setActiveAcademicYear(Integer activeAcademicYear) { this.activeAcademicYear = activeAcademicYear; }

}
