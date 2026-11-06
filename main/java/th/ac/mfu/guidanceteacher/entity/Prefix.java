package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: prefix   (used by: FR-03, FR-16)
 * Name prefixes (Mr., Mrs., Dr. ...).
 * TH: คำนำหน้าชื่อ
 */
@Entity
@Table(name = "prefix")
public class Prefix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prefix_id", nullable = false)
    private Integer prefixId;

    @Column(name = "prefix_name", nullable = false, length = 50, unique = true)
    private String prefixName;

    public Prefix() { }

    public Integer getPrefixId() { return prefixId; }
    public void setPrefixId(Integer prefixId) { this.prefixId = prefixId; }

    public String getPrefixName() { return prefixName; }
    public void setPrefixName(String prefixName) { this.prefixName = prefixName; }

}
