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
import top.atdove.stellarium.i18n.LanguageManager;
import top.atdove.stellarium.item.ModItems;
import top.atdove.stellarium.dataGen.BasicBlockState;

import java.util.ArrayList;
import java.util.function.Supplier;

import static top.atdove.stellarium.Stellarium.MODID;
import static top.atdove.stellarium.dataGen.BasicBlockState.*;

public class ModBlocks {

    public static final ArrayList<CustomBlock> customBlocks = new ArrayList<>();
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final CustomBlock CARBONIZED_LOG = createColumnBlock(
            "carbonized_log",
            "碳化木",
            () -> new RotatedPillarBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(p_152624_ -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.WOOD : MapColor.PODZOL)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            ));
    public static final CustomBlock CARBONIZED_WOOD = createColumnBlock(
            "carbonized_wood",
            "碳化木原木",
            () -> new RotatedPillarBlock(
                    BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()
            ));
    public static final CustomBlock CARBONIZED_PLANKS = createCubeBlock(
            "carbonized_planks",
            "碳化木板",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            ));
    public static final CustomBlock CARBONIZED_STAIRS = createStairsBlock(
            "carbonized_stairs",
            "碳化木楼梯",
            () -> getStair(CARBONIZED_PLANKS.get()));
    public static final CustomBlock CARBONIZED_FENCE = createFenceBlock(
            "carbonized_fence",
            "碳化木栅栏",
            () -> new FenceBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(CARBONIZED_PLANKS.get().defaultMapColor())
                            .forceSolidOn()
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            ));
    public static final CustomBlock CARBONIZED_FENCE_GATE = createFenceGateBlock(
            "carbonized_fence_gate",
            "碳化木栅栏门",
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
    public static final CustomBlock CARBONIZED_PRESSURE_PLATE = createPressurePlateBlock(
            "carbonized_pressure_plate",
            "碳化木压力板",
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
    public static final CustomBlock CARBONIZED_SLAB = createSlabBlock(
            "carbonized_slab",
            "碳化木台阶",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F, 3.0F)
                            .sound(SoundType.WOOD)
                            .ignitedByLava()
            )).addBlockTag(BlockTags.WOODEN_SLABS);
    public static final CustomBlock CARBONIZED_BUTTON = createButtonBlock(
            "carbonized_button",
            "碳化木按钮",
            () -> woodenButton(ModBlockSetType.CARBONIZED_WOOD)
    );
    public static final CustomBlock SCORCHED_SAND = createCubeBlock(
            "scorched_sand",
            "灼化沙",
            () -> new ColoredFallingBlock(
                    new ColorRGBA(14406560),
                    BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)
            ));
    public static final CustomBlock SCORCHED_SANDSTONE = createBottomTopBlock(
            "scorched_sandstone",
            "灼化砂岩",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.STONE)
            ));
    public static final CustomBlock SCORCHED_SOIL = createCubeBlock(
            "scorched_soil",
            "灼化泥土",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.SAND)
            ));

    public static CustomBlock createCustomBlock(String id, LanguageManager languageManager, BasicBlockState basicBlockState, Supplier<? extends Block> supplier) {
        DeferredBlock<Block> _deferredBlock = BLOCKS.register(id, supplier);
        CustomBlock customBlock = new CustomBlock(id, languageManager, basicBlockState, _deferredBlock, ModItems.createBlockItem(id, _deferredBlock));
        customBlocks.add(customBlock);
        return customBlock;
    }
    public static CustomBlock createCustomBlock(String id, String ChineseName, BasicBlockState basicBlockState, Supplier<? extends Block> supplier) {
        DeferredBlock<Block> _deferredBlock = BLOCKS.register(id, supplier);
        CustomBlock customBlock = new CustomBlock(id, new LanguageManager().addSimplfiedChinese(ChineseName), basicBlockState, _deferredBlock, ModItems.createBlockItem(id, _deferredBlock));
        customBlock.generateEnglishTextFromId();
        customBlocks.add(customBlock);
        return customBlock;
    }

    public static CustomBlock createCubeBlock(String id, String ChineseName, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, ChineseName, CUBE_ALL, supplier);
    }
    public static CustomBlock createColumnBlock(String id, String ChineseName, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, ChineseName, CUBE_COLUMN, supplier);
    }
    public static CustomBlock createBottomTopBlock(String id, String ChineseName, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, ChineseName, CUBE_BOTTOM_TOP, supplier);
    }

    public static CustomBlock createStairsBlock(String id, String ChineseName, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, ChineseName, STAIRS, supplier).addBlockTag(BlockTags.STAIRS);
    }
    public static CustomBlock createSlabBlock(String id, String ChineseName, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, ChineseName, SLAB, supplier).addBlockTag(BlockTags.SLABS);
    }
    public static CustomBlock createButtonBlock(String id, String ChineseName, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, ChineseName, BUTTON, supplier).addBlockTag(BlockTags.BUTTONS);
    }

    public static CustomBlock createFenceBlock(String id, String ChineseName, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, ChineseName, FENCE, supplier).addBlockTag(BlockTags.FENCES);
    }
    public static CustomBlock createFenceGateBlock(String id, String ChineseName, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, ChineseName, FENCE_GATE, supplier).addBlockTag(BlockTags.FENCE_GATES);
    }
    public static CustomBlock createPressurePlateBlock(String id, String ChineseName, Supplier<? extends Block> supplier) {
        return createCustomBlock(id, ChineseName, PRESSURE_PLATE, supplier).addBlockTag(BlockTags.PRESSURE_PLATES);
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
