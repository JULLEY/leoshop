package leobook.leoshop.domain.service;

import leobook.leoshop.domain.Member;
import leobook.leoshop.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
// @RequiredArgsConstructor 얘는 final이 있는것만 생성자를 만들어준다.
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // @AllArgsConstructor 이 어노테이션이 생성자를 만들어준다
    //public MemberService(MemberRepository memberRepository) {
    //    this.memberRepository = memberRepository;
    //}

    /**
     * 회원가입
     * @param member
     * @return
     */
    @Transactional
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
