package com.springboot.toyproject.controller;

import com.springboot.toyproject.service.BoardService;
import com.springboot.toyproject.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String getListPage(Model model) {
        model.addAttribute("contents", boardService.list());
        return "include/board_layout";
    }

    @GetMapping("/view/{no}")
    public String getViewPage(@PathVariable("no") int no, Model model) {
        model.addAttribute("post", boardService.view(no));
        return "board/view";
    }

    @GetMapping("/write")
    public String getWritePage(Model model) {
        return "board/write";
    }

    @PostMapping("/write")
    public String write(BoardVO boardVO){
        boardService.write(boardVO);
        return "redirect:/list";
    }

    @PostMapping("/edit/{no}")
    public String edit(@PathVariable("no") int no, BoardVO boardVO){
        boardService.edit(no, boardVO);
        return "redirect:/list";
    }

    @PostMapping("/delete/{no}")
    public String delete(@PathVariable("no") int no){
        boardService.delete(no);
        return "redirect:/list";
    }

}
