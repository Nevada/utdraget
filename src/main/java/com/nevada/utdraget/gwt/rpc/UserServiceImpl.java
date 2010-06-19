package com.nevada.utdraget.gwt.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.nevada.utdraget.RegularUser;
import com.nevada.utdraget.gwt.scaffold.service.UserService;

public class UserServiceImpl extends RemoteServiceServlet implements UserService {

	private static final long serialVersionUID = 1L;

	public String getString() {
		RegularUser u = new RegularUser("Joe", "pass");
		u.persist();
		RegularUser u2 = new RegularUser("Dan", "pass");
		u2.persist();
		
		return "done";
	}

	@SuppressWarnings("unchecked")
	public Boolean userAlreadyExists(String user) {
		int i = RegularUser.findRegularUsersByName(user).getResultList().size();
		return (i > 0) ? true : false;
	}

	@Override
	public void addUser(String name, String password, String email) {
		RegularUser user = new RegularUser(name, password);
		user.setEmail(email);
		user.persist();
	}

	@Override
	public Boolean login(String name, String password) {
		int i = RegularUser.findRegularUsersByNameAndPw(name, password).getResultList().size();
		return (i > 0) ? true : false;
	}

}
