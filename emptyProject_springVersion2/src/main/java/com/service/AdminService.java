package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminDAO;

@Service
public class AdminService {
	@Autowired
	AdminDAO dao;
}
