package ru.rsreu.carservice.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.carservice.model.bll.CarServiceBl;

public interface Action {
	String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException, Exception;
}
