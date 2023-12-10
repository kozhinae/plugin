import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MyBot extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        @Nullable Editor editor = e.getData(PlatformDataKeys.EDITOR);
        String selectedText = editor.getSelectionModel().getSelectedText();
        if (selectedText != null) {
            // Copy the selected text to the clipboard
            StringSelection selection = new StringSelection(selectedText);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

            // Open the Telegram bot site in the browser
            String url = "https://web.telegram.org/a/#6500502572";
            BrowserUtil.browse(url);
        } else {
            Messages.showMessageDialog("Selection is empty, select code", "OpenTgBot Action", Messages.getInformationIcon());
        }
    }
}
