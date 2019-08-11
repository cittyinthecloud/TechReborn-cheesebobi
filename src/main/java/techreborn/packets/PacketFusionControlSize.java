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

package techreborn.packets;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import reborncore.common.network.ExtendedPacketBuffer;
import reborncore.common.network.INetworkPacket;
import techreborn.tiles.fusionReactor.TileFusionControlComputer;

import java.io.IOException;

public class PacketFusionControlSize implements INetworkPacket<PacketFusionControlSize> {

	int sizeDelta;
	BlockPos pos;

	public PacketFusionControlSize(int sizeDelta, BlockPos pos) {
		this.sizeDelta = sizeDelta;
		this.pos = pos;
	}

	public PacketFusionControlSize() {
	}

	@Override
	public void writeData(ExtendedPacketBuffer buffer) throws IOException {
		buffer.writeInt(sizeDelta);
		buffer.writeBlockPos(pos);
	}

	@Override
	public void readData(ExtendedPacketBuffer buffer) throws IOException {
		sizeDelta = buffer.readInt();
		pos = buffer.readBlockPos();
	}

	@Override
	public void processData(PacketFusionControlSize message, MessageContext context) {
		TileEntity tile = context.getServerHandler().player.world.getTileEntity(message.pos);
		if(tile instanceof TileFusionControlComputer){
			((TileFusionControlComputer) tile).changeSize(sizeDelta);
		}
	}
}