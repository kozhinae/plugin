import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class tgAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        @Nullable Editor editor = e.getData(PlatformDataKeys.EDITOR);
        String selectedText = editor.getSelectionModel().getSelectedText();
        String encoded;
        encoded = URLEncoder.encode(selectedText, StandardCharsets.UTF_8);
        String url = String.format("https://t.me/katya_kozhina", encoded);

    }
}
