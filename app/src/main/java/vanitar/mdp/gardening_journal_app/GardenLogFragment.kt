package vanitar.mdp.gardening_journal_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GardenLogFragment : Fragment() {

    private lateinit var gardenLogViewModel: GardenLogViewModel
    private lateinit var plantAdapter: PlantAdapter
    private lateinit var addPlants: Button
    private lateinit var ryclereView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_garden_log, container, false)
        addPlants = root.findViewById(R.id.btn_add_plant)
        ryclereView = root.findViewById(R.id.recycler_view_plants)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Use the ViewModelProvider.AndroidViewModelFactory to provide the application context
        val viewModelFactory = GardenLogViewModelFactory(requireActivity().application)
        gardenLogViewModel = ViewModelProvider(this, viewModelFactory)
            .get(GardenLogViewModel::class.java)

        // RecyclerView setup...
        val layoutManager = LinearLayoutManager(requireContext())
        ryclereView.layoutManager = layoutManager

        // Initialize the PlantAdapter with an empty list
        plantAdapter = PlantAdapter()
        ryclereView.adapter = plantAdapter

        // Observe changes in the plant list and update the adapter
        gardenLogViewModel.allPlants.observe(viewLifecycleOwner) { plants ->
            plantAdapter.submitList(plants)
        }

        // Set up button click listener to add sample plants to the database
        addPlants.setOnClickListener {
            addPlantToDatabase()
        }
    }

    private fun addPlantToDatabase() {
        // Adding sample plants to the database using the ViewModel
        val samplePlants = mutableListOf<Plant>(
            Plant(name = "Rose", type = "Flower", wateringFrequency = 2, plantingDate = "2023-01-01"),
            Plant(name = "Tomato", type = "Vegetable", wateringFrequency = 3, plantingDate = "2023-02-15"),
            Plant(name = "Basil", type = "Herb", wateringFrequency = 1, plantingDate = "2023-03-10")
        )

        for (plant in samplePlants) {
            gardenLogViewModel.insertPlant(plant)
        }
    }

}