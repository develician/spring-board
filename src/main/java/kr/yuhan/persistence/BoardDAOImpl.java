package kr.yuhan.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.yuhan.domain.BoardVO;
import kr.yuhan.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	private String namespace="kr.yuhan.mapper.BoardMapper";

	@Override
	public void create(BoardVO vo) {
		session.insert(namespace+".create",vo);
	}

	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".read",bno); //해당 글번호의 글만 읽어옴
		
	}

	@Override
	public void update(BoardVO vo) {
		session.update(namespace+".update",vo);
	}

	@Override
	public void delete(int bno) {
		session.delete(namespace+".delete",bno);
	}

	@Override
	public List<BoardVO> listAll() {
		return session.selectList(namespace+".listAll");
	}

	@Override
	public List<BoardVO> listPage(int page) {
		if(page <=0)
			page=1;
		
		page=(page-1)*10; //limit의 시작번호
		return session.selectList(namespace+".listPage",page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) {
		
		return  session.selectList(namespace+".listCriteria",cri);
	}

	@Override
	public int totalCount(Criteria cri) {
		
		return session.selectOne(namespace+".totalCount",cri);
	}

}
