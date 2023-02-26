package com.example.testkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testkotlin.databinding.FragmentFirstBinding
import com.example.testkotlin.util.ThreadUtil
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var tipDialog: QMUITipDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        //进度对话框，等待
        /*ThreadUtil.runOnMain({
            _binding?.progressBarLl?.visibility = View.INVISIBLE },
            10000)*/
        tipDialog = QMUITipDialog.Builder(requireContext())
            .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
            .setTipWord("正在加载")
            .create()
        tipDialog?.show()
    }

    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }
}