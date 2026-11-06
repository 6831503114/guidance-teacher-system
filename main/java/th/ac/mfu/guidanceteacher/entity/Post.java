package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: post   (used by: FR-08, FR-10, FR-21, FR-22, FR-23)
 * News, PR and announcements. Event location is one optional SUBDISTRICT.
 * TH: ข่าว/PR/ประกาศ ที่อยู่งานเก็บเป็น subdistrict_id เดียว (เดิมเป็นรหัสแยก 4 ช่องเป็น string ไม่มี FK) การซ่อนประกาศหมดอายุใช้เงื่อนไข visible_end_date ใน query
 */
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Integer postId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "subdistrict_id", nullable = true)
    private Subdistrict subdistrict;

    @Column(name = "building_name", nullable = true, length = 150)
    private String buildingName;

    @Column(name = "event_start_date", nullable = true)
    private LocalDate eventStartDate;

    @Column(name = "event_end_date", nullable = true)
    private LocalDate eventEndDate;

    @Column(name = "visible_start_date", nullable = false)
    private LocalDate visibleStartDate;

    @Column(name = "visible_end_date", nullable = false)
    private LocalDate visibleEndDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_type", nullable = false, length = 20)
    private PostType postType;

    @Column(name = "published_at", nullable = true)
    private LocalDateTime publishedAt;

    @Column(name = "is_hidden", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean hidden = false;

    public Post() { }

    public Integer getPostId() { return postId; }
    public void setPostId(Integer postId) { this.postId = postId; }

    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Subdistrict getSubdistrict() { return subdistrict; }
    public void setSubdistrict(Subdistrict subdistrict) { this.subdistrict = subdistrict; }

    public String getBuildingName() { return buildingName; }
    public void setBuildingName(String buildingName) { this.buildingName = buildingName; }

    public LocalDate getEventStartDate() { return eventStartDate; }
    public void setEventStartDate(LocalDate eventStartDate) { this.eventStartDate = eventStartDate; }

    public LocalDate getEventEndDate() { return eventEndDate; }
    public void setEventEndDate(LocalDate eventEndDate) { this.eventEndDate = eventEndDate; }

    public LocalDate getVisibleStartDate() { return visibleStartDate; }
    public void setVisibleStartDate(LocalDate visibleStartDate) { this.visibleStartDate = visibleStartDate; }

    public LocalDate getVisibleEndDate() { return visibleEndDate; }
    public void setVisibleEndDate(LocalDate visibleEndDate) { this.visibleEndDate = visibleEndDate; }

    public PostType getPostType() { return postType; }
    public void setPostType(PostType postType) { this.postType = postType; }

    public LocalDateTime getPublishedAt() { return publishedAt; }
    public void setPublishedAt(LocalDateTime publishedAt) { this.publishedAt = publishedAt; }

    public Boolean getHidden() { return hidden; }
    public void setHidden(Boolean hidden) { this.hidden = hidden; }

}
