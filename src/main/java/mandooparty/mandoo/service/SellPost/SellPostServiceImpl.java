package mandooparty.mandoo.service.SellPost;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mandooparty.mandoo.converter.SellPostConverter;
import mandooparty.mandoo.domain.SellPost;
import mandooparty.mandoo.exception.GlobalErrorCode;
import mandooparty.mandoo.exception.GlobalException;
import mandooparty.mandoo.repository.SellPostRepository;
import mandooparty.mandoo.web.dto.SellPostDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class SellPostServiceImpl implements SellPostService{

    private final SellPostRepository sellPostRepository;
    private final SellPostConverter sellPostConverter;

    @Override
    @Transactional
    public SellPost SellPostcreate(SellPostDTO.SellPostCreateDto request) {
        // DTO를 엔티티로 변환
        SellPost sellPost = sellPostConverter.sellPostCreateDto(request);

        // 게시물 저장
        sellPostRepository.save(sellPost);

        return sellPost;
    }

    @Override
    @Transactional(readOnly = true)
    public SellPostDTO.SellPostResponseDto getSellPostById(Long id) {
        // ID로 게시물 조회
        SellPost sellPost = sellPostRepository.findById(id)
                .orElseThrow(() -> new GlobalException(GlobalErrorCode.POST_NOT_FOUND));

        // 엔티티를 DTO로 변환 후 반환
        return sellPostConverter.sellPostResponseDto(sellPost);
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
