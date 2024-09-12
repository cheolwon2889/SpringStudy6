package com.itwillbs.persistence;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

/**
 * 
 * MemberDAO 동작을 수행
 *
 */
// @Repository : 스프링이 해당클래스를 DAO객체 (Bean)로 인식
// 				root-context.xml파일에서 해당객체를 사용하도록 설정.
// 
@Repository
public class MemberDAOImpl implements MemberDAO{
	// 파일에 S라고 붙어 있으면 spring이 관리하는대상을 나타냄.
	
	// 공통변수, 디비 연결, 자원해제
	// 디비 연결객체(SqlSessionFactory)가 필요함 => 의존관계 주입
//	@Inject
//	private SqlSessionFactory sqlFactory;
	
	@Inject
	private SqlSession sqlSession; // 자동으로 연결, 자원해제,SQL실행, mybatis...
	
	// Mapper namespace 정보 저장
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper";
	
	
	@Override
	public String getTime() {
		System.out.println(" DAO : getTime() 실행! ");
		// 1,2 디비 연결
		// SqlSession sqlSession = sqlFactory.openSession(); -> 생략을 하는게 SqlSession이라는 객체를 주입받아서 생략함.
		// 3 SQL 구문 & pstmt 객체
		// 4 SQL 실행
		//sqlFactory.selectOne(SQL구문);
		//sqlFactory.selectOne(SQL구문,전달정보);
		String result = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		// => Mapper의 sql 구문 id를 호출
		// = sqlSession.selectOne("select now()");
		// => 직접적으로 SQL구문 호출 X
		System.out.println("결과 : "+ result);
		
		
		// 5. 데이터 처리
		return result;
	}
	
	
	@Override
	public void insertMember(MemberVO vo) {
		System.out.println(" DAO : 회원가입 동작 실행! ");
				
		// 1.2 디비연결  => 생략 SqlSession객체 수행
		// 3. SQL 구문(Mapper 생성) & pstmt 객체 (mybatis 관리)
		// 4. SQL 실행
		// [com.itwillbs.mapper.MemberMapper.insertMember]
		int result = sqlSession.insert( NAMESPACE+".insertMember", vo);
		System.out.println(" DAO : result : "+ result );
		System.out.println(" DAO : 회원가입 완료! ");
	}
	
	
}
