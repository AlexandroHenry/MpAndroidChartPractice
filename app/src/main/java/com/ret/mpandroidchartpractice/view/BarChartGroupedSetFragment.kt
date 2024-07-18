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
import com.github.mikephil.charting.utils.ColorTemplate
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentBarChartGroupedSetBinding


class BarChartGroupedSetFragment : Fragment() {
    private var _binding: FragmentBarChartGroupedSetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBarChartGroupedSetBinding.inflate(inflater, container, false)

        val groupCount = 3
        val barWidth = 0.2f
        val barSpace = 0.05f
        val groupSpace = 0.3f

        val values1 = mutableListOf<BarEntry>()
        val values2 = mutableListOf<BarEntry>()
        val values3 = mutableListOf<BarEntry>()

        for (i in 0 until groupCount) {
            values1.add(BarEntry(i.toFloat(), (Math.random() * 100).toFloat()))
            values2.add(BarEntry(i.toFloat(), (Math.random() * 100).toFloat()))
            values3.add(BarEntry(i.toFloat(), (Math.random() * 100).toFloat()))
        }

        val barDataSet1 = BarDataSet(values1, "Set 1").apply { color = ColorTemplate.COLORFUL_COLORS[0] }
        val barDataSet2 = BarDataSet(values2, "Set 2").apply { color = ColorTemplate.COLORFUL_COLORS[1] }
        val barDataSet3 = BarDataSet(values3, "Set 3").apply { color = ColorTemplate.COLORFUL_COLORS[2] }

        val data = BarData(barDataSet1, barDataSet2, barDataSet3)
        data.barWidth = barWidth

        binding.barChartGrouped.apply {
            this.data = data
            groupBars(0f, groupSpace, barSpace)
            invalidate()

            description.isEnabled = false
            setDrawGridBackground(false)
            setFitBars(true)

            xAxis.apply {
                axisMinimum = 0f
                axisMaximum = (groupCount).toFloat()
                granularity = 1f
                setDrawGridLines(false)
            }

            axisLeft.apply {
                axisMinimum = 0f
            }

            axisRight.apply {
                axisMinimum = 0f
            }

            legend.isEnabled = true
        }

        return binding.root
    }
}