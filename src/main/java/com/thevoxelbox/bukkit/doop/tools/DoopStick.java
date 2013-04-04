package com.thevoxelbox.bukkit.doop.tools;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

import com.thevoxelbox.bukkit.doop.ITool;

public class DoopStick implements ITool
{

    @Override
    public String getName()
    {
        return "Dooplicator";
    }

    @Override
    public Material getToolMaterial()
    {
        return Material.STONE_AXE;
    }

    @Override
    public void onUse(Block targetBlock, ItemStack itemUsed, Player player, Action action)
    {
        this.onRangedUse(targetBlock, itemUsed, player, action);
    }

    @Override
    public void onRangedUse(Block targetBlock, ItemStack itemUsed, Player player, Action action)
    {
        if (action == Action.LEFT_CLICK_BLOCK || action == Action.LEFT_CLICK_AIR)
        {
            return;
        }
        else
        {
            ItemStack addedItem = new ItemStack(targetBlock.getType(), 0, (short) targetBlock.getData());
            player.getInventory().addItem(addedItem);
        }
    }
}