package ru.catstack.lynlissaart.ui.about

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.about_fragment.*
import ru.catstack.lynlissaart.R

class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.about_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        vkButton.setOnClickListener {
            openLink("https://vk.com/lynlissa_art")
        }

        instagramButton.setOnClickListener {
            openLink("https://www.instagram.com/lynlissa_art")
        }

        deviantartButton.setOnClickListener {
            openLink("https://www.deviantart.com/lynlissa")
        }

        twitterButton.setOnClickListener {
            openLink("https://twitter.com/Hurrrsky")
        }

        artstationButton.setOnClickListener {
            openLink("https://www.artstation.com/lynlissa")
        }
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
