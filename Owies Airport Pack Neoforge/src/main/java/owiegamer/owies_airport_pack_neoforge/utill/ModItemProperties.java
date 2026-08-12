package owiegamer.owies_airport_pack_neoforge.utill;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import owiegamer.owies_airport_pack_neoforge.OwiesAirportPackNeoforge;
import owiegamer.owies_airport_pack_neoforge.component.ModDataComponents;
import owiegamer.owies_airport_pack_neoforge.item.ModItems;

public class ModItemProperties {

    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.LINEBRUSH.get(), ResourceLocation.fromNamespaceAndPath(OwiesAirportPackNeoforge.MOD_ID, "paint_type"),
                (stack, level, entity, seed) -> {
                    String paintType = stack.getOrDefault(ModDataComponents.PAINTTYPE.get(), "");

                    return switch (paintType) {
                        case "yellow_paint" -> 1f;
                        case "white_paint" -> 2f;
                        default -> 0f;
                    };
                });

    }

}
