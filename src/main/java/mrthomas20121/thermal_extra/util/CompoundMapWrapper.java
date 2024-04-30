package mrthomas20121.thermal_extra.util;

import cofh.lib.util.crafting.ComparableItemStack;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;
import java.util.Set;

public class CompoundMapWrapper {
    public static CompoundMapWrapper of(List<ComparableItemStack> itemStacks) {
        return new CompoundMapWrapper(itemStacks);
    }

    public static SingleFluidCompoundMapWrapper of(List<ComparableItemStack> itemStacks, FluidStack fluidStack) {
        return new SingleFluidCompoundMapWrapper(itemStacks, fluidStack);
    }

    public static FluidCompoundMapWrapper of(List<ComparableItemStack> itemStacks, List<FluidStack> fluidStack) {
        return new FluidCompoundMapWrapper(itemStacks, fluidStack);
    }

    protected final Set<Integer> itemHashes;
    protected int hashCode;

    protected CompoundMapWrapper(List<ComparableItemStack> itemStacks) {

        this.itemHashes = new ObjectOpenHashSet<>(itemStacks.size());
        for (ComparableItemStack itemStack : itemStacks) {
            if (itemStack.hashCode() != 0) {
                this.itemHashes.add(itemStack.hashCode());
                hashCode += itemStack.hashCode();
            }
        }
    }

    @Override
    public boolean equals(Object o) {

        if (null == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        CompoundMapWrapper that = (CompoundMapWrapper) o;
        return itemHashes.size() == that.itemHashes.size() && itemHashes.containsAll(that.itemHashes);
    }

    @Override
    public int hashCode() {

        return hashCode;
    }

    public static class SingleFluidCompoundMapWrapper extends CompoundMapWrapper {

        public SingleFluidCompoundMapWrapper(List<ComparableItemStack> itemStacks, FluidStack fluidStacks) {
            super(itemStacks);
            this.hashCode+= fluidStacks.hashCode();
        }
    }

    public static class FluidCompoundMapWrapper extends CompoundMapWrapper {

        protected final Set<Integer> fluidHashes;

        public FluidCompoundMapWrapper(List<ComparableItemStack> itemStacks, List<FluidStack> fluidStacks) {
            super(itemStacks);
            this.fluidHashes = new ObjectOpenHashSet<>(itemStacks.size());
            for(FluidStack stack: fluidStacks) {
                this.fluidHashes.add(stack.hashCode());
                this.hashCode+= stack.hashCode();
            }
        }

        @Override
        public boolean equals(Object o) {

            if (null == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            FluidCompoundMapWrapper that = (FluidCompoundMapWrapper) o;
            return itemHashes.size() == that.itemHashes.size() && itemHashes.containsAll(that.itemHashes) && fluidHashes.size() == that.fluidHashes.size() && fluidHashes.containsAll(that.fluidHashes);
        }
    }
}