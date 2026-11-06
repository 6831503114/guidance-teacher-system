package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: district   (used by: FR-03)
 * Districts inside a province.
 * TH: ตารางอำเภอ
 */
@Entity
@Table(name = "district")
public class District {

    @Id
    @Column(name = "district_id", nullable = false)
    private Integer districtId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "province_id", nullable = false)
    private Province province;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    public District() { }

    public Integer getDistrictId() { return districtId; }
    public void setDistrictId(Integer districtId) { this.districtId = districtId; }

    public Province getProvince() { return province; }
    public void setProvince(Province province) { this.province = province; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}
