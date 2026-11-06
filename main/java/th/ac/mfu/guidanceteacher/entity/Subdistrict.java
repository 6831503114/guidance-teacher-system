package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: subdistrict   (used by: FR-03)
 * Subdistricts inside a district; also owns the postal code.
 * TH: ตารางตำบล เก็บรหัสไปรษณีย์ไว้ที่นี่ที่เดียว
 */
@Entity
@Table(name = "subdistrict")
public class Subdistrict {

    @Id
    @Column(name = "subdistrict_id", nullable = false)
    private Integer subdistrictId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "zipcode", nullable = false, length = 5)
    private String zipcode;

    public Subdistrict() { }

    public Integer getSubdistrictId() { return subdistrictId; }
    public void setSubdistrictId(Integer subdistrictId) { this.subdistrictId = subdistrictId; }

    public District getDistrict() { return district; }
    public void setDistrict(District district) { this.district = district; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getZipcode() { return zipcode; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

}
