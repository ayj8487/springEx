package hello.core.member;

public class MemberServiceImpl implements MemberService{

//	private final MemberRepository memberRepository = new MemoryMemberRepository();

	private final MemberRepository memberRepository;
	// 인터페이스만 의존 , DIP 설계
	
	// 생성자를 통해서 MemberRepository 에 구현체가 어떤것이 들어갈지 
	public MemberServiceImpl(MemberRepository memberRepository) {
	super();
	this.memberRepository = memberRepository;
}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
