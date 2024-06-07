package com.springboot.toyproject.controller;

import com.springboot.toyproject.repository.BoardTransaction;
import com.springboot.toyproject.service.BoardService;
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

    @GetMapping("/view/{postNo}")
    public String getViewPage(@PathVariable("postNo") int postNo, Model model) {
        model.addAttribute("post", boardService.view(postNo));
        return "board/view";
    }

    @GetMapping("/write")
    public String getWritePage(Model model) {
        return "board/write";
    }

    @PostMapping("/write")
    public String write(BoardTransaction.BoardVO boardVO){
        boardService.write(boardVO);
        return "redirect:/list";
    }

    @PostMapping("/edit/{postNo}")
    public String edit(@PathVariable("postNo") int postNo, BoardTransaction.BoardVO boardVO){
        boardService.edit(postNo, boardVO);
        return "redirect:/list";
    }

    @PostMapping("/delete/{no}")
    public String delete(@PathVariable("no") int no){
        boardService.delete(no);
        return "redirect:/list";
    }

}
