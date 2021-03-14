package leobook.leoshop.domain.service;

import leobook.leoshop.domain.Member;
import leobook.leoshop.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    /**
     * 회원가입
     * @param member
     * @return
     */
    public Long join(Member member){
       validateDuplicateMember(member);
       memberRepository.save(member);
       return member.getId();
    }

    /**
     * 중복회원조회
     * @param member
     */
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원 전체 조회
     * @return
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 회원 조회(단건)
     * @param memberId
     * @return
     */
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
