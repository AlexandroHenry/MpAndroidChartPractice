package com.ret.mpandroidchartpractice.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.CombinedData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentCombinedChartBinding
import com.ret.mpandroidchartpractice.databinding.FragmentHorizontalBarChartBinding

class CombinedChartFragment : Fragment() {

    private var _binding: FragmentCombinedChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCombinedChartBinding.inflate(inflater, container, false)

        val lineEntries = ArrayList<Entry>()
        val barEntries = ArrayList<BarEntry>()
        for (i in 0 until 10) {
            lineEntries.add(Entry(i.toFloat(), (Math.random() * 100).toFloat()))
            barEntries.add(BarEntry(i.toFloat(), (Math.random() * 100).toFloat()))
        }

        val lineDataSet = LineDataSet(lineEntries, "Line Data")
        lineDataSet.color = ContextCompat.getColor(requireContext(), R.color.green)

        val barDataSet = BarDataSet(barEntries, "Bar Data")
        barDataSet.color = ContextCompat.getColor(requireContext(), R.color.red)

        val lineData = LineData(lineDataSet)
        val barData = BarData(barDataSet)

        val combinedData = CombinedData()
        combinedData.setData(lineData)
        combinedData.setData(barData)

        binding.combinedChart.data = combinedData

        binding.combinedChart.apply {
            description.text = "Combined Chart"
            animateY(1500)
            invalidate()
        }

        return binding.root
    }
}