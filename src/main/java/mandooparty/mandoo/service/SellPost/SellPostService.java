package mandooparty.mandoo.service.SellPost;

import mandooparty.mandoo.domain.SellPost;
import mandooparty.mandoo.web.dto.SellPostDTO;

public interface SellPostService {
    // 게시물 생성
    SellPost SellPostcreate(SellPostDTO.SellPostCreateDto request);

    // 게시물 조회
    SellPostDTO.SellPostResponseDto getSellPostById(Long id);

    // 게시물 삭제
    void deleteSellPost(Long id);
}
