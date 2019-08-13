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

package techreborn.items.reactor;

import net.minecraft.item.ItemStack;

import ic2.api.reactor.IReactor;
import ic2.api.reactor.IReactorComponent;
import net.minecraftforge.fml.common.Optional;

/**
 * @author estebes
 */
@Optional.Interface(iface = "ic2.api.reactor.IReactor", modid = "ic2")
@Optional.Interface(iface = "ic2.api.reactor.IReactorComponent", modid = "ic2")
public class ItemIridiumNeutronReflector extends ItemReactorComponent {
	// Constructor >>
	public ItemIridiumNeutronReflector() {
		super("iridium_neutron_reflector");
	}
	// << Constructor

	// IReactorComponent >>
	@Optional.Method(modid = "ic2")
	@Override
	public boolean acceptUraniumPulse(ItemStack stack, IReactor reactor, ItemStack pulsingStack, int youX, int youY, int pulseX, int pulseY, boolean heatrun) {
		if (!heatrun) {
			IReactorComponent source = (IReactorComponent) pulsingStack.getItem();
			// apply a pulse at the source
			source.acceptUraniumPulse(pulsingStack, reactor, stack, pulseX, pulseY, youX, youY, heatrun);
		}

		return true;
	}

	@Optional.Method(modid = "ic2")
	@Override
	public float influenceExplosion(ItemStack stack, IReactor reactor) {
		return -1;
	}
	// << IReactorComponent
}
