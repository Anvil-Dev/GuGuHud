package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHudRgRules;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ChunkPos;

public class BlockPositionHudRow extends HudRow {
    @Override
    public boolean isVisible() {
        return GuGuHudRgRules.showBlockPosition || GuGuHudRgRules.showChunkPosition || GuGuHudRgRules.showBlockInChunkPosition;
    }

    @Override
    public int render(GuiGraphics guiGraphics, DeltaTracker partialTick) {
        Entity cameraEntity = this.mc().cameraEntity;
        if (cameraEntity == null) return 0;
        BlockPos blockPos = cameraEntity.blockPosition();
        MutableComponent result = Component.empty();
        boolean flag = false;
        if (GuGuHudRgRules.showBlockPosition) {
            flag = true;
            result.append(
                Component.translatable(
                    "gugu_hud.block_position_hud.block_position",
                    blockPos.getX(),
                    blockPos.getY(),
                    blockPos.getZ()
                )
            );
        }
        if (GuGuHudRgRules.showChunkPosition) {
            if (flag) result.append(" | ");
            flag = true;

            ChunkPos chunkPos = new ChunkPos(blockPos);
            result.append(
                Component.translatable(
                    "gugu_hud.block_position_hud.chunk_position",
                    chunkPos.x,
                    blockPos.getY() / 16,
                    chunkPos.z
                )
            );
        }
        if (GuGuHudRgRules.showBlockInChunkPosition) {
            if (flag) result.append(" | ");
            result.append(
                Component.translatable(
                    "gugu_hud.block_position_hud.block_in_chunk_position",
                    blockPos.getX() % 16,
                    blockPos.getY() % 16,
                    blockPos.getZ() % 16
                )
            );
        }
        return this.drawString(result);
    }
}
