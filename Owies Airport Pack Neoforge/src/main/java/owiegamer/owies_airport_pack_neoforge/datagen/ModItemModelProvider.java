package owiegamer.owies_airport_pack_neoforge.datagen;


import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import owiegamer.owies_airport_pack_neoforge.OwiesAirportPackNeoforge;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OwiesAirportPackNeoforge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }
}