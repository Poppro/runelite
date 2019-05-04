package net.runelite.client.plugins.bank;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public enum BankedXpEnums
{
	HERBLORE(Skill.HERBLORE,
			new HashMap<Integer, Double>() {
		{
			put(ItemID.GUAM_LEAF, 2.5+25);
			put(ItemID.GRIMY_GUAM_LEAF, 25.0);
			put(ItemID.MARRENTILL, 42.5);
			put(ItemID.GRIMY_MARRENTILL, 42.5+3.8);
			put(ItemID.TARROMIN, 55.0);
			put(ItemID.GRIMY_TARROMIN, 55.0+5.0);
			put(ItemID.HARRALANDER, 84.0);
			put(ItemID.GRIMY_HARRALANDER, 84.0+6.3);
			put(ItemID.RANARR_WEED, 87.5);
			put(ItemID.GRIMY_RANARR_WEED, 7.5+87.5);
			put(ItemID.TOADFLAX, 180.0);
			put(ItemID.GRIMY_TOADFLAX, 180.0+8.0);
			put(ItemID.IRIT_LEAF, 100.0);
			put(ItemID.GRIMY_IRIT_LEAF, 100.0+8.8);
			put(ItemID.AVANTOE, 117.5);
			put(ItemID.GRIMY_AVANTOE, 117.5+10.0);
			put(ItemID.KWUARM, 125.0);
			put(ItemID.GRIMY_KWUARM, 125.0+11.3);
			put(ItemID.SNAPDRAGON, 142.5);
			put(ItemID.GRIMY_SNAPDRAGON, 142.5+11.8);
			put(ItemID.CADANTINE, 150.0);
			put(ItemID.GRIMY_CADANTINE, 150.0+12.5);
			put(ItemID.LANTADYME, 172.5);
			put(ItemID.GRIMY_LANTADYME, 13.1+172.5);
			put(ItemID.DWARF_WEED, 162.5);
			put(ItemID.GRIMY_DWARF_WEED, 162.5+13.8);
			put(ItemID.TORSTOL, 150.0);
			put(ItemID.GRIMY_TORSTOL, 150.0+15.0);
		}
	}),

	CONSTRUCTION(Skill.CONSTRUCTION,
			new HashMap<Integer, Double>() {
		{
			put(ItemID.PLANK, 29.0);
			put(ItemID.OAK_PLANK, 60.0);
			put(ItemID.TEAK_PLANK, 123.3333);
			put(ItemID.MAHOGANY_PLANK, 140.0);
		}
	});

	private final Skill skill;
	private final Map<Integer, Double> xpMap;
}
