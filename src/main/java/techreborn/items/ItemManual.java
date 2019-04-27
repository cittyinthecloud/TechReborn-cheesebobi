/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2018 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package techreborn.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import reborncore.common.registration.config.ConfigRegistry;
import techreborn.TechReborn;

public class ItemManual extends Item {

	@ConfigRegistry(config = "misc", category = "general", key = "manualRefund", comment = "Allow refunding items used to craft the manual")
	public static boolean allowRefund = true;

	public ItemManual() {
		super(new Item.Properties().group(TechReborn.ITEMGROUP).maxStackSize(1));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(final World world, final EntityPlayer player,
	                                                final EnumHand hand) {
		throw new UnsupportedOperationException("1.13 fix me");
		//player.openGui(TechReborn.INSTANCE, EGui.MANUAL.ordinal(), world, (int) player.posX, (int) player.posY, (int) player.posY);

		//return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}
}
