package net.runelite.client.plugins.bosslog;

import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ImageUtil;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.Locale;

class BossLogDropBox extends JPanel
{
	BossLogDropBox(ItemManager itemManager, BossLogItem item, boolean isUnique)
	{
		setBackground(ColorScheme.DARKER_GRAY_COLOR);
		setMaximumSize(new Dimension(45, 42));
		setPreferredSize(new Dimension(45, 42));

		JLabel iconLabel = new JLabel();
		iconLabel.setToolTipText(buildToolTip(item));
		iconLabel.setIcon(new ImageIcon());
		AsyncBufferedImage icon;
		if (isUnique && item.getQuantity() == 0)
		{
			icon = itemManager.getImage(item.getId());
			Runnable alphasize = () ->
			{
				ImageIcon itemIcon = new ImageIcon(ImageUtil.alphaOffset(icon, -180));
				iconLabel.setIcon(itemIcon);
			};
			icon.onChanged(alphasize);
			alphasize.run();
		}
		else
		{
			icon = itemManager.getImage(item.getId(), item.getQuantity(), item.getQuantity() > 0);
			icon.addTo(iconLabel);
		}
		add(iconLabel);
	}

	private static String buildToolTip(BossLogItem item)
	{
		final String name = item.getName();
		final int quantity = item.getQuantity();
		final long price = item.getPrice();
		return name + " x " + quantity + " ("
				+ NumberFormat.getNumberInstance(Locale.US).format(price * quantity) + ") ";
	}
}
