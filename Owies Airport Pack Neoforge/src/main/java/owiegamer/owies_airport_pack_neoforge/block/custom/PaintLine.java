package owiegamer.owies_airport_pack_neoforge.block.custom;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.RedstoneSide;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import owiegamer.owies_airport_pack_neoforge.block.ModBlocks;

import static owiegamer.owies_airport_pack_neoforge.block.ModBlocks.PAINTLINEYELLOW;

public class PaintLine extends Block {
    private static final Logger LOGGER = LogUtils.getLogger();


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.NORTH, BlockStateProperties.SOUTH,
                BlockStateProperties.EAST, BlockStateProperties.WEST);
    }

// this checks if a neighbor has changed and stores it so it can be used later
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
        Direction updateDir = Direction.getNearest(Vec3.atLowerCornerOf(neighborPos.subtract(pos)));

        // This makes shore that the block is another painlineblock
        if (neighborBlock == PaintLine.this) {
            // then does whatever right now just prints something as a test
            LOGGER.info("Block Updated By other block of" + PaintLine.this + neighborPos + updateDir);
             if (updateDir == Direction.NORTH) {

             }
            if (updateDir == Direction.SOUTH) {

            }
            if (updateDir == Direction.EAST) {

            }
            if (updateDir == Direction.WEST) {

            }
        }
    }


    public PaintLine(Properties properties) {
        super(properties);
    }
}
