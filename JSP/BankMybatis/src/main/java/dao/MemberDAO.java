package dao;

import bean.Member;

public interface MemberDAO {
	void insertMember(Member member) throws Exception;

	Member selectMember(Member member) throws Exception;
}
