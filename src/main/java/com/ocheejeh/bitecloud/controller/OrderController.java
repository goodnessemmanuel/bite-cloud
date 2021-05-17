package com.ocheejeh.bitecloud.controller;

import com.ocheejeh.bitecloud.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("order", new Order());
        return "order";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors){
        if(errors.hasErrors()){
            return "order";
        }

        log.info("Processing order " + order);
        return "redirect:/";
    }
}
