package giang.tien.xstingiang.fragments

import androidx.recyclerview.widget.GridLayoutManager
import giang.tien.xstingiang.R
import giang.tien.xstingiang.base.BaseFragment
import giang.tien.xstingiang.binding.viewBinding
import giang.tien.xstingiang.data.DataModel
import giang.tien.xstingiang.databinding.FragmentDetailsBinding

class DetailsFragment(
    private val data: DataModel
): BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details) {

    override val binding: FragmentDetailsBinding by viewBinding(FragmentDetailsBinding::bind)

    private val ballAdapter by lazy { BallsAdapter() }

    override fun setupViews() {
        with(binding){
            menuTitle.text = data.title
            textContent.text = data.desc

            homeButton.setOnClickListener { requireActivity().onBackPressed() }

            with(balls.recycler){
                adapter = ballAdapter
                layoutManager = GridLayoutManager(requireContext(), 4, GridLayoutManager.VERTICAL, false)
            }
        }
    }

    override fun viewModelObservers() { }
}