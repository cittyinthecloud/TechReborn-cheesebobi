package techreborn.api.recipe.machines;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import techreborn.api.Reference;
import techreborn.api.recipe.BaseRecipe;

public class IndustrialGrinderRecipe extends BaseRecipe {

	public FluidStack fluidStack;
	boolean useOreDic = true;

	public IndustrialGrinderRecipe(ItemStack input1, FluidStack fluidStack, ItemStack output1,
	                               ItemStack output2, ItemStack output3, ItemStack output4, int tickTime, int euPerTick) {
		super(Reference.industrialGrinderRecipe, tickTime, (int) (euPerTick / 2.5)); // Buff energy usage to be more in line with other machines
		if (input1 != null)
			addInput(input1);
		if (output1 != null)
			addOutput(output1);
		if (output2 != null)
			addOutput(output2);
		if (output3 != null)
			addOutput(output3);
		if (output4 != null)
			addOutput(output4);
		this.fluidStack = fluidStack;
	}

	public IndustrialGrinderRecipe(ItemStack input1, FluidStack fluidStack, ItemStack output1,
	                               ItemStack output2, ItemStack output3, ItemStack output4, int tickTime, int euPerTick, boolean useOreDict) {
		this(input1, fluidStack, output1, output2, output3, output4, tickTime, euPerTick);
		this.useOreDic = useOreDict;
	}

	@Override
	public String getUserFreindlyName() {
		return "IndustrialGrinder";
	}

	@Override
	public boolean useOreDic() {
		return useOreDic;
	}
}
