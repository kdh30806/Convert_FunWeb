package com.funweb.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.funweb.dao.MainDAO;

@Repository
public class MainServiceImp {

	@Inject
	private MainDAO mainDAO;
}
