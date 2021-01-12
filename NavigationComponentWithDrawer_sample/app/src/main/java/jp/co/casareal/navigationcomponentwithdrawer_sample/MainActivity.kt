package jp.co.casareal.navigationcomponentwithdrawer_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import androidx.navigation.ui.NavigationUI.navigateUp
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

        val navigationView = findViewById<NavigationView>(R.id.nav_view)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        // ナビゲーションボタンとNavigation Drawerを紐付ける
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        // ナビゲーションボタンを有効化
        setupActionBarWithNavController(navController,drawerLayout)

        // Menuのitemと同じidを持つデスティネーションのFragmentを表示させる
        navigationView.setupWithNavController(navController)

        // Navigation Drawerにメニューファイルの内容物を表示
        navigationView.inflateMenu(R.menu.my_menu)

    }

    // ナビゲーションボタンを押された時の処理
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp()
    }
}