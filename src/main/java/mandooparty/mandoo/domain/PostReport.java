package mandooparty.mandoo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import mandooparty.mandoo.domain.common.BaseEntity;

@Entity
@Getter
@Setter
@Builder
@Table(name = "postReport")
public class PostReport extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer postReportCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;          // 작성자 (Member와 연관 관계 설정)


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sellPostId", nullable = false)
    private SellPost sellPost;        // 게시물과의 관계
}
