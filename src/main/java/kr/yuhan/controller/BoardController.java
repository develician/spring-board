package kr.yuhan.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.yuhan.domain.BoardVO;
import kr.yuhan.domain.Criteria;
import kr.yuhan.domain.PageMaker;
import kr.yuhan.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Inject
	private BoardService service;

	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String regist(BoardVO vo) {
		return "/board/registerForm";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)  //submit버튼을 누르면 호출됨
	public String regist(BoardVO vo, RedirectAttributes redir) {
		service.create(vo);
		redir.addFlashAttribute("result","success");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model) {
		model.addAttribute("list",service.listAll());
	}
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno,Model model) {
		model.addAttribute("vo",service.read(bno));
		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("bno") int bno,RedirectAttributes rttr) {
		service.delete(bno);
		rttr.addFlashAttribute("result","delete");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public void update(int bno, Model model) {
		model.addAttribute("vo",service.read(bno));
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(BoardVO vo,RedirectAttributes rttr) {
		service.update(vo);
		rttr.addFlashAttribute("result","update");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listCriteria", method=RequestMethod.GET)
	public void listCriteria(Criteria cri,Model model) {
		/*Criteria cri=new Criteria();
		cri.setPage(2);*/
		model.addAttribute("list",service.listCriteria(cri));
	}
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void listPage(Criteria cri,Model model) {
		model.addAttribute("list",service.listCriteria(cri));
		PageMaker maker = new PageMaker();
		maker.setCri(cri);
		maker.setTotalCount(service.totalCount(cri));
		
		model.addAttribute("maker",maker);
	}
}
