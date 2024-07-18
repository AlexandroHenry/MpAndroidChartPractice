package com.ret.mpandroidchartpractice.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentHomeBinding
import com.ret.mpandroidchartpractice.databinding.FragmentPieBinding

class PieFragment : Fragment() {
    private var _binding: FragmentPieBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPieBinding.inflate(inflater, container, false)

        val itemsRatio = listOf(
            PieEntry(25f),
            PieEntry(15f),
            PieEntry(35f),
            PieEntry(25f),
        )

        val pieColors = listOf(
            resources.getColor(R.color.red, null),
            resources.getColor(R.color.orange, null),
            resources.getColor(R.color.yellow, null),
            resources.getColor(R.color.green, null),
        )

        val dataSet = PieDataSet(itemsRatio, "chicken, beef, pork, seafood")

        dataSet.colors = pieColors
        dataSet.setDrawValues(false)

        binding.pieChart.apply {
            data = PieData(dataSet)

            description.isEnabled = false
            legend.isEnabled = true

            setTouchEnabled(true)
            // setTouchEnabled 이 false 면 isRotationEnabled 를 true 로 설정해도 작동안함
            isRotationEnabled = true
            
            // 가운데 hole 크기
            holeRadius = 30f
           
            
            // 차트가 등장할 때 애니메이션
            animateY(1200, Easing.EaseInOutCubic)

            // animate()를 호출하면 차트를 새로 고치기 위해 invalidate()를 호출할 필요가 없다.
            animate()
        }

        return binding.root
    }
}