package owiegamer.owies_airport_pack_neoforge.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import owiegamer.owies_airport_pack_neoforge.OwiesAirportPackNeoforge;
import owiegamer.owies_airport_pack_neoforge.item.custom.LineBrushItem;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(OwiesAirportPackNeoforge.MOD_ID);


    public static final DeferredItem<Item> LINEBRUSH = ITEMS.register("line_brush",
            () -> new LineBrushItem(new Item.Properties().stacksTo(1)));



    public  static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);



    }
}
