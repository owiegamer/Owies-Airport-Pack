package owiegamer.owies_airport_pack_neoforge.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import owiegamer.owies_airport_pack_neoforge.OwiesAirportPackNeoforge;
import owiegamer.owies_airport_pack_neoforge.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OwiesAirportPackNeoforge.MOD_ID);



    public static final Supplier<CreativeModeTab> OWIES_AIRPORT_PACK_NEOFORGE_BLOCK_TAB = CREATIVE_MODE_TAB.register("owies_airport_pack_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.GROUNDLIGHTRED))
                    .title(Component.translatable("creativetab.owies_airport_pack_neoforge.blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.GROUNDLIGHTRED);
                        output.accept(ModBlocks.GROUNDLIGHTGREEN);
                        output.accept(ModBlocks.GROUNDLIGHTBLUE);
                        output.accept(ModBlocks.GROUNDLIGHTWHITE);
                        output.accept(ModBlocks.ASPHALT);
                        output.accept(ModItems.LINEBRUSH);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
