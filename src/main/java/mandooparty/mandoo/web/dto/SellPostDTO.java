package mandooparty.mandoo.web.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SellPostDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SellPostWritePageDto {
        private List<String> categories; // 모든 카테고리 이름 리스트
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SellPostUpdatePageDto {
        private List<String> categories; // 모든 카테고리 이름 리스트
    }


    @Builder            // 빌더 패턴을 자동 생성하여 객체 생성 시 각 필드의 값을 유연하게 설정할 수 있도록 함
    @Getter             // 모든 필드에 대한 getter 메서드를 자동 생성하여 필드 값을 읽을 수 있도록 함
    @Setter             // 모든 필드에 대한 setter 메서드를 자동 생성하여 필드 값을 설정할 수 있도록 함
    @NoArgsConstructor  // 매개변수가 없는 기본 생성자를 자동 생성
    @AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자를 자동 생성
    public static class SellPostCreateDto {
        private String title;       // 게시글 제목
        private Integer price;      // 가격
        private String description; // 게시글 설명
        private String city;        // 시
        private String gu;          // 구
        private String dong;        // 동
        private List<Long> categoryIds; // 카테고리 ID 리스트
        private Long memberId;      // 게시물 작성자

    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SellPostResponseDto {
        private Long sellPostId;     // 게시글 ID
        private String title;        // 게시글 제목
        private Integer price;       // 가격
        private String description;  // 게시글 설명
        private String city;         // 시
        private String gu;           // 구
        private String dong;         // 동
        private Long memberId;       // 게시물 작성자
        private Integer likeCount;   // 좋아요 수
        private Integer commentCount; // 댓글 수
        private LocalDateTime createdAt; // 생성일자
        private LocalDateTime modifiedAt; // 수정일자
        private List<String> categories; // 카테고리 이름 리스트
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SellPostUpdateDto {
        private String title;       // 게시글 제목
        private Integer price;      // 가격
        private String description; // 게시글 설명
        private String city;        // 시
        private String gu;          // 구
        private String dong;        // 동
        private Long memberId;
        private List<Long> categoryIds; // 카테고리 ID 리스트
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SellPostDeleteDto {
        private Long sellPostId;    // 삭제할 게시글 ID
    }


}