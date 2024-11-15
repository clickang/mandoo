package mandooparty.mandoo.service.SellPost;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mandooparty.mandoo.converter.SellPostConverter;
import mandooparty.mandoo.domain.Category;
import mandooparty.mandoo.domain.Member;
import mandooparty.mandoo.domain.SellPost;
import mandooparty.mandoo.domain.SellPostCategory;
import mandooparty.mandoo.exception.GlobalErrorCode;
import mandooparty.mandoo.exception.GlobalException;
import mandooparty.mandoo.repository.CategoryRepository;
import mandooparty.mandoo.repository.MemberRepository;
import mandooparty.mandoo.repository.SellPostCategoryRepository;
import mandooparty.mandoo.repository.SellPostRepository;
import mandooparty.mandoo.web.dto.SellPostDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class SellPostServiceImpl implements SellPostService{

    private final SellPostRepository sellPostRepository;
    private final SellPostConverter sellPostConverter;
    private final MemberRepository memberRepository;
    private final SellPostCategoryRepository sellPostCategoryRepository;
    private final CategoryRepository categoryRepository;





    @Override
    @Transactional
    public SellPostDTO.SellPostResponseDto SellPostcreate(SellPostDTO.SellPostCreateDto request) {

        // memberId로 Member 조회
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new GlobalException(GlobalErrorCode.MEMBER_NOT_FOUND));

        // DTO를 엔티티로 변환
        SellPost sellPost = sellPostConverter.sellPostCreateDto(request, member);

        // categoryIds로 Category 리스트 조회 및 SellPostCategory 생성
        List<SellPostCategory> sellPostCategories = request.getCategoryIds().stream()
                .map(categoryId -> {
                    Category category = categoryRepository.findById(categoryId)
                            .orElseThrow(() -> new GlobalException(GlobalErrorCode.CATEGORY_NOT_FOUND));
                    return SellPostCategory.builder()
                            .sellPost(sellPost)
                            .category(category)
                            .build();
                })
                .collect(Collectors.toList());


        // SellPost에 카테고리 설정
        sellPost.setCategories(sellPostCategories);

        // 게시물 저장
        sellPostRepository.save(sellPost);

        return SellPostConverter.sellPostResponseDto(sellPost);
    }

    @Override
    @Transactional(readOnly = true)
    public SellPostDTO.SellPostResponseDto getSellPostById(Long id) {
        // ID로 게시물 조회
        SellPost sellPost = sellPostRepository.findById(id)
                .orElseThrow(() -> new GlobalException(GlobalErrorCode.POST_NOT_FOUND));

        // 엔티티를 DTO로 변환 후 반환
        return SellPostConverter.sellPostResponseDto(sellPost);
    }

    @Override
    @Transactional
    public void deleteSellPost(Long id) {
        if (!sellPostRepository.existsById(id)) {
            throw new GlobalException(GlobalErrorCode.POST_NOT_FOUND);
        }
        sellPostRepository.deleteById(id);
    }
}
