package mandooparty.mandoo.service.ManageService;


import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import mandooparty.mandoo.converter.ManageConverter;
import mandooparty.mandoo.domain.*;
import mandooparty.mandoo.exception.GlobalErrorCode;
import mandooparty.mandoo.exception.GlobalException;
import mandooparty.mandoo.repository.*;
import mandooparty.mandoo.web.dto.ManageDTO;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManageServiceImpl {
    private final SellPostRepository sellPostRepository;
    private final SellPostCategoryRepository sellPostCategoryRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;
    private final CommentReportRepository commentReportRepository;
    private final PostReportRepository postReportRepository;
    public List<ManageDTO.ManageDashBoardSellPostDto> getDaySellPostCount(){
        List<Tuple> result = sellPostRepository.countByCreatedAt();

        // Tuple에서 데이터를 꺼내서 ManageDashBoardSellPostDto로 변환
        List<ManageDTO.ManageDashBoardSellPostDto> dtoList = new ArrayList<>();

        for (Tuple tuple : result) {
            // Tuple에서 값을 추출
            LocalDate date = tuple.get(0, LocalDate.class);  // 첫 번째 값은 날짜
            Long sellPostCount = tuple.get(1, Long.class);   // 두 번째 값은 sellpost 개수

            // DTO 객체 생성하여 리스트에 추가
            ManageDTO.ManageDashBoardSellPostDto dto = new ManageDTO.ManageDashBoardSellPostDto();
            dto.setDate(date);  // 날짜 설정
            dto.setSellPostCount(sellPostCount.intValue());  // 개수 설정 (Long -> Integer로 변환)

            dtoList.add(dto);  // 리스트에 추가
        }

        return dtoList;

    }

    public List<ManageDTO.ManageDashBoardCategoryRatioDto> getCategoryRatio()
    {
        List<Tuple> result=sellPostCategoryRepository.countCategory();


        // Tuple에서 데이터를 꺼내서 ManageDashBoardSellPostDto로 변환
        List<ManageDTO.ManageDashBoardCategoryRatioDto> dtoList = new ArrayList<>();

        for (Tuple tuple : result) {
            // Tuple에서 값을 추출
            String name = tuple.get(0, String.class);  // 첫 번째 값은 날짜
            Long categoryCount = tuple.get(1, Long.class);   // 두 번째 값은 sellpost 개수

            // DTO 객체 생성하여 리스트에 추가
            ManageDTO.ManageDashBoardCategoryRatioDto dto = new ManageDTO.ManageDashBoardCategoryRatioDto();
            dto.setName(name);  // 날짜 설정
            dto.setCategoryCount(categoryCount.intValue());  // 개수 설정 (Long -> Integer로 변환)

            dtoList.add(dto);  // 리스트에 추가
        }

        return dtoList;
    };

    public List<ManageDTO.ManageDashBoardDateViewDto> getDateView()
    {
        LocalDate today = LocalDate.now();
        List<ManageDTO.ManageDashBoardDateViewDto> dtoList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {

            Integer subscriber=memberRepository.getCountByDate(today).intValue();
            Integer sellPost=sellPostRepository.getCountByDate(today).intValue();
            Integer comment=commentRepository.getCountByDate(today).intValue();
            ManageDTO.ManageDashBoardDateViewDto dto=new ManageDTO.ManageDashBoardDateViewDto();

            dto.setDate(today);
            dto.setSubscriber(subscriber);
            dto.setSellPost(sellPost);
            dto.setComment(comment);
            dtoList.add(dto);
            today = today.minusDays(1);// 날짜를 하루 줄이기
        }
        return dtoList;
    }

    public List<Member> getMember(){
        return memberRepository.findAll();
    };

    public List<ManageDTO.CommentReportDto> getCommentReport(String order)
    {
        Sort sort = Sort.by(Sort.Direction.ASC, order);
        List<CommentReport> commentReportList=commentReportRepository.findAll(sort);

        List<ManageDTO.CommentReportDto> commentReportDtoList=new ArrayList<>();
        for(CommentReport commentReport:commentReportList){
            commentReportDtoList.add(ManageConverter.ManageCommentReportDto(commentReport));
        }
        return commentReportDtoList;

    }

    public List<ManageDTO.PostReportDto> getPostReport(String order)
    {
        Sort sort = Sort.by(Sort.Direction.ASC, order);
        List<PostReport> postReportList=postReportRepository.findAll(sort);

        List<ManageDTO.PostReportDto> postReportDtoList=new ArrayList<>();
        for(PostReport postReport:postReportList){
            postReportDtoList.add(ManageConverter.ManagePostReportDto(postReport));
        }
        return postReportDtoList;

    }

    public void deleteMember(Long memberId){
        Optional<Member> deleteMember=memberRepository.findById(memberId);

        if(deleteMember.isPresent()) {
            memberRepository.deleteById(memberId);
        }else{
            throw new GlobalException(GlobalErrorCode.MEMBER_NOT_FOUND);
        }
    }

    public void deleteCommentReport(Long commentId){
        Optional<Comment> deleteComment=commentRepository.findById(commentId);

        if(deleteComment.isPresent()) {
            memberRepository.deleteById(commentId);
        }else{
            throw new GlobalException(GlobalErrorCode.MEMBER_NOT_FOUND);
        }
    }

    public void deletePostReport(Long sellPostId){
        Optional<Comment> deletePost=commentRepository.findById(sellPostId);

        if(deletePost.isPresent()) {
            memberRepository.deleteById(sellPostId);
        }else{
            throw new GlobalException(GlobalErrorCode.MEMBER_NOT_FOUND);
        }
    }



}
