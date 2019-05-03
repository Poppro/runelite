package net.runelite.client.plugins.bank;

import net.runelite.client.plugins.config.ConfigPanel;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.util.ImageUtil;

import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

class BankXpAbstractSkillPanel extends JPanel
{
    private JPanel navbar = new JPanel();
    private final BufferedImage backIcon = ImageUtil.getResourceStreamFromClass(ConfigPanel.class, "config_back_icon.png");
    private final BankPanel bankPanel;

    BankXpAbstractSkillPanel(BankPanel bossPanel)
    {
        this.bankPanel = bossPanel;
        setLayout(new DynamicGridLayout(0, 1, 0, 5));
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        setBorder(new EmptyBorder(5, 0, 5, 6));

        //back button
        navbar.setLayout(new DynamicGridLayout(1, 3, 0 , 0));
        navbar.setBorder(new EmptyBorder(0, 5, 5, 0));
        add(navbar);
        addBack();
    }

    private void addBack() {
        ImageIcon BACK_ICON = new ImageIcon(backIcon);
        ImageIcon BACK_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(backIcon, -100));

        JPanel contBB = new JPanel();
        contBB.setLayout(new BorderLayout());
        navbar.add(contBB, BorderLayout.WEST);

        JLabel back_button = new JLabel(BACK_ICON);
        contBB.add(back_button, BorderLayout.WEST);

        back_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                back_button.setIcon(BACK_ICON);
                bankPanel.switchTab(Tab.OVERVIEW);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                back_button.setIcon(BACK_ICON_HOVER);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                back_button.setIcon(BACK_ICON);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }
}
