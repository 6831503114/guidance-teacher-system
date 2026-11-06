package th.ac.mfu.guidanceteacher.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Table: post_registration   (used by: FR-08, FR-21)
 * A teacher registering to attend a post/event.
 * TH: ครูลงทะเบียนเข้าร่วมงานตามประกาศ (1 ครู ลงได้ครั้งเดียวต่อโพสต์)
 */
@Entity
@Table(name = "post_registration", uniqueConstraints = {@UniqueConstraint(name = "uk_post_registration_post_id_teacher_id", columnNames = {"post_id", "teacher_id"})})
public class PostRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id", nullable = false)
    private Integer registrationId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher_id", nullable = false)
    private GuidanceTeacher teacher;

    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;

    public PostRegistration() { }

    public Integer getRegistrationId() { return registrationId; }
    public void setRegistrationId(Integer registrationId) { this.registrationId = registrationId; }

    public Post getPost() { return post; }
    public void setPost(Post post) { this.post = post; }

    public GuidanceTeacher getTeacher() { return teacher; }
    public void setTeacher(GuidanceTeacher teacher) { this.teacher = teacher; }

    public LocalDateTime getRegisteredAt() { return registeredAt; }
    public void setRegisteredAt(LocalDateTime registeredAt) { this.registeredAt = registeredAt; }

}
