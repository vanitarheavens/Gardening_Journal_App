package vanitar.mdp.gardening_journal_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController  // Add this import
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.homeFragment,
            R.id.gardenLogFragment,
            R.id.plantDetailsFragment
        ).build()

        // Set up the ActionBar with the NavigationUI
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        // Navigate to the Garden Log fragment when the app is launched
        navController.navigate(R.id.gardenLogFragment)
    }

    // Override the onSupportNavigateUp method to handle Up navigation
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
