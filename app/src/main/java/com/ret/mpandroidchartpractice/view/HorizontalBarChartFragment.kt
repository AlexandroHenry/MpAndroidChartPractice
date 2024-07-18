package com.ret.mpandroidchartpractice.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentHorizontalBarChartBinding

class HorizontalBarChartFragment : Fragment() {
    private var _binding: FragmentHorizontalBarChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHorizontalBarChartBinding.inflate(inflater, container, false)

        val entries = ArrayList<BarEntry>()
        for (i in 0 until 10) {
            entries.add(BarEntry(i.toFloat(), (Math.random() * 100).toFloat()))
        }

        val barDataSet = BarDataSet(entries, "Data Set")
        barDataSet.color = ContextCompat.getColor(requireContext(), R.color.blue)

        val data = BarData(barDataSet)
        binding.horizontalBarChart.data = data

        binding.horizontalBarChart.apply {
            description.text = "Horizontal Bar Chart"
            setFitBars(true)
            animateY(1500)
//            invalidate()
            animate()
        }

        return binding.root
    }
}