package com.ret.mpandroidchartpractice.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.CombinedData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentCombinedChartBinding


class CombinedChartFragment : Fragment() {

    private var _binding: FragmentCombinedChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCombinedChartBinding.inflate(inflater, container, false)

        setupCombinedChart()

        return binding.root
    }

    fun setupCombinedChart() {
        val lineEntries = ArrayList<Entry>()
        val barEntries = ArrayList<BarEntry>()

        for (i in 0 until 10) {
            lineEntries.add(Entry(i.toFloat(), (Math.random() * 100).toFloat()))
            barEntries.add(BarEntry(i.toFloat(), (Math.random() * 100).toFloat()))
        }

        val lineDataSet = LineDataSet(lineEntries, "Line Data").apply {
            color = ContextCompat.getColor(requireContext(), R.color.green)
            lineWidth = 2.5f
            circleRadius = 5f
            fillColor = ContextCompat.getColor(requireContext(), R.color.green)
            mode = LineDataSet.Mode.CUBIC_BEZIER
            setDrawValues(true)
        }

        val barDataSet = BarDataSet(barEntries, "Bar Data").apply {
            color = ContextCompat.getColor(requireContext(), R.color.red)
            valueTextSize = 10f
        }

        val lineData = LineData(lineDataSet)
        val barData = BarData(barDataSet)

        val combinedData = CombinedData().apply {
            setData(lineData)
            setData(barData)
        }

        binding.combinedChart.apply {
            data = combinedData
            description.text = "Combined Chart"

            setDrawGridBackground(true)
            setDrawBarShadow(false)
            isHighlightFullBarEnabled = false
            setPinchZoom(true)
            setDrawOrder(arrayOf(CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE))
            animateY(1500)
            animate()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

