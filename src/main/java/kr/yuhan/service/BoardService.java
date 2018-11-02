package kr.yuhan.service;

import java.util.List;

import kr.yuhan.domain.BoardVO;
import kr.yuhan.domain.Criteria;
import kr.yuhan.domain.SearchCriteria;

public interface BoardService {
	
	public void create(BoardVO vo);
	public BoardVO read(int bno);
	public void update(BoardVO vo);
	public void delete(int bno);
	public List<BoardVO> listAll();
	public List<BoardVO> listCriteria(Criteria cri);
	public int totalCount(Criteria cri);
	
	public List<BoardVO> listSearchCriteria(SearchCriteria cri);
	public int listSearchCount(SearchCriteria cri);
}
