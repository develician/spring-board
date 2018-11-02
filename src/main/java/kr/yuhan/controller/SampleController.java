package kr.yuhan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.yuhan.domain.SampleVO;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@RequestMapping("/hello")
	public String SayHello() {
		return "Hello!";
	}
	
	@RequestMapping("/sendVO")
	public ResponseEntity<?> SendVO() {
		SampleVO vo = new SampleVO();
		vo.setMno(1);
		vo.setFirstName("Some");
		vo.setLastName("Thing");
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
	
	@RequestMapping("/listVO")
	public ResponseEntity<List<SampleVO>> SendList() {
		List<SampleVO> sampleVOList = new ArrayList<>();
		for(int i = 0;i < 10;i++) {
			SampleVO vo = new SampleVO();
			vo.setMno(i);
			vo.setFirstName(i + " Some");
			vo.setLastName("Thing");
			sampleVOList.add(vo);
		}
		return new ResponseEntity<List<SampleVO>>(sampleVOList, HttpStatus.OK);
	}
	
	@RequestMapping("/hashedList")
	public ResponseEntity<Map<Integer, SampleVO>> sendMap() {
		Map<Integer, SampleVO> hashedList = new HashMap<>();
		
		for(int i = 0;i < 10;i++) {
			SampleVO vo = new SampleVO();
			vo.setMno(i);
			vo.setFirstName(i + " Some");
			vo.setLastName("Thing");
			hashedList.put(i, vo);
		}
		
		return new ResponseEntity<Map<Integer,SampleVO>>(hashedList, HttpStatus.OK);
		
	}
}
