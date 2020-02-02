package ru.catstack.lynlissaart.ui.main

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.main_fragment.*
import ru.catstack.lynlissaart.R
import ru.catstack.lynlissaart.adapters.ArtsRecyclerViewAdapter
import ru.catstack.lynlissaart.adapters.GridSpacingItemDecoration
import ru.catstack.lynlissaart.di.KodeinInstance


class MainFragment : Fragment() {
    private val viewModel: MainViewModel by KodeinInstance.instance()

    companion object {
        var saveView: View? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return saveView ?: inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (saveView != null)
            return
        saveView = view
        recyclerView.addItemDecoration(GridSpacingItemDecoration(2, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f, resources.displayMetrics).toInt()))

        viewModel.arts.observe(this) {
            recyclerView.adapter = ArtsRecyclerViewAdapter(it, this) { art ->
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToImageItemFragment(art))
                println(art.title)
            }
        }

        viewModel.state.observe(this) {
            setState(it)
        }

        retryButton.setOnClickListener {
            viewModel.loadImages()
        }

        viewModel.loadImages()
    }

    private fun setState(state: MainViewModel.MainState) {
        when (state) {
            MainViewModel.MainState.LOADING -> {
                setMainVisibility(false)
                setOnErrorVisibility(false)
                setLoadingVisibility(true)
            }
            MainViewModel.MainState.ERROR -> {
                setMainVisibility(false)
                setOnErrorVisibility(true)
                setLoadingVisibility(false)
            }
            MainViewModel.MainState.LOADED -> {
                setMainVisibility(true)
                setOnErrorVisibility(false)
                setLoadingVisibility(false)
            }
        }
    }

    private fun setMainVisibility(isVisible: Boolean) {
        val visibility = if (isVisible) View.VISIBLE else View.GONE
        recyclerView.visibility = visibility
    }

    private fun setLoadingVisibility(isVisible: Boolean) {
        val visibility = if (isVisible) View.VISIBLE else View.GONE
        loadingBar.visibility = visibility
    }

    private fun setOnErrorVisibility(isVisible: Boolean) {
        val visibility = if (isVisible) View.VISIBLE else View.GONE
        retryButton.visibility = visibility
        errorMessage.visibility = visibility
    }
}
