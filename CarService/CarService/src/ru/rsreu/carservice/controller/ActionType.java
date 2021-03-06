package ru.rsreu.carservice.controller;

import ru.rsreu.carservice.controller.actions.GetAdminMenuPageAction;
import ru.rsreu.carservice.controller.actions.GetClientMenuPageAction;
import ru.rsreu.carservice.controller.actions.GetLoginPageAction;
import ru.rsreu.carservice.controller.actions.GetRegistrationPageAction;
import ru.rsreu.carservice.controller.actions.GetWorkerMenuPageAction;
import ru.rsreu.carservice.controller.actions.LogOutAction;
import ru.rsreu.carservice.controller.actions.LoginAction;
import ru.rsreu.carservice.controller.actions.RegisterAction;
import ru.rsreu.carservice.controller.actions.admins.AddAdminAction;
import ru.rsreu.carservice.controller.actions.admins.DeleteAdminAction;
import ru.rsreu.carservice.controller.actions.admins.GetAddAdminPageAction;
import ru.rsreu.carservice.controller.actions.admins.GetAllAdminsAction;
import ru.rsreu.carservice.controller.actions.admins.GetDeleteAdminPageAction;
import ru.rsreu.carservice.controller.actions.clients.AddClientAction;
import ru.rsreu.carservice.controller.actions.clients.DeleteClientAction;
import ru.rsreu.carservice.controller.actions.clients.EditClientAction;
import ru.rsreu.carservice.controller.actions.clients.GetAddClientPageAction;
import ru.rsreu.carservice.controller.actions.clients.GetAllClientsAction;
import ru.rsreu.carservice.controller.actions.clients.GetDeleteClientPageAction;
import ru.rsreu.carservice.controller.actions.clients.GetEditClientPageAction;
import ru.rsreu.carservice.controller.actions.clients.cars.AddCarAction;
import ru.rsreu.carservice.controller.actions.clients.cars.DeleteCarAction;
import ru.rsreu.carservice.controller.actions.clients.cars.GetAddCarPageAction;
import ru.rsreu.carservice.controller.actions.clients.cars.GetClientCarsPageAction;
import ru.rsreu.carservice.controller.actions.clients.cars.GetDeleteCarPageAction;
import ru.rsreu.carservice.controller.actions.orders.AddOrderAction;
import ru.rsreu.carservice.controller.actions.orders.AddOrderWorkersAction;
import ru.rsreu.carservice.controller.actions.orders.DeleteOrderAction;
import ru.rsreu.carservice.controller.actions.orders.DeleteOrderWorkersAction;
import ru.rsreu.carservice.controller.actions.orders.GetAllOrdersAction;
import ru.rsreu.carservice.controller.actions.orders.GetClientOrdersPageAction;
import ru.rsreu.carservice.controller.actions.orders.GetDeleteOrderPageAction;
import ru.rsreu.carservice.controller.actions.orders.GetFreeWorkersPageAction;
import ru.rsreu.carservice.controller.actions.orders.GetOrderWorkersPageAction;
import ru.rsreu.carservice.controller.actions.orders.GetAddOrderPageAction;
import ru.rsreu.carservice.controller.actions.orders.GetWorkerOrdersPageAction;
import ru.rsreu.carservice.controller.actions.orders.ResolveAction;
import ru.rsreu.carservice.controller.actions.orders.StartProgressAction;
import ru.rsreu.carservice.controller.actions.shareparts.AddSharePartAction;
import ru.rsreu.carservice.controller.actions.shareparts.DeleteSharePartAction;
import ru.rsreu.carservice.controller.actions.shareparts.EditSharePartAction;
import ru.rsreu.carservice.controller.actions.shareparts.GetAddSharePartPageAction;
import ru.rsreu.carservice.controller.actions.shareparts.GetAllSharePartsAction;
import ru.rsreu.carservice.controller.actions.shareparts.GetDeleteSharePartPageAction;
import ru.rsreu.carservice.controller.actions.shareparts.GetEditSharePartPageAction;
import ru.rsreu.carservice.controller.actions.workers.AddWorkerAction;
import ru.rsreu.carservice.controller.actions.workers.DeleteWorkerAction;
import ru.rsreu.carservice.controller.actions.workers.EditWorkerAction;
import ru.rsreu.carservice.controller.actions.workers.GetAllWorkersAction;
import ru.rsreu.carservice.controller.actions.workers.GetAddWorkerPageAction;
import ru.rsreu.carservice.controller.actions.workers.GetDeleteWorkerPageAction;
import ru.rsreu.carservice.controller.actions.workers.GetEditWorkerPageAction;
import ru.rsreu.carservice.controller.actions.works.AddWorkAction;
import ru.rsreu.carservice.controller.actions.works.DeleteWorkAction;
import ru.rsreu.carservice.controller.actions.works.EditWorkAction;
import ru.rsreu.carservice.controller.actions.works.GetAllWorksAction;
import ru.rsreu.carservice.controller.actions.works.GetDeleteWorkPageAction;
import ru.rsreu.carservice.controller.actions.works.GetEditWorkPageAction;
import ru.rsreu.carservice.controller.actions.works.GetAddWorkPageAction;

public enum ActionType {
	LOGIN {
		@Override
		public Action getAction() {
			return new LoginAction();
		}
	},
	LOGOUT {
		@Override
		public Action getAction() {
			return new LogOutAction();
		}
	},
	GETADMINMENU {
		@Override
		public Action getAction() {
			return new GetAdminMenuPageAction();
		}
	},
	GETALLORDERS {
		@Override
		public Action getAction() {
			return new GetAllOrdersAction();
		}
	},
	GETALLCLIENTS {
		@Override
		public Action getAction() {
			return new GetAllClientsAction();
		}
	},
	GETALLWORKERS {
		@Override
		public Action getAction() {
			return new GetAllWorkersAction();
		}
	},
	GETALLSHAREPARTS {
		@Override
		public Action getAction() {
			return new GetAllSharePartsAction();
		}
	},
	GETALLWORKS {
		@Override
		public Action getAction() {
			return new GetAllWorksAction();
		}
	},
	GETWORKERADDPAGE {
		@Override
		public Action getAction() {
			return new GetAddWorkerPageAction();
		}
	},
	ADDWORKER {
		@Override
		public Action getAction() {
			return new AddWorkerAction();
		}
	},
	GETWORKERDELETEPAGE {
		@Override
		public Action getAction() {
			return new GetDeleteWorkerPageAction();
		}
	},
	GETWORKEREDITPAGE {
		@Override
		public Action getAction() {
			return new GetEditWorkerPageAction();
		}
	},
	DELETEWORKER {
		@Override
		public Action getAction() {
			return new DeleteWorkerAction();
		}
	},
	EDITWORKER {
		@Override
		public Action getAction() {
			return new EditWorkerAction();
		}
	},
	GETWORKADDPAGE {
		@Override
		public Action getAction() {
			return new GetAddWorkPageAction();
		}
	},
	ADDWORK {
		@Override
		public Action getAction() {
			return new AddWorkAction();
		}
	},
	GETWORKDELETEPAGE {
		@Override
		public Action getAction() {
			return new GetDeleteWorkPageAction();
		}
	},
	GETWORKEDITPAGE {
		@Override
		public Action getAction() {
			return new GetEditWorkPageAction();
		}
	},
	DELETEWORK {
		@Override
		public Action getAction() {
			return new DeleteWorkAction();
		}
	},
	EDITWORK {
		@Override
		public Action getAction() {
			return new EditWorkAction();
		}
	},
	GETSHAREPARTADDPAGE {
		@Override
		public Action getAction() {
			return new GetAddSharePartPageAction();
		}
	},
	ADDSHAREPART {
		@Override
		public Action getAction() {
			return new AddSharePartAction();
		}
	},
	GETSHAREPARTDELETEPAGE {
		@Override
		public Action getAction() {
			return new GetDeleteSharePartPageAction();
		}
	},
	GETSHAREPARTEDITPAGE {
		@Override
		public Action getAction() {
			return new GetEditSharePartPageAction();
		}
	},
	DELETESHAREPART {
		@Override
		public Action getAction() {
			return new DeleteSharePartAction();
		}
	},
	EDITSHAREPART {
		@Override
		public Action getAction() {
			return new EditSharePartAction();
		}
	},
	GETCLIENTADDPAGE {
		@Override
		public Action getAction() {
			return new GetAddClientPageAction();
		}
	},
	ADDCLIENT {
		@Override
		public Action getAction() {
			return new AddClientAction();
		}
	},
	ADDCAR {
		@Override
		public Action getAction() {
			return new AddCarAction();
		}
	},
	GETCARADDPAGE {
		@Override
		public Action getAction() {
			return new GetAddCarPageAction();
		}
	},
	GETCLIENTCARSPAGE {
		@Override
		public Action getAction() {
			return new GetClientCarsPageAction();
		}
	},
	GETCARDELETEPAGE {
		@Override
		public Action getAction() {
			return new GetDeleteCarPageAction();
		}
	},
	DELETECAR {
		@Override
		public Action getAction() {
			return new DeleteCarAction();
		}
	},
	GETCLIENTDELETEPAGE {
		@Override
		public Action getAction() {
			return new GetDeleteClientPageAction();
		}
	},
	DELETECLIENT {
		@Override
		public Action getAction() {
			return new DeleteClientAction();
		}
	},
	GETCLIENTEDITPAGE {
		@Override
		public Action getAction() {
			return new GetEditClientPageAction();
		}
	},
	EDITCLIENT {
		@Override
		public Action getAction() {
			return new EditClientAction();
		}
	},
	GETFREEWORKERSPAGE {
		@Override
		public Action getAction() {
			return new GetFreeWorkersPageAction();
		}
	},
	ADDORDERWORKERS {
		@Override
		public Action getAction() {
			return new AddOrderWorkersAction();
		}
	},
	GETORDERWORKERSPAGE {
		@Override
		public Action getAction() {
			return new GetOrderWorkersPageAction();
		}
	},
	DELETEORDERWORKERS {
		@Override
		public Action getAction() {
			return new DeleteOrderWorkersAction();
		}
	},
	GETORDERDELETEPAGE {
		@Override
		public Action getAction() {
			return new GetDeleteOrderPageAction();
		}
	},
	DELETEORDER {
		@Override
		public Action getAction() {
			return new DeleteOrderAction();
		}
	},
	GETCLIENTORDERS {
		@Override
		public Action getAction() {
			return new GetClientOrdersPageAction();
		}
	},
	GETCLIENTMENU {
		@Override
		public Action getAction() {
			return new GetClientMenuPageAction();
		}
	},
	GETADDORDERPAGE {
		@Override
		public Action getAction() {
			return new GetAddOrderPageAction();
		}
	},
	ADDORDER {
		@Override
		public Action getAction() {
			return new AddOrderAction();
		}
	},
	GETLOGINPAGE {
		@Override
		public Action getAction() {
			return new GetLoginPageAction();
		}
	},
	GETWORKERMENU {
		@Override
		public Action getAction() {
			return new GetWorkerMenuPageAction();
		}
	},
	GETWORKERORDERS {
		@Override
		public Action getAction() {
			return new GetWorkerOrdersPageAction();
		}
	},
	STARTPROGRESS {
		@Override
		public Action getAction() {
			return new StartProgressAction();
		}
	},
	RESOLVE {
		@Override
		public Action getAction() {
			return new ResolveAction();
		}
	},
	GETREGISTRATIONPAGE {
		@Override
		public Action getAction() {
			return new GetRegistrationPageAction();
		}
	},
	REGISTER {
		@Override
		public Action getAction() {
			return new RegisterAction();
		}
	},
	GETALLADMINS {
		@Override
		public Action getAction() {
			return new GetAllAdminsAction();
		}
	},
	GETADMINADDPAGE {
		@Override
		public Action getAction() {
			return new GetAddAdminPageAction();
		}
	},
	ADDADMIN {
		@Override
		public Action getAction() {
			return new AddAdminAction();
		}
	},
	GETADMINDELETEPAGE {
		@Override
		public Action getAction() {
			return new GetDeleteAdminPageAction();
		}
	},
	DELETEADMIN {
		@Override
		public Action getAction() {
			return new DeleteAdminAction();
		}
	};
	public abstract Action getAction();
}
