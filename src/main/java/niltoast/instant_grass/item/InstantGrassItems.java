package niltoast.instant_grass.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import niltoast.instant_grass.InstantGrass;
import niltoast.instant_grass.item.custom.InstantGrassItem;

public class InstantGrassItems {
    public static final Item INSTANT_GRASS = new InstantGrassItem(new Item.Settings().maxCount(1).maxDamage(45));

    public static void registerItems() {
        register(INSTANT_GRASS, "instant_grass");
    }

    private static void instantGrassItems(FabricItemGroupEntries entries) {
        entries.add(INSTANT_GRASS);
    }

    private static void register(Item item, String name) {
        Identifier identifier = Identifier.of(InstantGrass.MOD_ID, name);
        Registry.register(Registries.ITEM, identifier, item);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(InstantGrassItems::instantGrassItems);
    }
}
