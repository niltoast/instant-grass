package niltoast.instant_grass;

import net.fabricmc.api.ModInitializer;

import niltoast.instant_grass.item.InstantGrassItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstantGrass implements ModInitializer {
	public static final String MOD_ID = "instant-grass";
    public static final Logger LOGGER = LoggerFactory.getLogger("instant-grass");

	@Override
	public void onInitialize() {
		InstantGrassItems.registerItems();
		LOGGER.info("Hello Fabric world!");
	}
}