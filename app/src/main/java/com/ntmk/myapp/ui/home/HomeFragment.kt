package com.ntmk.myapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ntmk.myapp.R
import com.ntmk.myapp.databinding.FragmentHomeBinding
import com.ntmk.myapp.ui.home.adapter.CategoriesAdapter
import com.ntmk.myapp.ui.home.adapter.ListCgrData
import com.ntmk.myapp.ui.home.adapter.ListHomeAdapter
import com.ntmk.myapp.ui.home.adapter.ListHomeData

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //    add data list
    private var Cgr_data = mutableListOf<ListCgrData>()
    private var lH_data = mutableListOf<ListHomeData>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//      add list
        postToListCgr()
        postToListHome()

//      RecycleView
        val rvCategoriesList : RecyclerView = binding.categories
        val rvHomeListItem : RecyclerView = binding.listProduct

//      Layout
        rvCategoriesList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvCategoriesList.adapter = CategoriesAdapter(Cgr_data)

        rvHomeListItem.layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
        rvHomeListItem.adapter = ListHomeAdapter(lH_data)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //    list categories horizontal
    private fun postToListCgr(){
        Cgr_data.add(ListCgrData("FRESH", R.drawable.woman))
        Cgr_data.add(ListCgrData("DRIED", R.drawable.man))
        Cgr_data.add(ListCgrData("ORNAMENT", R.drawable.teen))
        Cgr_data.add(ListCgrData("COINS", R.drawable.kid))

    }

    //    list item home
    private fun postToListHome(){
        lH_data.add(ListHomeData("Name Flower 1","$10",R.drawable.list_flower))
        lH_data.add(ListHomeData("Name Flower 2","$16",R.drawable.list_flower))
        lH_data.add(ListHomeData("Name Flower 3","$10",R.drawable.list_flower))
    }
}