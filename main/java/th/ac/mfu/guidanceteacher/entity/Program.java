package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: program   (used by: FR-09, FR-12, FR-13, FR-17, FR-25, FR-27)
 * Degree programs open for application in a given admission round. Open/closed status is derived from the round dates, not stored.
 * TH: ตารางใหม่: หลักสูตรที่เปิดรับในแต่ละรอบ สถานะ open/opening soon/closed คำนวณจากวันของ entrygroup ไม่เก็บคอลัมน์
 */
@Entity
@Table(name = "program", uniqueConstraints = {@UniqueConstraint(name = "uk_program_entrygroup_id_program_name", columnNames = {"entrygroup_id", "program_name"})})
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id", nullable = false)
    private Integer programId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entrygroup_id", nullable = false)
    private EntryGroup entrygroup;

    @Column(name = "program_name", nullable = false, length = 200)
    private String programName;

    @Column(name = "faculty", nullable = false, length = 150)
    private String faculty;

    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;

    public Program() { }

    public Integer getProgramId() { return programId; }
    public void setProgramId(Integer programId) { this.programId = programId; }

    public EntryGroup getEntrygroup() { return entrygroup; }
    public void setEntrygroup(EntryGroup entrygroup) { this.entrygroup = entrygroup; }

    public String getProgramName() { return programName; }
    public void setProgramName(String programName) { this.programName = programName; }

    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}
