package com.ret.mpandroidchartpractice.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
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

        val pieEntries = mutableListOf<PieEntry>()

        // Sample data for the pie chart
        var items = mapOf(
            "Category 1" to 40f,
            "Category 2" to 30f,
            "Category 3" to 20f,
            "Category 4" to 10f
        )

        items.forEach { (category, value) ->
            pieEntries.add(PieEntry(value, category))
        }

        val pieDataSet = PieDataSet(pieEntries, "Sample Pie Chart").apply {
            colors = ColorTemplate.COLORFUL_COLORS.toList()
            valueTextColor = Color.BLACK
            valueTextSize = 16f
        }

        val pieData = PieData(pieDataSet)

        binding.pieChart.apply {
            data = pieData
            description.isEnabled = false
            isRotationEnabled = true
            setEntryLabelColor(Color.BLACK)
            setEntryLabelTextSize(12f)
            setUsePercentValues(true)
            setDrawEntryLabels(true)
            setDrawHoleEnabled(true)
            holeRadius = 50f
            transparentCircleRadius = 55f
            setHoleColor(Color.WHITE)
            legend.isEnabled = true
            animateY(1400)
            invalidate()
        }

        return binding.root
    }
}