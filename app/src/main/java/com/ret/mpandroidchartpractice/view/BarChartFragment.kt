package com.ret.mpandroidchartpractice.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentBarChartBinding
import com.ret.mpandroidchartpractice.databinding.FragmentHomeBinding

class BarChartFragment : Fragment() {
    private var _binding: FragmentBarChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBarChartBinding.inflate(inflater, container, false)

        // Zoom In / Out 가능 여부 설정
        binding.barChart.apply{
            setScaleEnabled(false)
            description.text = "득점"

            val valueList = ArrayList<BarEntry>()
            val title = "득점랭킹"

            for (i in 0 until 8) {
                valueList.add(BarEntry(i.toFloat(), (i * 100).toFloat()))
            }

            val barDataSet = BarDataSet(valueList, title)

            barDataSet.setColors(
                ContextCompat.getColor(requireContext(), R.color.black),
                ContextCompat.getColor(requireContext(), R.color.red),
                ContextCompat.getColor(requireContext(), R.color.orange),
                ContextCompat.getColor(requireContext(), R.color.yellow),
                ContextCompat.getColor(requireContext(), R.color.green),
                ContextCompat.getColor(requireContext(), R.color.blue),
                ContextCompat.getColor(requireContext(), R.color.navy),
                ContextCompat.getColor(requireContext(), R.color.purple),
            )

            val item = BarData(barDataSet)
            data = item

            animate()
        }




        return binding.root
    }
}