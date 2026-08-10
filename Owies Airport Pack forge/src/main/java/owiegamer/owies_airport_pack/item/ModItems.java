package owiegamer.owies_airport_pack.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import owiegamer.owies_airport_pack.Owies_airport_pack;

public class ModItems {

    // Create DeferredRegister for Items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Owies_airport_pack.MOD_ID);

    // Example item (you can remove if not needed)
    // public static final RegistryObject<Item> TEST_ITEM =
    //         ITEMS.register("test_item",
    //                 () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}