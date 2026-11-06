package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: applicant_status   (used by: FR-14, FR-17)
 * Status code lookup for applications (assigned codes, not auto increment).
 * TH: รหัสสถานะผู้สมัคร (กำหนดรหัสเอง เช่น 10, 20, 40)
 */
@Entity
@Table(name = "applicant_status")
public class ApplicantStatus {

    @Id
    @Column(name = "status_code", nullable = false)
    private Integer statusCode;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    public ApplicantStatus() { }

    public Integer getStatusCode() { return statusCode; }
    public void setStatusCode(Integer statusCode) { this.statusCode = statusCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}
