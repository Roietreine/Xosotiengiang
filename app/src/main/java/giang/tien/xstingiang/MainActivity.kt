package giang.tien.xstingiang

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import giang.tien.xstingiang.binding.viewBinding
import giang.tien.xstingiang.data.Data
import giang.tien.xstingiang.databinding.ActivityMainBinding
import giang.tien.xstingiang.fragments.BottomAdapter
import giang.tien.xstingiang.fragments.DetailsFragment
import giang.tien.xstingiang.fragments.MainFragment
import giang.tien.xstingiang.fragments.OnItemClickListener

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private lateinit var fragments : List<Fragment>

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    private val bottomAdapter by lazy { BottomAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        fragments = listOf(
            MainFragment(this),
            DetailsFragment(Data.data[0]),
            DetailsFragment(Data.data[1]),
            DetailsFragment(Data.data[2]),
            DetailsFragment(Data.data[3]),
            DetailsFragment(Data.data[4])
        )

        viewPagerAdapter = ViewPagerAdapter(this, fragments)

        with(binding){
            with(viewPager){
                adapter = viewPagerAdapter
                isUserInputEnabled = false
                offscreenPageLimit = 5

                registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        hideCustomNav(position == 0)
                    }
                })
            }

            with(bottonNav.recycler){
                layoutManager = GridLayoutManager(this@MainActivity, 5, GridLayoutManager.VERTICAL, false)
                adapter = bottomAdapter
            }
        }
    }

    private fun hideCustomNav(b: Boolean) {
        binding.frameLayout2.visibility = if(b) View.GONE else View.VISIBLE
    }

    override fun onItemCLick(position: Int) {
        binding.viewPager.currentItem = position
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onBackPressed() {
        if(binding.viewPager.currentItem > 0){
            binding.viewPager.setCurrentItem(0, false)
        }else AlertDialog.Builder(this)
            .setTitle("Exit Application?")
            .setMessage("Do you want to exit?")
            .setPositiveButton("Ok"){ _,_ -> super.onBackPressed() }
            .setNegativeButton("Cancel"){ d, _ -> d.dismiss()}
            .show()
    }
}