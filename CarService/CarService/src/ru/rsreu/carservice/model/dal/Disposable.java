package ru.rsreu.carservice.model.dal;

import java.sql.SQLException;

public interface Disposable {
	void dispose() throws SQLException;
}
