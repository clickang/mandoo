package mandooparty.mandoo.domain;

import jakarta.persistence.*;
import lombok.*;
import mandooparty.mandoo.domain.enums.SellPostStatus;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@Table(name = "sellpost")

public class SellPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellPostId;

    private String title;           // 게시물 제목
    private int price;              // 상품 가격
    private String description;     // 게시글 설명

    @Enumerated(EnumType.STRING)
    private SellPostStatus status;  // 게시글 상태 (예: 판매중, 거래완료 등)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;          // 작성자 (Member와 연관 관계 설정)

    @Builder.Default
    private Integer commentCount = 0;       // 조회수

    @Builder.Default
    private Integer likeCount = 0;       // 좋아요 수

    private String city;    // 판매자 지역 주소 (시)
    private String gu;      // 판매자 지역 주소 (구)
    private String dong;    // 판매자 지역 주소 (동)

    private LocalDateTime createdAt = LocalDateTime.now(); // 생성 일자
    private LocalDateTime modifiedAt = LocalDateTime.now(); // 수정 일자

    @OneToMany(mappedBy = "sellPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SellPostCategory> categories; // SellPostCategory와의 연관 관계 설정
}
