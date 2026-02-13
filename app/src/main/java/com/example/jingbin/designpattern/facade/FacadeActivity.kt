package com.example.jingbin.designpattern.facade

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.jingbin.designpattern.R
import com.example.jingbin.designpattern.app.AppConstant
import com.example.jingbin.designpattern.app.EMTagHandler
import com.example.jingbin.designpattern.databinding.ActivityFacadeBinding
import com.example.jingbin.designpattern.facade.device.Computer
import com.example.jingbin.designpattern.facade.device.Light
import com.example.jingbin.designpattern.facade.device.Player
import com.example.jingbin.designpattern.facade.device.PopcornPopper
import com.example.jingbin.designpattern.facade.device.Projector
import com.example.jingbin.designpattern.facade.theater.HomeTheaterFacade

/**
 * 外观模式:
 * 定义：提供一个统一的接口，用来访问子系统中的一群接口，外观定义了一个高层的接口，让子系统更容易使用。
 * 其实就是为了方便客户的使用，把一群操作，封装成一个方法。
 * 举个例子：
 * 我比较喜欢看电影，于是买了投影仪、电脑、音响、设计了房间的灯光、买了爆米花机，然后我想看电影的时候，我需要：
 * 1、打开爆米花机
 * 2、制作爆米花
 * 3、将灯光调暗
 * 4、打开投影仪
 * 5、放下投影仪投影区
 * 6、打开电脑
 * 7、打开播放器
 * 8、将播放器音调设为环绕立体声
 * ...
 * 尼玛，花了一笔钱，看电影还要这么多的步骤，太累了，而且看完还要一个一个关掉。
 * 所有，我们使用外观模式解决这些复杂的步骤，轻松享受电影：
 */
class FacadeActivity : AppCompatActivity(), View.OnClickListener {
    private var homeTheaterFacade: HomeTheaterFacade? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityFacadeBinding>(this, R.layout.activity_facade)
        setTitle("外观模式")
        binding.tvDefine.setText(EMTagHandler.fromHtml(AppConstant.FACADE_DEFINE))

        binding.btFacade.setOnClickListener(this)
        binding.btOpen.setOnClickListener(this)
        binding.btClose.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.getId()) {
            R.id.bt_facade -> {
                val computer = Computer()
                val light = Light()
                val player = Player()
                val popcornPopper = PopcornPopper()
                val projector = Projector()
                homeTheaterFacade = HomeTheaterFacade(computer, light, player, popcornPopper, projector)
            }

            R.id.bt_open -> if (homeTheaterFacade != null) {
                homeTheaterFacade!!.watchMovie()
            }

            R.id.bt_close -> if (homeTheaterFacade != null) {
                homeTheaterFacade!!.stopMovie()
            }

            else -> {}
        }
    }
}
