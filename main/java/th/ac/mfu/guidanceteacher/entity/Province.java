package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: province   (used by: FR-02, FR-03, FR-26, FR-27)
 * Thai provinces. Parent of DISTRICT.
 * TH: ตารางจังหวัด (ข้อมูลอ้างอิง โหลดมาครั้งเดียว) ใช้ทำ dropdown จังหวัดตอนสมัคร/ลืมรหัสผ่าน
 */
@Entity
@Table(name = "province")
public class Province {

    @Id
    @Column(name = "province_id", nullable = false)
    private Integer provinceId;

    @Column(name = "name", nullable = false, length = 100, unique = true)
    private String name;

    @Column(name = "region", nullable = true, length = 30)
    private String region;

    public Province() { }

    public Integer getProvinceId() { return provinceId; }
    public void setProvinceId(Integer provinceId) { this.provinceId = provinceId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

}
