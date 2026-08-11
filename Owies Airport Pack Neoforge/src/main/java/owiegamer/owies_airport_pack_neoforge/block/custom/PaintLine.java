package owiegamer.owies_airport_pack_neoforge.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import owiegamer.owies_airport_pack_neoforge.block.ModBlocks;

public class PaintLine extends Block {
    private static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 0.1, 16.0);

    public PaintLine(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(BlockStateProperties.NORTH, false)
                .setValue(BlockStateProperties.SOUTH, false)
                .setValue(BlockStateProperties.EAST, false)
                .setValue(BlockStateProperties.WEST, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.NORTH, BlockStateProperties.SOUTH,
                BlockStateProperties.EAST, BlockStateProperties.WEST);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = this.defaultBlockState();
        BlockPos pos = context.getClickedPos();
        LevelAccessor level = context.getLevel();
        Block lineBlock = getLineBlock();

        boolean north = false;
        boolean south = false;
        boolean east = false;
        boolean west = false;

        if (level.getBlockState(pos.north()).is(lineBlock)) {
            north = true;
        }
        if (level.getBlockState(pos.south()).is(lineBlock)) {
            south = true;
        }
        if (level.getBlockState(pos.east()).is(lineBlock)) {
            east = true;
        }
        if (level.getBlockState(pos.west()).is(lineBlock)) {
            west = true;
        }

        if (north) {
            state = state.setValue(BlockStateProperties.NORTH, true);
        } else {
            state = state.setValue(BlockStateProperties.NORTH, false);
        }

        if (south) {
            state = state.setValue(BlockStateProperties.SOUTH, true);
        } else {
            state = state.setValue(BlockStateProperties.SOUTH, false);
        }

        if (east) {
            state = state.setValue(BlockStateProperties.EAST, true);
        } else {
            state = state.setValue(BlockStateProperties.EAST, false);
        }

        if (west) {
            state = state.setValue(BlockStateProperties.WEST, true);
        } else {
            state = state.setValue(BlockStateProperties.WEST, false);
        }

        return state;
    }

    private Block getLineBlock() {
        if (this == ModBlocks.PAINTLINEWHITE.get()) {
            return ModBlocks.PAINTLINEWHITE.get();
        }
        return ModBlocks.PAINTLINEYELLOW.get();
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        boolean north = false;
        boolean south = false;
        boolean east = false;
        boolean west = false;
        Block lineBlock = getLineBlock();

        if (level.getBlockState(pos.north()).is(lineBlock)) {
            north = true;
        }
        if (level.getBlockState(pos.south()).is(lineBlock)) {
            south = true;
        }
        if (level.getBlockState(pos.east()).is(lineBlock)) {
            east = true;
        }
        if (level.getBlockState(pos.west()).is(lineBlock)) {
            west = true;
        }

        if (north) {
            state = state.setValue(BlockStateProperties.NORTH, true);
        } else {
            state = state.setValue(BlockStateProperties.NORTH, false);
        }

        if (south) {
            state = state.setValue(BlockStateProperties.SOUTH, true);
        } else {
            state = state.setValue(BlockStateProperties.SOUTH, false);
        }

        if (east) {
            state = state.setValue(BlockStateProperties.EAST, true);
        } else {
            state = state.setValue(BlockStateProperties.EAST, false);
        }

        if (west) {
            state = state.setValue(BlockStateProperties.WEST, true);
        } else {
            state = state.setValue(BlockStateProperties.WEST, false);
        }

        return state;
    }
}
