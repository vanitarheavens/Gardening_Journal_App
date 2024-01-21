package vanitar.mdp.gardening_journal_app

import androidx.lifecycle.LiveData

class PlantRepository(private val plantDao: PlantDao) {

    val allPlants: LiveData<List<Plant>> = plantDao.getAllPlants()

    suspend fun insert(plant: Plant) {
        plantDao.insert(plant)
    }

    suspend fun update(plant: Plant) {
        plantDao.update(plant)
    }

    suspend fun delete(plant: Plant) {
        plantDao.delete(plant)
    }

    fun getPlantById(plantId: Int): LiveData<Plant?> {
        return plantDao.getPlantById(plantId)
    }
}
