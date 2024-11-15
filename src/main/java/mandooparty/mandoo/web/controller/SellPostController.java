package mandooparty.mandoo.web.controller;

import lombok.RequiredArgsConstructor;
import mandooparty.mandoo.apiPayload.ApiResponse;
import mandooparty.mandoo.converter.SellPostConverter;
import mandooparty.mandoo.exception.GlobalException;
import mandooparty.mandoo.service.SellPost.SellPostService;
import mandooparty.mandoo.web.dto.SellPostDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sellpost")
public class SellPostController {

    private final SellPostService sellPostService;

    // 게시글 작성 요청 처리
    @PostMapping("/write")
    public ApiResponse<SellPostDTO.SellPostResponseDto> createSellPost(@RequestBody SellPostDTO.SellPostCreateDto request) {
        try {
            return ApiResponse.onSuccess(SellPostConverter.sellPostResponseDto(sellPostService.createSellPost(request)));
        } catch (GlobalException e) {
            return ApiResponse.onFailure(e.getErrorCode(), SellPostConverter.sellPostResponseDto(sellPostService.createSellPost(request)));
        }
    }

    // 게시글 작성 화면 데이터 조회
    @GetMapping("/write")
    public ApiResponse<String> getWritePageData() {
        // 예시: 화면에 필요한 기본 데이터를 반환
        return ApiResponse.onSuccess("게시글 작성에 필요한 데이터 반환");
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
