package com.mengqingchang.myrcp;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea=layout.getEditorArea();
		layout.addView("com.mengqingchang.myrcp.view1", IPageLayout.LEFT,
				0.25f, editorArea);
		layout.addView("com.mengqingchang.myrcp.view2", IPageLayout.BOTTOM,
				0.75f, editorArea);

	}
}
