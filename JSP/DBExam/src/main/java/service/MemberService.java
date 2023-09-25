package service;

import dao.MemberDAO;
import dto.Member;

public class MemberService {
	public void join(Member member) {
		MemberDAO dao = new MemberDAO();
		dao.insertMember(member);
	}
}
