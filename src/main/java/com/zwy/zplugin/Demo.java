package com.zwy.zplugin;

import com.intellij.ide.BrowserUtil;
import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;

/**
 * @author wenyang.zhang
 * @version 2023/4/6
 */
public class Demo extends AnAction {
	@Override
	public void actionPerformed(AnActionEvent e) {

		PsiFile file = e.getData(CommonDataKeys.PSI_FILE);
		Language lang = e.getData(CommonDataKeys.PSI_FILE).getLanguage();
		String languageTag = "+[" + lang.getDisplayName().toLowerCase() + "]";

		Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
		CaretModel caretModel = editor.getCaretModel();
		String selectedText = caretModel.getCurrentCaret().getSelectedText();

		String query = selectedText.replace(' ', '+') + languageTag;
		BrowserUtil.browse("https://stackoverflow.com/search?q=" + query);
	}

	@Override
	public void update(AnActionEvent e) {
//		Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
//		CaretModel caretModel = editor.getCaretModel();
//		e.getPresentation().setEnabledAndVisible(caretModel.getCurrentCaret().hasSelection());
	}
}
