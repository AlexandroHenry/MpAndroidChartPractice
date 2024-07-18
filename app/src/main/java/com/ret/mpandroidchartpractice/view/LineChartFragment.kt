package com.ret.mpandroidchartpractice.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentLineChartBinding
import com.ret.mpandroidchartpractice.viewmodel.LineChartViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class LineChartFragment : Fragment() {

    private var _binding: FragmentLineChartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: LineChartViewModel by viewModels()

    private val dataList = arrayListOf(
        70800.0, 70900.0, 71000.0, 71200.0, 71200.0, 70900.0,
        71000.0, 70900.0, 71100.0, 71000.0, 71200.0, 71300.0,
        71500.0, 71600.0, 71200.0, 70900.0, 70800.0, 70700.0,
        70800.0, 71000.0
    )

    private val dataList2 = arrayListOf(
        70800.0, 70700.0, 70600.0, 70500.0, 70400.0, 70300.0,
        70200.0, 70100.0, 70000.0, 69900.0, 69800.0, 69700.0,
        69600.0, 69500.0, 69400.0, 69300.0, 69200.0, 69100.0,
        69000.0, 68900.0
    )

    private val dataList3 = arrayListOf(
        30100.0, 42000.0, 43000.0, 50000.0, 52000.0, 68000.0,
        70200.0, 70100.0, 90250.0, 100000.0, 123500.0, 105033.0,
        150000.0, 180050.0, 200500.0, 210000.0, 230000.0, 200000.0,
        250000.0, 350000.0
    )


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLineChartBinding.inflate(inflater, container, false)

        with(binding) {
            chart1.apply {
                val entryList = arrayListOf<Entry>()
                val entryList2 = arrayListOf<Entry>()
                val entryList3 = arrayListOf<Entry>()

                // 터치한 부분의 값을 얻어내기 (aim 중심 값)
                setOnChartValueSelectedListener(
                    object : OnChartValueSelectedListener {
                        override fun onValueSelected(e: Entry?, h: Highlight?) {
                            e?.let {
//                                viewModel.setPrice(e.y.toInt().toString())
                                binding.currentDataValue.text = e.y.toInt().toString()
//                                _priceLiveData.value = e.y.toInt().toString()
                            }
                        }

                        override fun onNothingSelected() {

                        }
                    }
                )

                // 손을 땠을 경우 해당 좌표점 에 표시된 aim 이 사라짐
                setOnTouchListener { view, motionEvent ->
                    if (motionEvent.action == MotionEvent.ACTION_UP) {
                        highlightValue(null)
                    }
                    false
                }

                dataList.forEachIndexed { index, d ->
                    entryList.add(Entry(index.toFloat(), d.toFloat()))
                }

                dataList2.forEachIndexed { index, d ->
                    entryList2.add(Entry(index.toFloat(), d.toFloat()))
                }

                dataList3.forEachIndexed { index, d ->
                    entryList3.add(Entry(index.toFloat(), d.toFloat()))
                }

                // data -> line chart legend
                val lineDataSet = LineDataSet(entryList, "data").apply {
                    // 원 크기 설정 - 선이 끊어지지 않는 것처럼 보이기 위해 선 두께에 맞춰서 설정

                    // 하단 우측 description
                    description.text = "data1"

                    // 좌표점 크기
                    circleRadius = 6.0F
                    
                    // 좌표점 내부 (테두리를 제외한 크기)
                    circleHoleRadius = 3.0F

                    // 좌표점 테두리
                    setCircleColor(ContextCompat.getColor(requireContext(), R.color.red))

                    // 좌표점 내부
                    circleHoleColor = ContextCompat.getColor(requireContext(), R.color.black)
                    
                    // 좌표 값 텍스트 크기
                    valueTextSize = 22.0F
                    
                    // 텍스트 색상
                    valueTextColor = ContextCompat.getColor(requireContext(), R.color.black)

                    // 선 두께
                    lineWidth = 2.0F

                    // 선 색상
                    color = ContextCompat.getColor(requireContext(), R.color.green)
                }


                val lineDataSet2 = LineDataSet(entryList2, "Data Set 2").apply {
                    description.text = "data2"
                    circleRadius = 6.0F
                    circleHoleRadius = 3.0F
                    setCircleColor(ContextCompat.getColor(requireContext(), R.color.blue))
                    circleHoleColor = ContextCompat.getColor(requireContext(), R.color.yellow)
                    valueTextSize = 22.0F
                    valueTextColor = ContextCompat.getColor(requireContext(), R.color.black)
                    lineWidth = 2.0F
                    color = ContextCompat.getColor(requireContext(), R.color.blue)
                }

                val lineDataSet3 = LineDataSet(entryList3, "Data Set 3").apply {
                    description.text = "data3"
                    circleRadius = 6.0F
                    circleHoleRadius = 3.0F
                    setCircleColor(ContextCompat.getColor(requireContext(), R.color.blue))
                    circleHoleColor = ContextCompat.getColor(requireContext(), R.color.yellow)
                    valueTextSize = 22.0F
                    valueTextColor = ContextCompat.getColor(requireContext(), R.color.black)
                    lineWidth = 2.0F
                    color = ContextCompat.getColor(requireContext(), R.color.blue)
                }

                data = LineData(listOf(lineDataSet, lineDataSet2, lineDataSet3))


                setScaleEnabled(true)
                setPinchZoom(true)
                
                // 드래그 기능
                isDragEnabled = true
                
                invalidate()
            }
        }

//        viewModel.priceLiveData.observe(viewLifecycleOwner, Observer {
//            binding.currentDataValue.text = it
//        })

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}