package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet_main.*
import kotlinx.android.synthetic.main.contenido_main.*
import android.support.design.widget.BottomSheetDialogFragment
import android.support.annotation.NonNull
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var bottomState = 0

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomSheet = bottomSheet as LinearLayout

        val bsb = BottomSheetBehavior.from(bottomSheet!!)

        btnExpBottomSheet!!.setOnClickListener {
            bsb.state = BottomSheetBehavior.STATE_EXPANDED
            bottomState = 1
            //bottomSheet.requestLayout();
        }

        btnConBottomSheet!!.setOnClickListener {
            bsb.state = BottomSheetBehavior.STATE_COLLAPSED
            bottomState = 1
            //bottomSheet.requestLayout();
        }

        btnOcuBottomSheet!!.setOnClickListener {
            bsb.state = BottomSheetBehavior.STATE_HIDDEN
            bottomState = 1
            //bottomSheet.requestLayout();
        }

        bottomSheet.setOnClickListener{
            if (bottomState == 1) {
                bsb.state = BottomSheetBehavior.STATE_COLLAPSED
                bottomState = 0
            } else {
                bsb.state = BottomSheetBehavior.STATE_EXPANDED
                bottomState = 1
            }


        }

        bsb.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

                var nuevoEstado = ""

                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> nuevoEstado = "STATE_COLLAPSED"
                    BottomSheetBehavior.STATE_EXPANDED -> nuevoEstado = "STATE_EXPANDED"
                    BottomSheetBehavior.STATE_HIDDEN -> nuevoEstado = "STATE_HIDDEN"
                    BottomSheetBehavior.STATE_DRAGGING -> nuevoEstado = "STATE_DRAGGING"
                    BottomSheetBehavior.STATE_SETTLING -> nuevoEstado = "STATE_SETTLING"
                }

                Log.i("BottomSheets", "Nuevo estado: $nuevoEstado")
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.i("BottomSheets", "Offset: $slideOffset")
            }
        })


    }
}
