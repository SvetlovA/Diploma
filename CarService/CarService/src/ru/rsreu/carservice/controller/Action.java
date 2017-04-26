package ru.rsreu.carservice.controller;


import javax.servlet.http.HttpServletRequest;

import ru.rsreu.carservice.model.dal.exceptions.DataBaseException;


public interface Action {
	/**
	 * Execute action
	 * @param request Request
	 * @return Page to redirect or forward to
	 * @throws DataBaseException
	 * @throws Exception TODO
	 */
	Url execute(HttpServletRequest request) throws DataBaseException, Exception;
}
