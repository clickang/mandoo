package mandooparty.mandoo.web.controller;

import lombok.RequiredArgsConstructor;
import mandooparty.mandoo.apiPayload.ApiResponse;
import mandooparty.mandoo.converter.ManageConverter;
import mandooparty.mandoo.converter.MemberConverter;
import mandooparty.mandoo.converter.SellPostConverter;
import mandooparty.mandoo.domain.ManageMember;
import mandooparty.mandoo.domain.Member;
import mandooparty.mandoo.domain.SellPost;
import mandooparty.mandoo.exception.GlobalException;
import mandooparty.mandoo.service.ManageService.ManageService;
import mandooparty.mandoo.web.dto.ManageDTO;
import mandooparty.mandoo.web.dto.SellPostDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manage")
public class ManageController {
    private ManageService manageService;
    @GetMapping("/dashboard")//관리자 페이지 dashboard
    public ApiResponse<ManageDTO.ManageDashBoardDto> ManageDashBoard(){//데이터 양 안 정함 -> 수정 필요
        List<ManageDTO.ManageDashBoardSellPostDto> sellPostCountList=manageService.getDaySellPostCount();
        List<ManageDTO.ManageDashBoardCategoryRatioDto> categoryRatio=manageService.getCategoryRatio();
        List<ManageDTO.ManageDashBoardDateViewDto> dateView=manageService.getDateView();

        ManageDTO.ManageDashBoardDto manageDashBoardDto=new ManageDTO.ManageDashBoardDto(sellPostCountList,categoryRatio,dateView);

        try{
            return ApiResponse.onSuccess(manageDashBoardDto);
        }catch(GlobalException e){
            return ApiResponse.onFailure(e.getErrorCode(),manageDashBoardDto);
        }
    }

    @GetMapping("/member")//관리자 페이지 회원관리
    public ApiResponse<List<ManageDTO.ManageMemberDto>> ManageMember(@RequestParam Integer page){
        List<ManageMember> memberList=manageService.getMember(page);
        List<ManageDTO.ManageMemberDto> manageMemberDtoList=new ArrayList<>();
        for(ManageMember member : memberList){//domain -> dto로 변경
            manageMemberDtoList.add(ManageConverter.ManageMemberDto(member));
        }
        try{
            return ApiResponse.onSuccess(manageMemberDtoList);
        }catch(GlobalException e){
            return ApiResponse.onFailure(e.getErrorCode(), manageMemberDtoList);
        }

    }
}
