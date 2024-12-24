package top.atdove.stellarium.block;

import net.minecraft.core.Direction;
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

import java.util.function.Supplier;

import static top.atdove.stellarium.Stellarium.MODID;

public class ModBlocks {

    //public static final ArrayList<DeferredBlock<Block>> customBlocks = new ArrayList<>();
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredBlock<Block> CARBONIZED_LOG = createCustomBlock(
            "carbonized_log",
            () -> new RotatedPillarBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(p_152624_ -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.WOOD : MapColor.PODZOL)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            ));
    public static final DeferredBlock<Block> CARBONIZED_WOOD = createCustomBlock(
            "carbonized_wood",
            () -> new RotatedPillarBlock(
                    BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()
            ));
    public static final DeferredBlock<Block> CARBONIZED_PLANKS = createCustomBlock(
            "carbonized_planks",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            ));
    public static final DeferredBlock<Block> CARBONIZED_STAIRS = createCustomBlock(
            "carbonized_stairs",
            () -> getStair(CARBONIZED_PLANKS.get()));
    public static final DeferredBlock<Block> CARBONIZED_FENCE = createCustomBlock(
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
    public static final DeferredBlock<Block> CARBONIZED_FENCE_GATE = createCustomBlock(
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
    public static final DeferredBlock<Block> CARBONIZED_PRESSURE_PLATE = createCustomBlock(
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
    public static final DeferredBlock<Block> CARBONIZED_SLAB = createCustomBlock(
            "carbonized_slab",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            ));
    public static final DeferredBlock<Block> CARBONIZED_BUTTON = createCustomBlock(
            "carbonized_button",
            () -> woodenButton(ModBlockSetType.CARBONIZED_WOOD)
    );
    public static final DeferredBlock<Block> SCORCHED_SAND = createCustomBlock(
            "scorched_sand",
            () -> new ColoredFallingBlock(
                    new ColorRGBA(14406560),
                    BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)
            ));
    public static final DeferredBlock<Block> SCORCHED_SANDSTONE = createCustomBlock(
            "scorched_sandstone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.STONE)
            ));
    public static final DeferredBlock<Block> SCORCHED_DIRT = createCustomBlock(
            "scorched_dirt",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.SAND)
            ));

    public static DeferredBlock<Block> createCustomBlock(String id, Supplier<? extends Block> supplier) {
        DeferredBlock<Block> _deferredBlock = BLOCKS.register(id, supplier);
        return _deferredBlock;
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
