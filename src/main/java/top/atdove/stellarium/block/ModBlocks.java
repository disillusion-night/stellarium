package top.atdove.stellarium.block;

import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.atdove.stellarium.dataGen.BasicBlockState;

import java.util.ArrayList;
import java.util.function.Supplier;

import static top.atdove.stellarium.Stellarium.MODID;
import static top.atdove.stellarium.dataGen.BasicBlockState.*;

public class ModBlocks {

    public static final ArrayList<ExtendedBlock> customBlocks = new ArrayList<>();
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final ExtendedBlock CARBONIZED_LOG = createColumnBlock(
            "carbonized_log",
            () -> new RotatedPillarBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(p_152624_ -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.WOOD : MapColor.PODZOL)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            ));
    public static final ExtendedBlock CARBONIZED_WOOD = createColumnBlock(
            "carbonized_wood",
            () -> new RotatedPillarBlock(
                    BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()
            ));
    public static final ExtendedBlock CARBONIZED_PLANKS = createCubeBlock(
            "carbonized_planks",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            ));
    public static final ExtendedBlock CARBONIZED_STAIRS = createStairsBlock(
            "carbonized_stairs",
            () -> getStair(CARBONIZED_PLANKS.get()));
    public static final ExtendedBlock CARBONIZED_FENCE = createFenceBlock(
            "carbonized_fence",
            () -> new FenceBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(CARBONIZED_PLANKS.get().defaultMapColor())
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            ));
    public static final ExtendedBlock CARBONIZED_FENCE_GATE = createFenceGateBlock(
            "carbonized_fence_gate",
            () -> new FenceGateBlock(
                    ModWoodType.CARBONIZED_WOOD,
                    BlockBehaviour.Properties.of()
                            .mapColor(CARBONIZED_PLANKS.get().defaultMapColor())
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            ));
    public static final ExtendedBlock CARBONIZED_PRESSURE_PLATE = createPressurePlateBlock(
            "carbonized_pressure_plate",
            () -> new PressurePlateBlock(
                    ModBlockSetType.CARBONIZED_WOOD,
                    BlockBehaviour.Properties.of()
                            .mapColor(CARBONIZED_PLANKS.get().defaultMapColor())
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASS)
                            .noCollission()
                            .strength(0.5F)
                            .ignitedByLava()
                            .pushReaction(PushReaction.DESTROY)
            )
    );
    public static final ExtendedBlock CARBONIZED_SLAB = createSlabBlock(
            "carbonized_slab",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            )).addBlockTag(BlockTags.WOODEN_SLABS);
    public static final ExtendedBlock CARBONIZED_BUTTON = createButtonBlock(
            "carbonized_button",
            () -> woodenButton(ModBlockSetType.CARBONIZED_WOOD)
    );
    public static final ExtendedBlock SCORCHED_SAND = createCubeBlock(
            "scorched_sand",
            () -> new ColoredFallingBlock(
                    new ColorRGBA(14406560),
                    BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)
            ));
    public static final ExtendedBlock SCORCHED_SANDSTONE = createBottomTopBlock(
            "scorched_sandstone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.STONE)
            ));
    public static final ExtendedBlock SCORCHED_DIRT = createCubeBlock(
            "scorched_soil",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.SAND)
            ));

    public static ExtendedBlock createCustomBlock(String id, BasicBlockState basicBlockState, Supplier<? extends Block> supplier) {
        DeferredBlock<Block> _deferredBlock = BLOCKS.register(id, supplier);
        ExtendedBlock customBlock = new ExtendedBlock(id, basicBlockState, _deferredBlock);
        customBlocks.add(customBlock);
        return customBlock;
    }
    public static ExtendedBlock createCubeBlock(String id, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, CUBE_ALL, supplier);
    }
    public static ExtendedBlock createColumnBlock(String id, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, CUBE_COLUMN, supplier);
    }
    public static ExtendedBlock createBottomTopBlock(String id, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, CUBE_BOTTOM_TOP, supplier);
    }

    public static ExtendedBlock createStairsBlock(String id, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, STAIRS, supplier).addBlockTag(BlockTags.STAIRS);
    }
    public static ExtendedBlock createSlabBlock(String id, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, SLAB, supplier).addBlockTag(BlockTags.SLABS);
    }
    public static ExtendedBlock createButtonBlock(String id, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, BUTTON, supplier).addBlockTag(BlockTags.BUTTONS);
    }

    public static ExtendedBlock createFenceBlock(String id, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, FENCE, supplier).addBlockTag(BlockTags.FENCES);
    }
    public static ExtendedBlock createFenceGateBlock(String id, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, FENCE_GATE, supplier).addBlockTag(BlockTags.FENCE_GATES);
    }
    public static ExtendedBlock createPressurePlateBlock(String id, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, PRESSURE_PLATE, supplier).addBlockTag(BlockTags.PRESSURE_PLATES);
    }

    private static Block getStair(Block baseBlock) {
        return new StairBlock(baseBlock.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }

    private static Block woodenButton(BlockSetType type) {
        return new ButtonBlock(type, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY));
    }

    public static void register(IEventBus eventBus) {

        BLOCKS.register(eventBus);
    }
}
