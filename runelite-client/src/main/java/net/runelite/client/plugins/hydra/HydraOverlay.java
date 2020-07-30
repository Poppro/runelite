package net.runelite.client.plugins.hydra;

import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Skill;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class HydraOverlay extends Overlay {
    private static final Color COLOR_ICON_BACKGROUND = new Color(0, 0, 0, 128);
    private static final Color COLOR_ICON_BORDER = new Color(0, 0, 0, 255);
    private static final Color COLOR_ICON_BORDER_FILL = new Color(219, 175, 0, 255);

    private Client client;
    private HydraPlugin plugin;

    @Inject
    private SkillIconManager iconManager;

    @Inject
    public HydraOverlay(Client client, HydraPlugin plugin)
    {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.client = client;
        this.plugin = plugin;
    }

    private BufferedImage getIcon(AlchemicalHydra.AttackStyle attackStyle)
    {
        switch (attackStyle)
        {
            case RANGED: return iconManager.getSkillImage(Skill.RANGED);
            case MAGIC: return iconManager.getSkillImage(Skill.MAGIC);
        }
        return null;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        AlchemicalHydra hydra = plugin.getHydra();
        if (hydra.getNpc().getInteracting() == null)
            return null;
        LocalPoint lp = hydra.getNpc().getLocalLocation();
        if (lp != null) {
            Point point = Perspective.localToCanvas(client, lp, client.getPlane(),
                    hydra.getNpc().getLogicalHeight() + 16);
            if (point != null) {
                point = new Point(point.getX(), point.getY());

                AlchemicalHydra.AttackStyle nextAttack = hydra.getNextAttack();
                BufferedImage icon = getIcon(nextAttack);
                int bgPadding = 4;
                int currentPosX = 0;
                graphics.setStroke(new BasicStroke(2));
                graphics.setColor(COLOR_ICON_BACKGROUND);
                graphics.fillOval(
                        point.getX() + currentPosX - bgPadding,
                        point.getY() - icon.getHeight() / 2 - bgPadding,
                        icon.getWidth() + bgPadding * 2,
                        icon.getHeight() + bgPadding * 2);

                graphics.setColor(COLOR_ICON_BORDER);
                graphics.drawOval(
                        point.getX() - icon.getWidth() / 2 + currentPosX - bgPadding,
                        point.getY() - icon.getHeight() / 2 - bgPadding,
                        icon.getWidth() + bgPadding * 2,
                        icon.getHeight() + bgPadding * 2);

                graphics.drawImage(
                        icon,
                        point.getX() - icon.getWidth() / 2 + currentPosX,
                        point.getY() - icon.getHeight() / 2,
                        null);

                graphics.setColor(COLOR_ICON_BORDER_FILL);
            }
        }
        return null;
    }
}
