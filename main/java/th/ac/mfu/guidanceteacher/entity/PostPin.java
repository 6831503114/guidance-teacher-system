package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: post_pin   (used by: FR-08)
 * A post pinned by a teacher; pinned posts are shown first.
 * TH: ตารางใหม่: ข่าวที่ครูกด pin (ข่าวที่ pin แสดงก่อน)
 */
@Entity
@Table(name = "post_pin", uniqueConstraints = {@UniqueConstraint(name = "uk_post_pin_teacher_id_post_id", columnNames = {"teacher_id", "post_id"})})
public class PostPin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pin_id", nullable = false)
    private Integer pinId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher_id", nullable = false)
    private GuidanceTeacher teacher;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(name = "pinned_at", nullable = false)
    private LocalDateTime pinnedAt;

    public PostPin() { }

    public Integer getPinId() { return pinId; }
    public void setPinId(Integer pinId) { this.pinId = pinId; }

    public GuidanceTeacher getTeacher() { return teacher; }
    public void setTeacher(GuidanceTeacher teacher) { this.teacher = teacher; }

    public Post getPost() { return post; }
    public void setPost(Post post) { this.post = post; }

    public LocalDateTime getPinnedAt() { return pinnedAt; }
    public void setPinnedAt(LocalDateTime pinnedAt) { this.pinnedAt = pinnedAt; }

}
