package ru.catstack.lynlissaart.ui.item

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.image_item_fragment.*
import ru.catstack.lynlissaart.R
import ru.catstack.lynlissaart.di.KodeinInstance


class ImageItemFragment : Fragment() {

    private val viewModel: ImageItemViewModel by KodeinInstance.instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.image_item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val art = ImageItemFragmentArgs.fromBundle(
            arguments!!
        ).artItem
        title.text = art.title
        Glide.with(this)
            .load(art.imageUrl)
            .addListener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    description.text = getString(R.string.loading_error)
                    description_title.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    if (art.description.isNotEmpty())
                        description_title.visibility = View.VISIBLE
                    else
                        description_title.visibility = View.GONE
                    description.text = art.description
                    return false
                }

            })
            .into(imageView)
    }

}
