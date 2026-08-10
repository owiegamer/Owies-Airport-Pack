package owiegamer.owies_airport_pack_neoforge.item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import owiegamer.owies_airport_pack_neoforge.OwiesAirportPackNeoforge;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(OwiesAirportPackNeoforge.MOD_ID);






    public  static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);



    }
}
