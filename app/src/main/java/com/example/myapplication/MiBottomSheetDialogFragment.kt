package com.example.myapplication

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



public class MiBottomSheetDialogFragment : BottomSheetDialogFragment() {

    fun newInstance(): MiBottomSheetDialogFragment {
        return MiBottomSheetDialogFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.bs_dialog_fragment, container, false)


        return v
    }
}