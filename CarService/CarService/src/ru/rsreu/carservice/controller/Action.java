package ru.rsreu.carservice.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;


public interface Action {
	String execute(HttpServletRequest request) throws SQLException, Exception;
	boolean isForward();
}
