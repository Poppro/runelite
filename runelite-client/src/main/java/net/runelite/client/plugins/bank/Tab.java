package net.runelite.client.plugins.bank;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Skill;

@RequiredArgsConstructor
@Getter
public enum Tab
{
    OVERVIEW("Overview", null),
    CONSTRUCTION("Construction", Skill.CONSTRUCTION),
    HERBLORE("Herblore", Skill.HERBLORE);

    private final String name;
    private final Skill skill;
}
