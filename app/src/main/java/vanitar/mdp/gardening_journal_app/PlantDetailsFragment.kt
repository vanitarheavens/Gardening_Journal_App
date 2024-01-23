package vanitar.mdp.gardening_journal_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import vanitar.mdp.gardening_journal_app.databinding.FragmentPlantDetailsBinding

class PlantDetailsFragment : Fragment() {

    private val plantDetailsViewModel: PlantDetailsViewModel by viewModels()
    private lateinit var binding: FragmentPlantDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlantDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the plantId from navigation arguments
        val plantId = arguments?.getInt(ARG_PLANT_ID) ?: -1

        // Observe changes in plant details from the ViewModel
        plantDetailsViewModel.getPlantById(plantId).observe(viewLifecycleOwner) { plant ->
            // Update UI with plant details
            binding.textViewPlantName.text = "Plant Name: ${plant?.name}"
            binding.textViewPlantType.text = "Plant Type: ${plant?.type}"
            binding.textViewWateringFrequency.text = "Watering Frequency: ${plant?.wateringFrequency} days"
            binding.textViewPlantingDate.text = "Planting Date: ${plant?.plantingDate}"
        }
    }

    companion object {
        const val ARG_PLANT_ID = "plantId"

        fun newInstance(plantId: Int): PlantDetailsFragment {
            val fragment = PlantDetailsFragment()
            val args = Bundle()
            args.putInt(ARG_PLANT_ID, plantId)
            fragment.arguments = args
            return fragment
        }
    }
}
