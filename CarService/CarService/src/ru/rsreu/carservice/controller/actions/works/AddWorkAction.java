package ru.rsreu.carservice.controller.actions.works;

import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import resources.Resourcer;
import ru.rsreu.carservice.controller.Action;
import ru.rsreu.carservice.controller.actions.utils.WorkUtils;
import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.entities.Work;

public class AddWorkAction implements Action {
	private static final String WORKDESCRIPTION_PARAMETERNAME = "workdescription";
	private static final String WORKPRICE_PARAMETER_NAME = "workprice";
	private static final String WORKNAME_PARAMETER_NAME = "workname";

	@Override
	public String execute(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		Work work = new Work();
		work.setWorkGuid(UUID.randomUUID());
		String workName = request.getParameter(WORKNAME_PARAMETER_NAME);
		work.setName(workName);
		double workPrice = Double.parseDouble(request.getParameter(WORKPRICE_PARAMETER_NAME));
		work.setPrice(workPrice);
		String workDescription = request.getParameter(WORKDESCRIPTION_PARAMETERNAME);
		work.setDescription(workDescription);
		carServiceBl.addWork(work);
		WorkUtils.setWorks(request, carServiceBl.getAllWorks());
		return Resourcer.getString("path.page.all.works");
	}

}
