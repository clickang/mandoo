package mandooparty.mandoo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MyPageDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberIdRequestDto{//myPageRequest
        private Long memberId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyPageResponseDto{
        private Long sellPostId;
        private String title;
        private Integer price;
        private String description;
        private LocalDate createdAt;
        private LocalDate modifiedAt;
//        private SellPostStatus status;
        private Long memberId;
        private String city;
        private String gu;
        private String dong;
        private Integer commentCount;
    }
}
