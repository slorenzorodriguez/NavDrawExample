package com.dam2.navdrawexample.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dam2.navdrawexample.R

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    //Se llama cuando se crea por primera vez la interfaz.
    // A fin de diseñar una IU para el fragment, se debe  mostrar un View desde este método,
    // que será la raíz del diseño del fragment.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        galleryViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}