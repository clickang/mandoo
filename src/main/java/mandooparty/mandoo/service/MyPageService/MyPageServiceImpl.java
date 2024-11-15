package mandooparty.mandoo.service.MyPageService;

import lombok.RequiredArgsConstructor;
import mandooparty.mandoo.domain.SellPost;
import mandooparty.mandoo.domain.enums.SellPostStatus;
import mandooparty.mandoo.repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl {
    private final LikeRepository likeRepository;
    public List<SellPost> getLikeSellPost(Long memberId, Integer page)
    {
        return likeRepository.findAllLike(memberId,page*6);//수정필요 + page 사용해야함
    }

    public List<SellPost> getSellPost(Long memberId, Integer page)
    {
        return likeRepository.findAllLike(memberId, SellPostStatus.FOR_SALE,page*6);//수정필요 + page 사용해야함
    }

    public List<SellPost> getSoldPost(Long memberId, Integer page)
    {
        return likeRepository.findAllLike(memberId,SellPostStatus.SOLD_OUT,page*6);//수정필요 + page 사용해야함
    }

}
