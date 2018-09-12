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
//		model.addAttribute("list", service.listCriteria(cri));
		
		model.addAttribute("list", service.listSearchCriteria(cri));
		
		PageMaker maker = new PageMaker();
		maker.setCri(cri);
//		maker.setTotalCount(service.totalCount(cri));
		maker.setTotalCount(service.listSearchCount(cri));
		model.addAttribute("maker", maker);

		
	}
}
