package owiegamer.owies_airport_pack_neoforge.item.custom;

import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
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
import org.slf4j.Logger;
import owiegamer.owies_airport_pack_neoforge.block.ModBlocks;

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


       if(!level.isClientSide){

           // this checks if you clicked on a pain bucket
           if (clickedBlock == ModBlocks.PAINTBUCKETYELLOW.get()) {
               LOGGER.info("Was Paint Bucket");
           }
           else {
               level.setBlockAndUpdate(context.getClickedPos().above(), ModBlocks.PAINTLINEYELLOW.get().defaultBlockState());
               level.playSound(null, context.getClickedPos(), SoundEvents.SLIME_BLOCK_HIT, SoundSource.BLOCKS);
           }
        }


        return InteractionResult.SUCCESS;
    }
}
