package vanitar.mdp.gardening_journal_app

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
class GardenLogViewModelFactory(private val application: View) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GardenLogViewModel::class.java)) {
            val plantDao = PlantDatabase.getDatabase(application.context).plantDao()
            val repository = PlantRepository(plantDao)

            @Suppress("UNCHECKED_CAST")
            return GardenLogViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
