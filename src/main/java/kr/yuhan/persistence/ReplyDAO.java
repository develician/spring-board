package kr.yuhan.persistence;

import java.util.List;

import kr.yuhan.domain.ReplyVO;

public interface ReplyDAO {
	public void create(ReplyVO vo);

	public void update(ReplyVO vo);

	public void delete(int rno);

	public List<ReplyVO> list(int bno);

}
