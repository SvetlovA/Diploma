package ru.rsreu.carservice.controller.actions.utils;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.carservice.model.bll.CarServiceBl;
import ru.rsreu.carservice.model.entities.SharePart;

public class SharePartUtils {
	
	private static final String SHAREPARTS_ATTRIBUTE_NAME = "shareparts";
	private static final String SHAREPARTDESCRIPTION_PARAMETER_NAME = "sharepartdescription";
	private static final String SHAREPARTCOUNT_PARAMETER_NAME = "sharepartcount";
	private static final String SHAREPARTPRICE_PARAMETER_NAME = "sharepartprice";
	private static final String SHAREPARTNAME_PARAMETER_NAME = "sharepartname";
	private static final String SHAREPARTGUID_PARAMETER_NAME = "sharepartguid";
	private static final String SHAREPARTID_PARAMETER_NAME = "sharepartid";
	private static final String ISSELECTED_PARAMETER_NAME = "isselectedsharepart";

	private SharePartUtils() {
	}
	
	public static SharePart parseSharePart(HttpServletRequest request) {
		SharePart sharePart = new SharePart();
		int sharePartId = Integer.parseInt(request.getParameter(SHAREPARTID_PARAMETER_NAME));
		sharePart.setSharePartId(sharePartId);
		UUID sharePartGuid = UUID.fromString(request.getParameter(SHAREPARTGUID_PARAMETER_NAME));
		sharePart.setSharePartGuid(sharePartGuid);
		String sharePartName = request.getParameter(SHAREPARTNAME_PARAMETER_NAME);
		sharePart.setName(sharePartName);
		double sharePartPrice = Double.parseDouble(request.getParameter(SHAREPARTPRICE_PARAMETER_NAME));
		sharePart.setPrice(sharePartPrice);
		int sharePartCount = Integer.parseInt(request.getParameter(SHAREPARTCOUNT_PARAMETER_NAME));
		sharePart.setCount(sharePartCount);
		String sharePartDescription = request.getParameter(SHAREPARTDESCRIPTION_PARAMETER_NAME);
		sharePart.setDescription(sharePartDescription);
		return sharePart;
	}
	
	public static void setSharePart(HttpServletRequest request, SharePart sharePart) {
		request.setAttribute(SHAREPARTID_PARAMETER_NAME, sharePart.getSharePartId());
		request.setAttribute(SHAREPARTGUID_PARAMETER_NAME, sharePart.getSharePartGuid());
		request.setAttribute(SHAREPARTNAME_PARAMETER_NAME, sharePart.getName());
		request.setAttribute(SHAREPARTPRICE_PARAMETER_NAME, sharePart.getPrice());
		request.setAttribute(SHAREPARTCOUNT_PARAMETER_NAME, sharePart.getCount());
		request.setAttribute(SHAREPARTDESCRIPTION_PARAMETER_NAME, sharePart.getDescription());
	}
	
	public static void setShareParts(HttpServletRequest request, Set<SharePart> shareParts) {
		request.setAttribute(SHAREPARTS_ATTRIBUTE_NAME, shareParts);
	}
	
	public static Set<SharePart> getSelectedShareParts(HttpServletRequest request, CarServiceBl carServiceBl) throws SQLException {
		Set<SharePart> selectedShareParts = new HashSet<SharePart>();
		String[] selectedParameters = request.getParameterValues(ISSELECTED_PARAMETER_NAME);
		if (selectedParameters != null) {
			for (String parameter : selectedParameters) {
				UUID sharePartGuid = UUID.fromString(parameter);
				SharePart sharePart = carServiceBl.getSharePart(sharePartGuid);
				selectedShareParts.add(sharePart);
			}
		}
		return selectedShareParts;
	}
}
