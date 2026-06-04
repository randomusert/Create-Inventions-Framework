package io.github.randomusert.mods.create_inventions_framework.worldgen;

import io.github.randomusert.mods.create_inventions_framework.Create_inventions_framework;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.Map;
import java.util.Optional;

public class CIFStructures {
    public static void bootstrap(BootstrapContext<Structure> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);


        Structure.StructureSettings settings = new Structure.StructureSettings(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                Map.of(),
                GenerationStep.Decoration.SURFACE_STRUCTURES,
                TerrainAdjustment.BURY
        );


        JigsawStructure structure = new JigsawStructure(
                settings,
                pools.getOrThrow(Create_inventions_framework.createKey(Registries.TEMPLATE_POOL, "ore_geode_pool")),
                1, // Max depth
                ConstantHeight.of(VerticalAnchor.absolute(-5)),
                true,
                Heightmap.Types.WORLD_SURFACE_WG
        );

        JigsawStructure ruined_workshop = new JigsawStructure(
                settings,
                pools.getOrThrow(Create_inventions_framework.createKey(Registries.TEMPLATE_POOL, "ruined_workshop_pool")),
                3,
                ConstantHeight.of(VerticalAnchor.absolute(0)),
                true,
                Heightmap.Types.WORLD_SURFACE_WG
        );

        context.register(Create_inventions_framework.createKey(Registries.STRUCTURE, "ruined_workshop_structure"), ruined_workshop);

        context.register(Create_inventions_framework.createKey(Registries.STRUCTURE, "ore_geode_structure"), structure);
    }
}
