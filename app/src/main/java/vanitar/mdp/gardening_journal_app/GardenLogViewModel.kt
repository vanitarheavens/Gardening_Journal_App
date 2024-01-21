package vanitar.mdp.gardening_journal_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GardenLogViewModel(private val repository: PlantRepository) : ViewModel() {
    val allPlants: LiveData<List<Plant>> = repository.allPlants

    fun insertPlant(plant: Plant) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(plant)
        }
    }

    fun getPlantById(plantId: Int): LiveData<Plant?> {
        return repository.getPlantById(plantId)
    }
}
