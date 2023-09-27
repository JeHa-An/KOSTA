package service;

import bean.Member;
import dao.MemberDAO;
import dao.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDao;

	public MemberServiceImpl() {
		memberDao = new MemberDAOImpl();
	}

	@Override
	public void joinMember(Member member) throws Exception {
		memberDao.insertMember(member);
	}

	public Member loginMember(Member member) throws Exception {
		Member smember = new Member();
		return smember;
	}

}
