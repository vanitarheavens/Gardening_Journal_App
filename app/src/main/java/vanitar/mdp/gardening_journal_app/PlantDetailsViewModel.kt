package vanitar.mdp.gardening_journal_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PlantDetailsViewModel(private val repository: PlantRepository) : ViewModel() {

    fun getPlantById(plantId: Int): LiveData<Plant?> {
        return repository.getPlantById(plantId)
    }
}
