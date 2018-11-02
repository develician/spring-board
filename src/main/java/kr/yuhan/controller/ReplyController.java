package kr.yuhan.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.yuhan.domain.ReplyVO;
import kr.yuhan.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	@Inject
	private ReplyService replyService;
	
	@RequestMapping(value="/list/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> getReplyList(@PathVariable int bno) {
		List<ReplyVO> replyList = null;
		try {
			replyList = replyService.getReplyListByBno(bno);
			return new ResponseEntity<List<ReplyVO>>(replyList, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<ReplyVO>>(replyList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<Boolean> createReply(@RequestBody ReplyVO vo) {
		if(vo == null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		
		System.out.println("VO Test" + vo.toString());
		
		try {
			replyService.createReply(vo);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PATCH)
	public ResponseEntity<Boolean> updateReply(@RequestBody ReplyVO vo) {
		if(vo == null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		
		try {
			replyService.updateReply(vo);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteReply(@PathVariable int rno) {
		try { 
			replyService.deleteReply(rno);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
