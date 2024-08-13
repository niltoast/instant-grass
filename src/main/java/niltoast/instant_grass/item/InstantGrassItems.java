package niltoast.instant_grass.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import niltoast.instant_grass.InstantGrass;
import niltoast.instant_grass.item.custom.InstantGrassItem;

public class InstantGrassItems {
    public static final Item INSTANT_GRASS = new InstantGrassItem(new Item.Settings().maxCount(1).maxDamage(30));

    public static void registerItems() {
        register(INSTANT_GRASS, "instant_grass");
    }

    private static void register(Item item, String name) {
        Identifier identifier = Identifier.of(InstantGrass.MOD_ID, name);
        Registry.register(Registries.ITEM, identifier, item);
    }

}
