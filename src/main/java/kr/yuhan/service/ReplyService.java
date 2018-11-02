package kr.yuhan.service;

import java.util.List;

import kr.yuhan.domain.ReplyVO;

public interface ReplyService {

	public void createReply(ReplyVO vo);
	public void updateReply(ReplyVO vo);
	public void deleteReply(int rno);
	public List<ReplyVO> getReplyListByBno(int bno);
	
}
