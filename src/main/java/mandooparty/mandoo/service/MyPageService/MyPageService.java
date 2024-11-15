package mandooparty.mandoo.service.MyPageService;

import lombok.RequiredArgsConstructor;
import mandooparty.mandoo.repository.LikeRepository;
import mandooparty.mandoo.repository.MemberRepository;
import mandooparty.mandoo.web.dto.MemberDTO;
import mandooparty.mandoo.web.dto.MyPageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageService {
    private final LikeRepository likeRepository;
//    public List<SellPost> getLikeSellPost(Long memberId, int page)
//    {
//        List<SellPost> sellPostList=likeRepository.findAllLike(memberId);
//        return sellPostList;
//    }

}
