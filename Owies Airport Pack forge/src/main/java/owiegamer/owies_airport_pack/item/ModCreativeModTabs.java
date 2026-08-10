package owiegamer.owies_airport_pack.item;


import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import owiegamer.owies_airport_pack.Owies_airport_pack;
import owiegamer.owies_airport_pack.block.ModBlocks;


public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Owies_airport_pack.MOD_ID);

    public static final RegistryObject<CreativeModeTab> OWIESAIRPORTPACKTAB = CREATIVE_MODE_TABS.register("owies_airport_pack_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.GROUNDLIGHTRED.get()))
                    .title(Component.translatable("creativetab.owies_airport_pack_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //pOutput.accept(ModItems.TEST.get());


                        pOutput.accept(ModBlocks.GROUNDLIGHTRED.get());
                        pOutput.accept(ModBlocks.GROUNDLIGHTGREEN.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}