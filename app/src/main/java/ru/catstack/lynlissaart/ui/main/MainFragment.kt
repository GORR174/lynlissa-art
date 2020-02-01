package ru.catstack.lynlissaart.ui.main

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.main_fragment.*
import ru.catstack.lynlissaart.R
import ru.catstack.lynlissaart.adapters.ArtsRecyclerViewAdapter
import ru.catstack.lynlissaart.adapters.GridSpacingItemDecoration
import ru.catstack.lynlissaart.di.KodeinInstance
import ru.catstack.lynlissaart.domain.Art

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
        recyclerView.adapter = ArtsRecyclerViewAdapter(arrayListOf(
            Art("", "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/7b351c1a-730a-4786-a910-7bb786aa7117/ddp2ypk-60bf051e-8187-4c58-928e-a7efe93d0915.png/v1/fill/w_1102,h_725,q_70,strp/key_keeper_by_lynlissa_ddp2ypk-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9ODQzIiwicGF0aCI6IlwvZlwvN2IzNTFjMWEtNzMwYS00Nzg2LWE5MTAtN2JiNzg2YWE3MTE3XC9kZHAyeXBrLTYwYmYwNTFlLTgxODctNGM1OC05MjhlLWE3ZWZlOTNkMDkxNS5wbmciLCJ3aWR0aCI6Ijw9MTI4MCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.7Fn7oqODgKJZUop5qj5KKQTxFZ4MKRWTGdElr8fHSI0", ""),
            Art("", "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/7b351c1a-730a-4786-a910-7bb786aa7117/ddp2ygo-7443476a-1cf8-4bf5-9d7b-fc470fc51edd.png/v1/fill/w_1123,h_711,strp/wardrobe_of_young_squire_by_lynlissa_ddp2ygo-pre.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9ODExIiwicGF0aCI6IlwvZlwvN2IzNTFjMWEtNzMwYS00Nzg2LWE5MTAtN2JiNzg2YWE3MTE3XC9kZHAyeWdvLTc0NDM0NzZhLTFjZjgtNGJmNS05ZDdiLWZjNDcwZmM1MWVkZC5wbmciLCJ3aWR0aCI6Ijw9MTI4MCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.FfBJBUVhaRBV-GOxVIPZ5KqeyuuSuyFgtZPNUbIM1sg", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", ""),
            Art("", "", "")), this)
        viewModel.foo()
    }

}
