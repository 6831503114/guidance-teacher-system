package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: school   (used by: FR-02, FR-03, FR-15, FR-26, FR-28)
 * High schools in the MFU network. Location is stored only as SUBDISTRICT (province/district/zipcode are derived by joins).
 * TH: โรงเรียน เก็บที่อยู่เป็น subdistrict_id อย่างเดียว (จังหวัด/อำเภอ/ไปรษณีย์ดึงด้วย join) เพื่อให้ผ่าน 3NF
 */
@Entity
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id", nullable = false)
    private Integer schoolId;

    @Column(name = "school_code", nullable = false, length = 10, unique = true)
    private String schoolCode;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "school_type", nullable = true, length = 50)
    private String schoolType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subdistrict_id", nullable = false)
    private Subdistrict subdistrict;

    public School() { }

    public Integer getSchoolId() { return schoolId; }
    public void setSchoolId(Integer schoolId) { this.schoolId = schoolId; }

    public String getSchoolCode() { return schoolCode; }
    public void setSchoolCode(String schoolCode) { this.schoolCode = schoolCode; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSchoolType() { return schoolType; }
    public void setSchoolType(String schoolType) { this.schoolType = schoolType; }

    public Subdistrict getSubdistrict() { return subdistrict; }
    public void setSubdistrict(Subdistrict subdistrict) { this.subdistrict = subdistrict; }

}
