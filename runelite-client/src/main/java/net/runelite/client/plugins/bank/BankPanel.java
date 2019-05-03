package net.runelite.client.plugins.bank;

import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;


class BankPanel extends PluginPanel
{

    private final JPanel display = new JPanel();
    private final SkillIconManager iconManager = new SkillIconManager();
    private final MaterialTabGroup tabGroup = new MaterialTabGroup(display);
    private final Map<Tab, MaterialTab> uiTabs = new HashMap<>();

    BankPanel()
    {
        super(false);

        setLayout(new BorderLayout());
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        display.setBorder(new EmptyBorder(7,6,7,0));
        display.setLayout(new DynamicGridLayout());

        add(display, BorderLayout.CENTER);

        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        display.add(welcomePanel);

        JLabel loginLabel = new JLabel("Please open your bank.");
        loginLabel.setFont(FontManager.getRunescapeFont());
        loginLabel.setForeground(Color.white);
        loginLabel.setHorizontalAlignment(JLabel.CENTER);
        loginLabel.setVerticalAlignment(JLabel.CENTER);
        welcomePanel.add(loginLabel, BorderLayout.CENTER);
    }

    private void addTab(Tab tab, JPanel tabContentPanel)
    {
        JPanel wrapped = new JPanel(new BorderLayout());
        wrapped.add(tabContentPanel, BorderLayout.NORTH);
        wrapped.setBackground(ColorScheme.DARK_GRAY_COLOR);

        JScrollPane scroller = new JScrollPane(wrapped);
        scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
        scroller.getVerticalScrollBar().setBorder(new EmptyBorder(0, 6, 0, 0));
        scroller.setBackground(ColorScheme.DARK_GRAY_COLOR);

        MaterialTab materialTab = new MaterialTab(new ImageIcon(), tabGroup, scroller);
        materialTab.setName(tab.getName());
        materialTab.setToolTipText(tab.getName());

        materialTab.setOnSelectEvent(() ->
        {
           //tabContentPanel.update();
            return true;
        });

        uiTabs.put(tab, materialTab);
        tabGroup.addTab(materialTab);
    }

    void init()
    {
        uiTabs.clear();
        tabGroup.removeAll();
        addTab(Tab.OVERVIEW, new BankXpOverviewPanel(this, iconManager));
        addTab(Tab.CONSTRUCTION, new BankXpConstructionPanel(this));
        addTab(Tab.HERBLORE, new BankXpHerblorePanel(this));
    }

    void switchTab(Tab tab)
    {
        tabGroup.select(uiTabs.get(tab));
    }
}
