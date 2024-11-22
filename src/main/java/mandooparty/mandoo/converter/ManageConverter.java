package mandooparty.mandoo.converter;

import mandooparty.mandoo.domain.ManageMember;
import mandooparty.mandoo.domain.Member;
import mandooparty.mandoo.web.dto.ManageDTO;
import mandooparty.mandoo.web.dto.MemberDTO;
import org.springframework.stereotype.Component;

@Component
public class ManageConverter {

    public static ManageDTO.ManageMemberDto ManageMemberDto(ManageMember member){
        return ManageDTO.ManageMemberDto.builder()
                .memberId(member.getId())
                .passWord(member.getPassword())
                .email(member.getEmail())
                .status(member.getStatus())
                .nickName(member.getNickname())
                .writeSellPostCount(member.getWriteSellPostCount())
                .likeSellPostCount(member.getLikeSellPostCount())
                .completedSellPostCount(member.getCompletedSellPostCount())
                .createdAt(member.getCreateAt())
                .modifiedAt(member.getModifiedAt())
                .build();
    }
}
