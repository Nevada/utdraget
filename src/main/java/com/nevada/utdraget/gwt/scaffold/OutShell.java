package com.nevada.utdraget.gwt.scaffold;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;

public class OutShell extends Composite {

	private static VerticalShellUiBinder uiBinder = GWT
	.create(VerticalShellUiBinder.class);

	interface VerticalShellUiBinder extends UiBinder<Widget, OutShell> {
	}

	@UiField DeckPanel main;
	@UiField Top top;
	@UiField Login login;

	public OutShell() {
		initWidget(uiBinder.createAndBindUi(this));

		top.setListener(new Top.Listener() {
			public void onHowClicked() {
				main.showWidget(1);
			}
			public void onBloggClicked() {
				main.showWidget(2);
			}
			public void onPolicyClicked() {
				main.showWidget(3);
			}
			public void onAboutClicked() {
				main.showWidget(4);
			}
		});

//		Video v = new Video();
//		How h = new How();
//		Blogg b = new Blogg();
//		Policy p = new Policy();
//		About a = new About();
//		main.add(v);
//		main.add(h);
//		main.add(b);
//		main.add(p);
//		main.add(a);
		main.setAnimationEnabled(false);
		main.showWidget(0);
	}

}
