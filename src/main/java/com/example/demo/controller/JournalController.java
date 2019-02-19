package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Journal;
import com.example.demo.service.JournalRepository;

@Controller
public class JournalController {
  
  private static Logger logger = LoggerFactory.getLogger(JournalController.class);
  
  @Autowired
  JournalRepository repo;
  
  @RequestMapping("/")
  public String index(Model model) {
    model.addAttribute("journal", repo.findAll());
    logger.info("saveData 확인 {}" , repo.findAll());
    return "/sample/index";
  }
  
  @RequestMapping(value =  "/journal", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
  public @ResponseBody List<Journal> getJournal(){
    return repo.findAll();
  }
}
