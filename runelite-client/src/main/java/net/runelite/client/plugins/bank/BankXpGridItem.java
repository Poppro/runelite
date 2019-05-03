package net.runelite.client.plugins.bank;

import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.timetracking.TimeTrackingPlugin;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.ImageUtil;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class BankXpGridItem extends JPanel
{
    private static final ImageIcon ARROW_RIGHT_ICON
            = new ImageIcon(ImageUtil.getResourceStreamFromClass(TimeTrackingPlugin.class, "/util/arrow_right.png"));

    private static final Color HOVER_COLOR = ColorScheme.DARKER_GRAY_HOVER_COLOR;

    BankXpGridItem(Tab tab, BankPanel bankPanel, SkillIconManager iconManager)
    {
        setLayout(new BorderLayout());
        setBackground(ColorScheme.DARKER_GRAY_COLOR);
        setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel iconLabel = new JLabel();
        iconLabel.setMinimumSize(new Dimension(36, 32));
        iconLabel.setIcon(new ImageIcon(iconManager.getSkillImage(tab.getSkill(), false)));
        add(iconLabel, BorderLayout.WEST);

        JLabel statusLabel = new JLabel(tab.getName());
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setFont(FontManager.getRunescapeFont());

        JPanel textContainer = new JPanel();
        textContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        textContainer.setLayout(new GridLayout(0, 1));
        textContainer.setBorder(new EmptyBorder(5, 7, 5, 7));

        addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                bankPanel.switchTab(tab);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                setBackground(ColorScheme.DARKER_GRAY_COLOR);
                textContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                setBackground(HOVER_COLOR);
                textContainer.setBackground(HOVER_COLOR);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                setBackground(HOVER_COLOR);
                textContainer.setBackground(HOVER_COLOR);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                setBackground(ColorScheme.DARKER_GRAY_COLOR);
                textContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        textContainer.add(statusLabel);

        add(textContainer, BorderLayout.CENTER);

        JLabel arrowLabel = new JLabel(ARROW_RIGHT_ICON);
        add(arrowLabel, BorderLayout.EAST);
    }
}
