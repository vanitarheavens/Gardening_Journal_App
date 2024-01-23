package vanitar.mdp.gardening_journal_app

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import vanitar.mdp.gardening_journal_app.GardenLogViewModel
import vanitar.mdp.gardening_journal_app.PlantDatabase
import vanitar.mdp.gardening_journal_app.PlantRepository

class GardenLogViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GardenLogViewModel::class.java)) {
            val plantDao = PlantDatabase.getDatabase(application.applicationContext).plantDao()
            val repository = PlantRepository(plantDao)

            @Suppress("UNCHECKED_CAST")
            return GardenLogViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
