package mandooparty.mandoo.web.dto;

import lombok.*;
import mandooparty.mandoo.domain.enums.MemberStatus;

import java.time.LocalDate;
import java.util.List;

public class ManageDTO {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ManageDashBoardSellPostDto{
        private LocalDate date;
        private Integer sellPostCount;
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ManageDashBoardCategoryRatioDto{
        private String name;
        private Integer categoryCount;
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ManageDashBoardDateViewDto{
        private LocalDate date;
        private Integer subscriber;
        private Integer sellPost;
        private Integer comment;
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ManageDashBoardDto{
        private List<ManageDashBoardSellPostDto> sellPostCont;
        private List<ManageDashBoardCategoryRatioDto> categoryRatio;

        private List<ManageDashBoardDateViewDto> dateView;
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ManageMemberDto{
        private Long memberId;
        private String passWord;
        private String email;
        private MemberStatus status;
        private String name;
        private String nickName;
        private Integer writeSellPostCount;
        private Integer likeSellPostCount;
        private Integer completedSellPostCount;
        private LocalDate createdAt;
        private LocalDate modifiedAt;
    }
}
