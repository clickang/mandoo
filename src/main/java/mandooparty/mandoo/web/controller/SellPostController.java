package mandooparty.mandoo.web.controller;

import lombok.RequiredArgsConstructor;
import mandooparty.mandoo.apiPayload.ApiResponse;
import mandooparty.mandoo.converter.SellPostConverter;
import mandooparty.mandoo.domain.SellPost;
import mandooparty.mandoo.exception.GlobalException;
import mandooparty.mandoo.service.SellPost.SellPostService;
import mandooparty.mandoo.web.dto.SellPostDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sellpost")
public class SellPostController {

    private final SellPostService sellPostService;


    @PostMapping("/write")
    public ApiResponse<SellPostDTO.SellPostResponseDto> createSellPost(@RequestBody SellPostDTO.SellPostCreateDto request) {
        try {
            SellPost createdSellPost = sellPostService.SellPostcreate(request);
            SellPostDTO.SellPostResponseDto responseDto = SellPostConverter.sellPostResponseDto(createdSellPost);

            return ApiResponse.onSuccess(responseDto); // 생성된 게시물을 응답
        } catch (GlobalException e) {
            return ApiResponse.onFailure(e.getErrorCode(), null); // 예외 발생 시 실패 응답 반환
        }
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
