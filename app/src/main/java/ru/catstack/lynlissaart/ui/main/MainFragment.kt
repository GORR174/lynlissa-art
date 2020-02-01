package ru.catstack.lynlissaart.ui.main

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.main_fragment.*
import ru.catstack.lynlissaart.R
import ru.catstack.lynlissaart.adapters.ArtsRecyclerViewAdapter
import ru.catstack.lynlissaart.adapters.GridSpacingItemDecoration
import ru.catstack.lynlissaart.di.KodeinInstance

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by KodeinInstance.instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.addItemDecoration(GridSpacingItemDecoration(2, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f, resources.displayMetrics).toInt()))

        viewModel.arts.observe(this) {
            recyclerView.adapter = ArtsRecyclerViewAdapter(it, this)
        }

        viewModel.loadImages()
    }

}
