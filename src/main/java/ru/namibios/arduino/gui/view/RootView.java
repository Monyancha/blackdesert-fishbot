package ru.namibios.arduino.gui.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import ru.namibios.arduino.Transfer;
import ru.namibios.arduino.config.Message;
import ru.namibios.arduino.config.Path;
import ru.namibios.arduino.config.TextAreaAppender;
import ru.namibios.arduino.gui.CheckUpdate;
import ru.namibios.arduino.gui.DynamicData;
import ru.namibios.arduino.gui.UI;
import ru.namibios.arduino.gui.controller.SettingsController;
import ru.namibios.arduino.gui.controller.StartController;
import ru.namibios.arduino.gui.controller.StopController;
import ru.namibios.arduino.gui.controller.TestController;
import ru.namibios.arduino.utils.AppUtils;
import ru.namibios.arduino.utils.ExecUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class RootView extends JFrame {

    private static final Logger LOG = Logger.getLogger(RootView.class);

    private JPanel contentPane;
    private JButton buttonStart;
    private JButton buttonStop;
    private JTextArea taLog;
    private JScrollPane scrollPane;
    private JPanel buttonPanel;
    private JLabel mouseXY;
    private JButton buttonTest;

    public RootView() {

        Transfer transfer = new Transfer();

        setTitle("Fish bot_" + AppUtils.getVersion());

        setContentPane(contentPane);
        setAlwaysOnTop(true);
        setLocation(0, 400);
        setSize(new Dimension(520, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image im = new ImageIcon(Path.ROOT_ICON).getImage();
        setIconImage(im);

        getRootPane().setDefaultButton(buttonStart);

        TextAreaAppender appender = new TextAreaAppender(taLog);
        appender.setLayout(new PatternLayout("[%d{dd.MM.yyyy HH:mm:ss}] - %m%n"));
        LogManager.getRootLogger().addAppender(appender);

        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu(UIManager.getString("rootview.menu.file"));

        JMenuItem preference = new JMenuItem(UIManager.getString("rootview.menu.file.preference"));
        preference.setIcon(new ImageIcon(UI.IMG_SETTINGS));
        preference.addActionListener(new SettingsController());
        file.add(preference);

        file.addSeparator();

        JMenuItem exit = new JMenuItem(UIManager.getString("rootview.menu.file.close"));
        exit.setIcon(new ImageIcon(UI.IMG_CLOSE));
        exit.addActionListener((e) -> System.exit(1));
        file.add(exit);

        JMenu help = new JMenu(UIManager.getString("rootview.menu.help"));

        JMenuItem wiki = new JMenuItem(UIManager.getString("rootview.menu.help.wiki"));
        wiki.setIcon(new ImageIcon(UI.IMG_WIKI));
        wiki.addActionListener((e) -> ExecUtils.openUri(Message.URI_WIKI));
        help.add(wiki);

        JMenuItem feedback = new JMenuItem(UIManager.getString("rootview.menu.help.feedback"));
        feedback.setIcon(new ImageIcon(UI.IMG_FEEDBACK));
        feedback.addActionListener((e) -> ExecUtils.openUri(Message.URI_REPORT_PROBLEM));
        help.add(feedback);

        menuBar.add(file);
        menuBar.add(help);

        setJMenuBar(menuBar);

        new DynamicData(mouseXY).start();

        buttonStart.addActionListener(new StartController(transfer, this));
        buttonStart.setIcon(new ImageIcon(UI.IMG_PLAY));

        buttonStop.addActionListener(new StopController(transfer));
        buttonStop.setIcon(new ImageIcon(UI.IMG_STOP));

        buttonTest.addActionListener(new TestController());

        addWindowListener(new CheckUpdate(this));
//        addWindowListener(new Info(this));

        setVisible(true);
        setResizable(false);

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayoutManager(2, 1, new Insets(10, 10, 10, 10), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(buttonPanel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonStart = new JButton();
        this.$$$loadButtonText$$$(buttonStart, ResourceBundle.getBundle("locale").getString("rootview.button.start"));
        buttonPanel.add(buttonStart, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonStop = new JButton();
        this.$$$loadButtonText$$$(buttonStop, ResourceBundle.getBundle("locale").getString("rootview.button.stop"));
        buttonPanel.add(buttonStop, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonTest = new JButton();
        buttonTest.setText("Тест");
        buttonPanel.add(buttonTest, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mouseXY = new JLabel();
        mouseXY.setText("Point");
        panel1.add(mouseXY, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        scrollPane = new JScrollPane();
        panel2.add(scrollPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        taLog = new JTextArea();
        taLog.setBackground(new Color(-16777216));
        taLog.setEditable(false);
        Font taLogFont = this.$$$getFont$$$("DejaVu Sans", -1, 11, taLog.getFont());
        if (taLogFont != null) taLog.setFont(taLogFont);
        taLog.setForeground(new Color(-16711936));
        scrollPane.setViewportView(taLog);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    private void $$$loadButtonText$$$(AbstractButton component, String text) {
        StringBuffer result = new StringBuffer();
        boolean haveMnemonic = false;
        char mnemonic = '\0';
        int mnemonicIndex = -1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '&') {
                i++;
                if (i == text.length()) break;
                if (!haveMnemonic && text.charAt(i) != '&') {
                    haveMnemonic = true;
                    mnemonic = text.charAt(i);
                    mnemonicIndex = result.length();
                }
            }
            result.append(text.charAt(i));
        }
        component.setText(result.toString());
        if (haveMnemonic) {
            component.setMnemonic(mnemonic);
            component.setDisplayedMnemonicIndex(mnemonicIndex);
        }
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}