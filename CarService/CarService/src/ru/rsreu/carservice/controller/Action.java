package ru.rsreu.carservice.controller;


import javax.servlet.http.HttpServletRequest;

import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;


public interface Action {
	/**
	 * Execute action
	 * @param request Request
	 * @return Page to redirect or forward to
	 * @throws Exception
	 * @throws DataBaseException
	 */
	Url execute(HttpServletRequest request) throws Exception, DataBaseException;
}
