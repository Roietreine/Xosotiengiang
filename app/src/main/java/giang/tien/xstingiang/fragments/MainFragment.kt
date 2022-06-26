package giang.tien.xstingiang.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import giang.tien.xstingiang.R
import giang.tien.xstingiang.base.BaseFragment
import giang.tien.xstingiang.binding.viewBinding
import giang.tien.xstingiang.databinding.FragmentMainBinding

class MainFragment(
    private val listener: OnItemClickListener
): BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    private val menuAdapter by lazy { MainAdapter(listener) }

    override fun setupViews() {
        with(binding.menuRecycler){
            adapter = menuAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun viewModelObservers() {
    }
}