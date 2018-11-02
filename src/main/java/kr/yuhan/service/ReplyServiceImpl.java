package kr.yuhan.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.yuhan.domain.ReplyVO;
import kr.yuhan.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO replyDAO;

	@Override
	public void createReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		replyDAO.create(vo);
		
	}

	@Override
	public void updateReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		
		replyDAO.update(vo);
	}

	@Override
	public void deleteReply(int rno) {
		// TODO Auto-generated method stub
		replyDAO.delete(rno);
		
	}

	@Override
	public List<ReplyVO> getReplyListByBno(int bno) {
		// TODO Auto-generated method stub
		return replyDAO.list(bno);
	}
	
	

}
