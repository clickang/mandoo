package mandooparty.mandoo.converter;


import mandooparty.mandoo.domain.SellPost;
import mandooparty.mandoo.domain.Category;
import mandooparty.mandoo.domain.SellPostCategory;
import mandooparty.mandoo.web.dto.SellPostDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class SellPostConverter {

    // SellPostCreateDto -> SellPost 엔티티로 변환
    public SellPost sellPostCreateDto(SellPostDTO.SellPostCreateDto dto) {
        return SellPost.builder()
                .title(dto.getTitle())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .city(dto.getCity())
                .gu(dto.getGu())
                .dong(dto.getDong())
                .build();
    }

    public SellPostDTO.SellPostResponseDto sellPostResponseDto(SellPost sellPost) {
        return SellPostDTO.SellPostResponseDto.builder()
                .sellPostId(sellPost.getSellPostId())   // 게시글 ID 설정
                .title(sellPost.getTitle())             // 게시글 제목 설정
                .price(sellPost.getPrice())             // 가격 설정
                .description(sellPost.getDescription()) // 게시글 설명 설정
                .city(sellPost.getCity())               // 게시물 위치 - 시 설정
                .gu(sellPost.getGu())                   // 게시물 위치 - 구 설정
                .dong(sellPost.getDong())               // 게시물 위치 - 동 설정
                .likeCount(sellPost.getLikeCount())     // 좋아요 수 설정
                .commentCount(sellPost.getCommentCount()) // 댓글 수 설정
                .createdAt(sellPost.getCreatedAt())     // 생성일자 설정
                .modifiedAt(sellPost.getModifiedAt())   // 수정일자 설정
                .categories(sellPost.getCategories().stream()  // 카테고리 목록 설정 (stream 시작)
                        .map(SellPostCategory::getCategory)    // SellPostCategory에서 Category 객체 추출
                        .map(Category::getName)                // Category 객체에서 이름 추출
                        .collect(Collectors.toList()))         // 이름을 리스트로 수집하여 반환
                .build();
    }


}
