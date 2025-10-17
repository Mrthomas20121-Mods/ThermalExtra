package mrthomas20121.thermal_extra.recipe;

import cofh.core.util.helpers.FluidHelper;
import cofh.lib.util.crafting.ComparableItemStack;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;
import java.util.Set;

public class RecipeMapWrapper {

    Set<Integer> hashes;
    int hashCode;

    RecipeMapWrapper(List<ComparableItemStack> itemStacks) {

        this.hashes = new ObjectOpenHashSet<>(itemStacks.size());
        for (ComparableItemStack itemStack : itemStacks) {
            if (itemStack.hashCode() != 0) {
                this.hashes.add(itemStack.hashCode());
                hashCode += itemStack.hashCode();
            }
        }
    }

    RecipeMapWrapper(List<ComparableItemStack> itemStacks, FluidStack fluidStack) {

        this.hashes = new ObjectOpenHashSet<>(itemStacks.size());
        for (ComparableItemStack itemStack : itemStacks) {
            if (itemStack.hashCode() != 0) {
                this.hashes.add(itemStack.hashCode());
                hashCode += itemStack.hashCode();
            }
        }
        if (!fluidStack.isEmpty()) {
            int fluidHash = FluidHelper.fluidHashcode(fluidStack);
            hashes.add(fluidHash);
            hashCode += fluidHash;
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecipeMapWrapper that = (RecipeMapWrapper) o;
        return hashes.size() == that.hashes.size() && hashes.containsAll(that.hashes);
    }

    @Override
    public int hashCode() {

        return hashCode;
    }

}
