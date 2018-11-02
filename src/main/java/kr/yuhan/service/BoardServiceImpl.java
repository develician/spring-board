package kr.yuhan.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.yuhan.domain.BoardVO;
import kr.yuhan.domain.Criteria;
import kr.yuhan.domain.SearchCriteria;
import kr.yuhan.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAO dao;
	
	
	@Override
	public void create(BoardVO vo) {
		dao.create(vo);
	}

	@Override
	public BoardVO read(int bno) {
	
		return dao.read(bno);
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);

	}

	@Override
	public void delete(int bno) {
		dao.delete(bno);

	}

	@Override
	public List<BoardVO> listAll() {
		return dao.listAll();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) {
		return dao.listCriteria(cri);
	}

	@Override
	public int totalCount(Criteria cri) {
		return dao.totalCount(cri);
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) {
		return dao.listSearchCount(cri);
	}

	

}
