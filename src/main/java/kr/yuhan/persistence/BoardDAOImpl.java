package kr.yuhan.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.yuhan.domain.BoardVO;
import kr.yuhan.domain.Criteria;
import kr.yuhan.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	private String NAMESPACE = "kr.yuhan.mapper.BoardMapper";

	@Override
	public void create(BoardVO vo) {
		session.insert(NAMESPACE + ".create", vo);
	}

	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE + ".read", bno); // �빐�떦 湲�踰덊샇�쓽 湲�留� �씫�뼱�샂

	}

	@Override
	public void update(BoardVO vo) {
		session.update(NAMESPACE + ".update", vo);
	}

	@Override
	public void delete(int bno) {
		session.delete(NAMESPACE + ".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() {
		return session.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public List<BoardVO> listPage(int page) {
		if (page <= 0)
			page = 1;

		page = (page - 1) * 10; // limit�쓽 �떆�옉踰덊샇
		return session.selectList(NAMESPACE + ".listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) {

		return session.selectList(NAMESPACE + ".listCriteria", cri);
	}

	@Override
	public int totalCount(Criteria cri) {

		return session.selectOne(NAMESPACE + ".totalCount", cri);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) {
		return session.selectList(NAMESPACE + ".listSearchCriteria", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) {
		return session.selectOne(NAMESPACE + ".listSearchCount", cri);
	}

}
