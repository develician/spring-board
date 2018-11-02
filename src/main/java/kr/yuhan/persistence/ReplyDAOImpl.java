package kr.yuhan.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.yuhan.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession session;
	private String NAMESPACE = "kr.yuhan.mapper.ReplyMapper";
	
	@Override
	public void create(ReplyVO vo) {
		// TODO Auto-generated method stub
		session.insert(NAMESPACE + ".create", vo);
		
	}

	@Override
	public void update(ReplyVO vo) {
		// TODO Auto-generated method stub
		session.update(NAMESPACE + ".update", vo);
		
	}

	@Override
	public void delete(int rno) {
		// TODO Auto-generated method stub
		session.delete(NAMESPACE + ".delete", rno);
	}

	@Override
	public List<ReplyVO> list(int bno) {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE + ".list", bno);
	}

}
