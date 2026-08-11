package owiegamer.owies_airport_pack_neoforge.item.custom;

import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;
import org.slf4j.Logger;
import owiegamer.owies_airport_pack_neoforge.block.ModBlocks;
import owiegamer.owies_airport_pack_neoforge.component.ModDataComponents;

import java.util.Map;

public class LineBrushItem extends Item {
    private static final Logger LOGGER = LogUtils.getLogger();
    public LineBrushItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        ItemStack stack = context.getItemInHand();
        String paintType = stack.getOrDefault(ModDataComponents.PAINTTYPE.get(), "");

       if(!level.isClientSide){

           // this checks if you clicked on a paint bucket
           if (clickedBlock == ModBlocks.PAINTBUCKETYELLOW.get()) {
               LOGGER.info("Was Paint Bucket");
               level.playSound(null, context.getClickedPos(), SoundEvents.GENERIC_SPLASH, SoundSource.BLOCKS);
               context.getItemInHand().set(ModDataComponents.PAINTTYPE.get(), "yellow_paint");



           } else if (clickedBlock == ModBlocks.PAINTBUCKETWHITE.get()) {
               level.playSound(null, context.getClickedPos(), SoundEvents.GENERIC_SPLASH, SoundSource.BLOCKS);
               context.getItemInHand().set(ModDataComponents.PAINTTYPE.get(), "white_paint");
           }
           else {
               if (context.getLevel().getBlockState(context.getClickedPos().above()).is(Blocks.AIR)) {
                   if (paintType.equals("yellow_paint")) {
                       if (context.getLevel().getBlockState(context.getClickedPos()).is(ModBlocks.PAINTLINEYELLOW.get())) {
                           level.playSound(null, context.getClickedPos(), SoundEvents.SLIME_BLOCK_HIT, SoundSource.BLOCKS);
                       }
                       else if (context.getLevel().getBlockState(context.getClickedPos()).is(ModBlocks.PAINTLINEWHITE.get())) {
                           level.playSound(null, context.getClickedPos(), SoundEvents.SLIME_BLOCK_HIT, SoundSource.BLOCKS);
                       }
                       else {
                           BlockPos linePos = context.getClickedPos().above();
                           level.setBlockAndUpdate(linePos, ModBlocks.PAINTLINEYELLOW.get().defaultBlockState());
                           level.updateNeighborsAt(linePos, ModBlocks.PAINTLINEYELLOW.get());
                           level.playSound(null, context.getClickedPos(), SoundEvents.SLIME_BLOCK_HIT, SoundSource.BLOCKS);
                       }
                   }
                   if (paintType.equals("white_paint")) {

                       if (context.getLevel().getBlockState(context.getClickedPos()).is(ModBlocks.PAINTLINEWHITE.get())) {
                           level.playSound(null, context.getClickedPos(), SoundEvents.SLIME_BLOCK_HIT, SoundSource.BLOCKS);
                       }
                       else if (context.getLevel().getBlockState(context.getClickedPos()).is(ModBlocks.PAINTLINEYELLOW.get())) {
                           level.playSound(null, context.getClickedPos(), SoundEvents.SLIME_BLOCK_HIT, SoundSource.BLOCKS);
                       }
                       else
                       {
                           BlockPos linePos = context.getClickedPos().above();
                           level.setBlockAndUpdate(linePos, ModBlocks.PAINTLINEWHITE.get().defaultBlockState());
                           level.updateNeighborsAt(linePos, ModBlocks.PAINTLINEWHITE.get());
                           level.playSound(null, context.getClickedPos(), SoundEvents.SLIME_BLOCK_HIT, SoundSource.BLOCKS);
                       }
                   }
               }
           }
        }


        return InteractionResult.SUCCESS;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        // Check if the player is sneaking (holding shift)
        if (player.isShiftKeyDown()) {
            if (!level.isClientSide()) {
                // FIX: Use itemstack instead of context, and set the data component
                itemstack.set(ModDataComponents.PAINTTYPE.get(), "");
            }
            // FIX: Return the modified itemstack so the game saves the changes
            return InteractionResultHolder.success(itemstack);
        }

        // Regular right-click logic (without shift)
        return InteractionResultHolder.pass(itemstack);
    }

}
