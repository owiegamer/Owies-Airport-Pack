package owiegamer.owies_airport_pack.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import owiegamer.owies_airport_pack.Owies_airport_pack;
import owiegamer.owies_airport_pack.block.custom.GroundLight;
import owiegamer.owies_airport_pack.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    // Create DeferredRegister for Blocks
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Owies_airport_pack.MOD_ID);


    public static final RegistryObject<Block> GROUNDLIGHTRED = registerBlock("ground_light_red",
            () -> new GroundLight(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .noOcclusion()
                    .sound(SoundType.METAL)
                    .lightLevel(state -> 15)
            ));

    public static final RegistryObject<Block> GROUNDLIGHTGREEN = registerBlock("ground_light_green",
            () -> new GroundLight(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .noOcclusion()
                    .sound(SoundType.METAL)
                    .lightLevel(state -> 15)
            ));



    // Generic block register method
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }





    // Register BlockItem
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Call this in your main mod class
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}