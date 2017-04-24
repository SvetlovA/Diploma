package ru.rsreu.carservice.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;


public interface Action {
	/**
	 * Execute action
	 * @param request Request
	 * @return Page to redirect or forward to
	 * @throws SQLException
	 * @throws Exception
	 */
	String execute(HttpServletRequest request) throws SQLException, Exception;
	/**
	 * Flag to determine forward or redirect
	 * @return Forward if true, Redirrect if false
	 */
	boolean isForward();
}
