package mandooparty.mandoo.web.controller;

import lombok.RequiredArgsConstructor;
import mandooparty.mandoo.apiPayload.ApiResponse;
import mandooparty.mandoo.exception.GlobalException;
import mandooparty.mandoo.service.SellPost.CategoryService;
import mandooparty.mandoo.service.SellPost.SellPostService;
import mandooparty.mandoo.web.dto.SellPostDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sellpost")
public class SellPostController {

    private final SellPostService sellPostService;
    private final CategoryService categoryService;


    @PostMapping("/write")
    public ApiResponse<SellPostDTO.SellPostResponseDto> createSellPost(@RequestBody SellPostDTO.SellPostCreateDto request) {
        try {
            SellPostDTO.SellPostResponseDto responseDto = sellPostService.SellPostcreate(request);

            return ApiResponse.onSuccess(responseDto); // 생성된 게시물을 응답
        } catch (GlobalException e) {
            return ApiResponse.onFailure(e.getErrorCode(), null); // 예외 발생 시 실패 응답 반환
        }
    }

    @GetMapping("/write")
    public ApiResponse<SellPostDTO.SellPostWritePageDto> getSellPostWritePage() {
        // 모든 카테고리 이름을 문자열 리스트로 가져옵니다.
        List<String> categoryNames = categoryService.getAllCategory();
        SellPostDTO.SellPostWritePageDto response = new SellPostDTO.SellPostWritePageDto(categoryNames);
        return ApiResponse.onSuccess(response);
    }


    // 게시글 조회 요청 처리
    @GetMapping("/read/{sellPostId}")
    public ApiResponse<SellPostDTO.SellPostResponseDto> getSellPost(@PathVariable Long sellPostId) {
        try {
            return ApiResponse.onSuccess(sellPostService.getSellPostById(sellPostId));
        } catch (GlobalException e) {
            return ApiResponse.onFailure(e.getErrorCode(), null);
        }
    }


}
