package com.example.jingbin.designpattern.singleton

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.jingbin.designpattern.R
import com.example.jingbin.designpattern.app.AppConstant
import com.example.jingbin.designpattern.app.EMTagHandler
import com.example.jingbin.designpattern.databinding.ActivitySingletonBinding
import com.example.jingbin.designpattern.singleton.ehan.SingletonEHan
import com.example.jingbin.designpattern.singleton.enums.SingletonEnum
import com.example.jingbin.designpattern.singleton.inclass.SingletonIn
import com.example.jingbin.designpattern.singleton.lanhan.SingletonLanHan

class SingletonActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySingletonBinding>(this, R.layout.activity_singleton)
        setTitle("单例设计模式")

        binding.tvDefine.setText(EMTagHandler.fromHtml(AppConstant.SINGLETON_DEFINE))
        binding.btEhan.setOnClickListener(this)
        binding.btLanhan.setOnClickListener(this)
        binding.btInclass.setOnClickListener(this)
        binding.btEnum.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.getId()) {
            R.id.bt_ehan -> {
                val instance: SingletonEHan? = SingletonEHan.getInstance()
            }

            R.id.bt_lanhan -> {
                val singletonLanHanFour: SingletonLanHan? = SingletonLanHan.getSingletonLanHanFour()
            }

            R.id.bt_inclass -> {
                val singletonIn: SingletonIn? = SingletonIn.getSingletonIn()
            }

            R.id.bt_enum -> SingletonEnum.instance.whateverMethod()
            else -> {}
        }
    }
}
