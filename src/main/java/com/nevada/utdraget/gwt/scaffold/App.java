package com.nevada.utdraget.gwt.scaffold;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;

public class App extends Composite {

	private static AppUiBinder uiBinder = GWT.create(AppUiBinder.class);

	interface AppUiBinder extends UiBinder<Widget, App> {
	}

	@UiField DeckPanel main;
	OutShell os = new OutShell();
	InShell is = new InShell();
	
	final int OUT = 0;
	final int IN = 1;
	
	public App() {
		initWidget(uiBinder.createAndBindUi(this));

		os.login.setListener(new Login.Listener() {
			public void onLoginClicked(String user) {
				main.showWidget(IN);
				is.setUser(user);
			}
		});
		
		is.top.setListener(new InTop.Listener() {
			public void onLogoutClicked() {
				main.showWidget(OUT);
			}
			public void onGraphClicked() {
			}
			public void onInputClicked() {				
			}
		});

		main.add(os);
		main.add(is);
		main.setAnimationEnabled(false);
		main.showWidget(OUT);
	}

}
