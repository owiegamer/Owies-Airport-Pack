package owiegamer.owies_airport_pack_neoforge.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import owiegamer.owies_airport_pack_neoforge.OwiesAirportPackNeoforge;
import owiegamer.owies_airport_pack_neoforge.block.custom.GroundLight;
import owiegamer.owies_airport_pack_neoforge.block.custom.PaintBucketBlock;
import owiegamer.owies_airport_pack_neoforge.block.custom.PaintLine;
import owiegamer.owies_airport_pack_neoforge.item.ModItems;



import java.util.function.Supplier;





    public class ModBlocks {
        public static final DeferredRegister.Blocks BLOCKS =
                DeferredRegister.createBlocks(OwiesAirportPackNeoforge.MOD_ID);

        public static final boolean ENABLE_SCREEN_RADIO_FEATURES = false;




        public static final DeferredBlock<GroundLight> GROUNDLIGHTRED = registerBlock("ground_light_red",
                () -> new GroundLight(BlockBehaviour.Properties.of()
                        .strength(4f)
                        .lightLevel(state -> 12)
                        .requiresCorrectToolForDrops()
                        .noOcclusion()
                        .sound(SoundType.METAL)));

        public static final DeferredBlock<GroundLight> GROUNDLIGHTGREEN = registerBlock("ground_light_green",
                () -> new GroundLight(BlockBehaviour.Properties.of()
                        .strength(4f)
                        .lightLevel(state -> 12)
                        .requiresCorrectToolForDrops()
                        .noOcclusion()
                        .sound(SoundType.METAL)));

        public static final DeferredBlock<GroundLight> GROUNDLIGHTBLUE = registerBlock("ground_light_blue",
                () -> new GroundLight(BlockBehaviour.Properties.of()
                        .strength(4f)
                        .lightLevel(state -> 12)
                        .requiresCorrectToolForDrops()
                        .noOcclusion()
                        .sound(SoundType.METAL)));

        public static final DeferredBlock<GroundLight> GROUNDLIGHTWHITE = registerBlock("ground_light_white",
                () -> new GroundLight(BlockBehaviour.Properties.of()
                        .strength(4f)
                        .lightLevel(state -> 12)
                        .requiresCorrectToolForDrops()
                        .noOcclusion()
                        .sound(SoundType.METAL)));

        public static final DeferredBlock<Block> ASPHALT = registerBlock("asphalt",
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(4f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));


        public static final DeferredBlock<PaintLine> PAINTLINEYELLOW = registerBlock("paint_line_yellow",
                () -> new PaintLine(BlockBehaviour.Properties.of()
                        .strength(4f)
                        .dynamicShape()
                        .requiresCorrectToolForDrops()
                        .noLootTable()
                        .noOcclusion()
                        .noCollission()
                        .instabreak()
                        .sound(SoundType.STONE)));

        public static final DeferredBlock<PaintLine> PAINTLINEWHITE = registerBlock("paint_line_white",
                () -> new PaintLine(BlockBehaviour.Properties.of()
                        .strength(4f)
                        .dynamicShape()
                        .requiresCorrectToolForDrops()
                        .noLootTable()
                        .noOcclusion()
                        .noCollission()
                        .instabreak()
                        .sound(SoundType.STONE)));

        public static final DeferredBlock<Block> PAINTBUCKETYELLOW = registerBlock("paint_bucket_yellow",
                () -> new PaintBucketBlock(BlockBehaviour.Properties.of()
                        .strength(4f)
                        .dynamicShape()
                        .noOcclusion()
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        public static final DeferredBlock<Block> PAINTBUCKETWHITE = registerBlock("paint_bucket_white",
                () -> new PaintBucketBlock(BlockBehaviour.Properties.of()
                        .strength(4f)
                        .dynamicShape()
                        .noOcclusion()
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

















        private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
            DeferredBlock<T> toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn);
            return toReturn;
        }


        private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
            ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }






        public  static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);



        }
    }


