package net.runelite.client.plugins.hydra;

import lombok.Getter;
import lombok.Setter;
import net.runelite.api.NPC;

class AlchemicalHydra {
    private static final int ATTACKS_PER_SWITCH = 3; // 3 unsuccessful attacks per style switch

    enum AttackStyle
    {
        MAGIC,
        RANGED
    }

    enum Phase
    {
        GREEN,
        BLUE,
        RED,
        JAD
    }

    @Getter
    private NPC npc;

    @Getter
    @Setter
    private int attacksUntilSwitch;

    @Getter
    @Setter
    Phase phase;

    @Getter
    @Setter
    private AttackStyle nextAttack;

    @Getter
    @Setter
    private int recentProjectileId;

    AlchemicalHydra(NPC npc) {
        this.npc = npc;
        this.recentProjectileId = -1;
        this.attacksUntilSwitch = ATTACKS_PER_SWITCH;
    }
}
