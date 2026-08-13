package owiegamer.owies_airport_pack_neoforge.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import owiegamer.owies_airport_pack_neoforge.OwiesAirportPackNeoforge;

import owiegamer.owies_airport_pack_neoforge.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, OwiesAirportPackNeoforge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GROUNDLIGHTGREEN.get())
                .add(ModBlocks.GROUNDLIGHTRED.get())
                .add(ModBlocks.GROUNDLIGHTBLUE.get())
                .add(ModBlocks.GROUNDLIGHTWHITE.get())
                .add(ModBlocks.PAINTBUCKETYELLOW.get())
                .add(ModBlocks.PAINTLINEWHITE.get())
                .add(ModBlocks.ASPHALT.get())
                .add(ModBlocks.RUNWAYCONCRETE.get());


        tag(BlockTags.MINEABLE_WITH_AXE);


        //tag(BlockTags.NEEDS_IRON_TOOL)


    }
}
