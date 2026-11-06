package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: result_dataset   (used by: FR-24 + result upload (Business Scope))
 * One uploaded selection-result file per program, with validation summary. Read-only for admins after upload.
 * TH: ตารางใหม่: ไฟล์ผลคัดเลือกที่ admin อัปโหลด เก็บจำนวนแถวทั้งหมด/แถวที่ผิด/สถานะ
 */
@Entity
@Table(name = "result_dataset")
public class ResultDataset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dataset_id", nullable = false)
    private Integer datasetId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @Column(name = "file_name", nullable = false, length = 255)
    private String fileName;

    @Column(name = "uploaded_at", nullable = false)
    private LocalDateTime uploadedAt;

    @Column(name = "total_rows", nullable = false)
    private Integer totalRows = 0;

    @Column(name = "error_rows", nullable = false)
    private Integer errorRows = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "dataset_status", nullable = false, length = 20)
    private DatasetStatus datasetStatus;

    @Column(name = "error_summary", nullable = true, columnDefinition = "TEXT")
    private String errorSummary;

    public ResultDataset() { }

    public Integer getDatasetId() { return datasetId; }
    public void setDatasetId(Integer datasetId) { this.datasetId = datasetId; }

    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }

    public Program getProgram() { return program; }
    public void setProgram(Program program) { this.program = program; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }

    public Integer getTotalRows() { return totalRows; }
    public void setTotalRows(Integer totalRows) { this.totalRows = totalRows; }

    public Integer getErrorRows() { return errorRows; }
    public void setErrorRows(Integer errorRows) { this.errorRows = errorRows; }

    public DatasetStatus getDatasetStatus() { return datasetStatus; }
    public void setDatasetStatus(DatasetStatus datasetStatus) { this.datasetStatus = datasetStatus; }

    public String getErrorSummary() { return errorSummary; }
    public void setErrorSummary(String errorSummary) { this.errorSummary = errorSummary; }

}
