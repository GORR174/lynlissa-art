package ru.catstack.lynlissaart.ui.item.photoview

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.photo_view_fragment.*
import ru.catstack.lynlissaart.MainActivity
import ru.catstack.lynlissaart.R


class PhotoViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.photo_view_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        val url = PhotoViewFragmentArgs.fromBundle(arguments!!).imageUrl
        Glide.with(this).load(url).into(photoView)

        (activity as MainActivity).hideBar()
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as MainActivity).showBar()
    }
}
