package kr.yuhan.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.yuhan.domain.BoardVO;
import kr.yuhan.domain.Criteria;
import kr.yuhan.domain.PageMaker;
import kr.yuhan.domain.SearchCriteria;
import kr.yuhan.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
	@Inject
	private BoardService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) {
		// model.addAttribute("list", service.listCriteria(cri));

		model.addAttribute("list", service.listSearchCriteria(cri));

		PageMaker maker = new PageMaker();
		maker.setCri(cri);
		// maker.setTotalCount(service.totalCount(cri));
		maker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("maker", maker);

	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) {
		model.addAttribute("vo", service.read(bno));
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void update(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) {
		model.addAttribute("vo", service.read(bno));
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO board, SearchCriteria cri, RedirectAttributes rttr) {
		service.update(board);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("result", "update");
		return "redirect:/sboard/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String update(@RequestParam("bno") int bno, SearchCriteria cri, RedirectAttributes rttr) {
		service.delete(bno);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("result", "delete");
		return "redirect:/sboard/list";
	}

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String regist(BoardVO vo) {
		return "/sboard/registerForm";
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(BoardVO vo, RedirectAttributes redir) {
		service.create(vo);
		redir.addFlashAttribute("result", "success");
		return "redirect:/sboard/list";
	}
}
