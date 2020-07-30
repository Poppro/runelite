package net.runelite.client.plugins.hydra;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
        name = "Alchemical Hydra",
        description = "Alchemical Hydraa Helper",
        tags = {"combat", "overlay", "pve", "pvm"}
)

public class HydraPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private HydraOverlay overlay;

    @Inject
    private ClientThread clientThread;

    @Getter
    private AlchemicalHydra hydra;

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(overlay);
        clientThread.invoke(this::reset); // Updates the list of gorillas and players
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(overlay);
    }

    private void clear() {
    }

    private void reset() {
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned event)
    {
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
    }
}