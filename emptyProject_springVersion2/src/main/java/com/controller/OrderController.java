package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService service;

}
