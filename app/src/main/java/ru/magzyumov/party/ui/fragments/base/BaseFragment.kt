package ru.magzyumov.party.ui.fragments.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.magzyumov.party.ui.main.FragmentWorker


abstract class BaseFragment: Fragment() {

    abstract val layoutRes: Int
    protected lateinit var fragmentWorker: FragmentWorker

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentWorker) fragmentWorker = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes, container, false)
    }

}