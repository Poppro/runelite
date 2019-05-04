package net.runelite.client.plugins.bank;

import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.ColorScheme;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

class BankXpOverviewPanel extends JPanel
{
        BankXpOverviewPanel(BankPanel bankPanel, SkillIconManager iconManager)
        {
            setLayout(new GridLayout(0, 1, 0, 5));
            setBackground(ColorScheme.DARK_GRAY_COLOR);
            setBorder(new EmptyBorder(5, 0, 5, 5));

            for(Tab tab : Tab.values())
                if(tab != Tab.OVERVIEW)
                {
                    tab.setGridItem(new BankXpGridItem(tab, bankPanel, iconManager));
                    add(tab.getGridItem());
                }
        }
}
