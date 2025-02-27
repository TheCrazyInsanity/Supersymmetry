import static gregtech.api.recipes.RecipeMaps.*;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import net.minecraft.init.SoundEvents;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.api.recipes.machines.*;
import gregtech.api.recipes.builders.*;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity
import gregtech.common.metatileentities.MetaTileEntities
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.api.util.GTUtility;
import gregtech.api.GregTechAPI;

eventManager.listen {
    GregTechAPI.PostMaterialEvent event ->

        log.infoMC("Adding recipemaps...")

        def ore_sorter = new RecipeMap<>("ore_sorter", 1, 2, 0, 16, 1, 1, 1, 1, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, MoveType.HORIZONTAL);

        log.infoMC("Added ore sorter")

        def cooling_tower = new RecipeMap<>("cooling_tower", 0, 0, 0, 0, 2, 2, 2, 2, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, MoveType.HORIZONTAL);

        log.infoMC("Added cooling tower")

        def fluid_decompressor = new RecipeMap<>("fluid_decompressor", 0, 0, 0, 0, 1, 1, 1, 1, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, MoveType.HORIZONTAL);

        log.infoMC("Added fluid decompressor")

        def fluid_compressor = new RecipeMap<>("fluid_compressor", 0, 0, 0, 0, 1, 1, 1, 1, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, MoveType.HORIZONTAL);

        log.infoMC("Added fluid compressor")

        def heat_exchanger = new RecipeMap<>("heat_exchanger", 0, 0, 0, 0, 1, 2, 1, 2, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, MoveType.HORIZONTAL);

        log.infoMC("Added heat exchanger")

        def radiator = new RecipeMap<>("radiator", 0, 0, 0, 0, 1, 1, 1, 1, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, MoveType.HORIZONTAL);

        log.infoMC("Added radiator")

        def gas_turbine_new = new RecipeMap<>("gas_turbine_new", 0, 0, 0, 0, 1, 2, 1, 1, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, MoveType.HORIZONTAL);

        log.infoMC("Added gas turbine")

        def steam_turbine_new = new RecipeMap<>("steam_turbine_new", 0, 0, 0, 0, 1, 1, 1, 1, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, MoveType.HORIZONTAL);

        log.infoMC("Added steam turbine")

        def quencher = new RecipeMap<>("quencher", 1, 1, 1, 1, 1, 1, 1, 1, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, MoveType.HORIZONTAL);

        log.infoMC("Added quencher")

        def weapons_factory = new RecipeMap<>("weapons_factory", 0, 9, 1, 1, 0, 2, 0, 0, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT, MoveType.HORIZONTAL);

        log.infoMC("Added weapons factory")

        def large_weapons_factory = (RecipeMapAssemblyLine<SimpleRecipeBuilder>) new RecipeMapAssemblyLine<>("large_weapons_factory", 16, false, 1, false, 4, false, 0, false, new SimpleRecipeBuilder(), false)
                .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT, MoveType.HORIZONTAL);

        log.infoMC("Added large weapons factory")

        log.infoMC("Finished adding recipemaps")

        log.infoMC("Registering simple machines...")

        def WEAPONS_FACTORY = new SimpleMachineMetaTileEntity[9]
        def FLUID_DECOMPRESSOR = new SimpleMachineMetaTileEntity[9]
        def FLUID_COMPRESSOR = new SimpleMachineMetaTileEntity[9]

        log.infoMC("Finished adding simple machines")

        log.infoMC("Adding simple MTEs")

        MetaTileEntities.registerSimpleMetaTileEntity(WEAPONS_FACTORY, 32000, "weapons_factory", weapons_factory, (ICubeRenderer) Textures.ASSEMBLER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction)
        MetaTileEntities.registerSimpleMetaTileEntity(FLUID_DECOMPRESSOR, 32020, "fluid_decompressor", fluid_decompressor, (ICubeRenderer) Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, true, GTUtility.hvCappedTankSizeFunction)
        MetaTileEntities.registerSimpleMetaTileEntity(FLUID_COMPRESSOR, 32040, "fluid_compressor", fluid_compressor, (ICubeRenderer) Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, true, GTUtility.hvCappedTankSizeFunction)
        
        log.infoMC("Finished adding simple MTEs")
}