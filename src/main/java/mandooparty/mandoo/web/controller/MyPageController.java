package mandooparty.mandoo.web.controller;

import lombok.RequiredArgsConstructor;
import mandooparty.mandoo.apiPayload.ApiResponse;
import mandooparty.mandoo.converter.MemberConverter;
import mandooparty.mandoo.domain.Like;
import mandooparty.mandoo.exception.GlobalException;
import mandooparty.mandoo.service.MyPageService.MyPageService;
import mandooparty.mandoo.web.dto.MemberDTO;
import mandooparty.mandoo.web.dto.MyPageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {
    private final MyPageService myPageService;
//    @GetMapping("/like")
//    public ApiResponse<SellPost> MyPageLike(@RequestParam Integer page, @RequestBody MyPageDTO.MemberIdRequestDto request)
//    {
//        Long memberId=request.getMemberId();
//        List<SellPost> sellPostList= myPageService.getLikeSellPost(memberId,page);
//        List<MyPageDTO.MyPageResponseDto> myPageResponseDtoList=new ArrayList<>();
//        for(SellPost sellPost : sellPostList){
//            myPageResponseDtoList.add(SellPostConverter.MyPageResponseDto(sellPost));
//        }
//        try{
//            return ApiResponse.onSuccess(myPageResponseDtoList);
//        }catch(GlobalException e){
//            return ApiResponse.onFailure(e.getErrorCode(), SellPostConverter.MyPageResponseDto(sellPost));
//        }
//    }
}
