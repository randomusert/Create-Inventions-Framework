package io.github.randomusert.mods.create_inventions_framework.worldgen;

import io.github.randomusert.mods.create_inventions_framework.Create_inventions_framework;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.List;

public class CIFTemplatePools {

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {

        var poolGetter = context.lookup(Registries.TEMPLATE_POOL);

        ResourceLocation nbtLocation = ResourceLocation.fromNamespaceAndPath(Create_inventions_framework.MODID, "ore_geode");


        StructureTemplatePool pool = new StructureTemplatePool(
                context.lookup(Registries.TEMPLATE_POOL).getOrThrow(Pools.EMPTY),
                List.of(
                        Pair.of(
                                StructurePoolElement.single(nbtLocation.toString()),
                                1 // Weight
                        )
                ),
                StructureTemplatePool.Projection.RIGID
        );

        // Registered with your updated createKey helper
        context.register(Create_inventions_framework.createKey(Registries.TEMPLATE_POOL, "ore_geode_pool"), pool);

        ResourceLocation ruinedWorkshopPath = ResourceLocation.fromNamespaceAndPath(Create_inventions_framework.MODID, "ruined_workshop_path");
        ResourceLocation ruinedWorkshopBuilding = ResourceLocation.fromNamespaceAndPath(Create_inventions_framework.MODID, "ruined_workshop_building");


        StructureTemplatePool ruinedWorkshopPathPool = new StructureTemplatePool(
                poolGetter.getOrThrow(Pools.EMPTY),
                List.of(Pair.of(StructurePoolElement.single(ruinedWorkshopPath.toString()), 1)),
                StructureTemplatePool.Projection.RIGID
        );

        context.register(Create_inventions_framework.createKey(Registries.TEMPLATE_POOL, "ruined_workshop_pool"), ruinedWorkshopPathPool);


        StructureTemplatePool ruinedWorkshopBuildingPool = new StructureTemplatePool(
                poolGetter.getOrThrow(Pools.EMPTY),
                List.of(Pair.of(StructurePoolElement.single(ruinedWorkshopBuilding.toString()), 1)),
                StructureTemplatePool.Projection.RIGID
        );

        context.register(Create_inventions_framework.createKey(Registries.TEMPLATE_POOL, "ruined_workshop_building_pool"), ruinedWorkshopBuildingPool);
    }
}
