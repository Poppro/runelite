package net.runelite.client.plugins.bank;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.runelite.api.Skill;

import javax.swing.JFrame;
import javax.swing.JPanel;

@RequiredArgsConstructor
@Getter
public enum Tab
{
    OVERVIEW("Overview", null, null),
    CONSTRUCTION("Construction", Skill.CONSTRUCTION, BankedXpEnums.CONSTRUCTION),
    HERBLORE("Herblore", Skill.HERBLORE, BankedXpEnums.HERBLORE);

    private final String name;
    private final Skill skill;
    private final BankedXpEnums data;

    @Setter
    private BankXpGridItem gridItem;
}
