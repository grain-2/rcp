package com.mengqingchang.mymediaplayer;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.addView("com.mengqingchang.myMediaPlayer.view1", IPageLayout.LEFT,
				IPageLayout.RATIO_MAX, editorArea);
		//���ñ༭�����򲻿ɼ�
		layout.setEditorAreaVisible(false);
	}
}
