package mandooparty.mandoo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import mandooparty.mandoo.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@Table(name = "commentReport")
public class CommentReport extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer commentReportCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;          // 작성자 (Member와 연관 관계 설정)


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentId", nullable = false)
    private Comment comment;        // 댓글(comment)와의 관계
}
