package com.example.jingbin.designpattern.command

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.jingbin.designpattern.R
import com.example.jingbin.designpattern.app.AppConstant
import com.example.jingbin.designpattern.app.EMTagHandler
import com.example.jingbin.designpattern.databinding.ActivityCommandBinding

/**
 * 命令模式:
 * 定义：将"请求"封装成对象，以便使用不同的请求、队列或者日志来参数化其他对象。命令模式也支持可撤销的操作。
 * 简化: 将请求封装成对象，将动作请求者和动作执行者解耦。
 * 命令模式的核心就是把命令封装成类，对于命令执行者不需要知道现在执行的具体是什么命令。
 *
 *
 * 假设现在有电视、电脑、电灯等家电，现在需要你做个遥控器控制所有家电的开关，
 * 要求做到每个按钮对应的功能供用户个性化，对于新买入家电要有非常强的扩展性。
 */
class CommandActivity : AppCompatActivity(), View.OnClickListener {
    private var controlPanel: ControlPanel? = null
    private var binding: ActivityCommandBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityCommandBinding>(this, R.layout.activity_command)
        setTitle("命令模式")

        binding!!.tvDefine.setText(EMTagHandler.fromHtml(AppConstant.COMMAND_DEFINE))
        setCommands()
        initListener()
    }

    private fun initListener() {
        binding!!.btZero.setOnClickListener(this)
        binding!!.btOne.setOnClickListener(this)
        binding!!.btTwo.setOnClickListener(this)
        binding!!.btThree.setOnClickListener(this)
        binding!!.btFour.setOnClickListener(this)
        binding!!.btFive.setOnClickListener(this)
        binding!!.btSix.setOnClickListener(this)
        binding!!.btSeven.setOnClickListener(this)
        binding!!.btNo.setOnClickListener(this)
    }

    private fun setCommands() {
        /**
         * 三个家电
         */
        val door = Door()
        val light = Light()
        val computer = Computer()

        /**
         * 一个控制器,假设是我们的APP界面
         */
        controlPanel = ControlPanel()
        controlPanel!!.setCommands(0, DoorOpenCommand(door)) // 开门
        controlPanel!!.setCommands(3, DoorCloseCommand(door)) // 关门
        controlPanel!!.setCommands(1, LightOnCommand(light)) // 开灯
        controlPanel!!.setCommands(4, LightOffCommand(light)) // 关灯
        controlPanel!!.setCommands(2, ComputerOnCommand(computer)) // 开电脑
        controlPanel!!.setCommands(5, ComputerOffCommand(computer)) // 关电脑

        //        controlPanel.keyPressed(8);//这个没有设置命令,但不会出问题,因为我们的NoCommand的功劳
        val quickOpenCommand = QuickCommand(arrayOf<Command>(LightOnCommand(light), ComputerOnCommand(computer), DoorOpenCommand(door)))
        val quickCloseCommand = QuickCommand(arrayOf<Command>(LightOffCommand(light), ComputerOffCommand(computer), DoorCloseCommand(door)))
        controlPanel!!.setCommands(6, quickOpenCommand)
        controlPanel!!.setCommands(7, quickCloseCommand)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.bt_zero -> controlPanel!!.keyPressed(0)
            R.id.bt_one -> controlPanel!!.keyPressed(1)
            R.id.bt_two -> controlPanel!!.keyPressed(2)
            R.id.bt_three -> controlPanel!!.keyPressed(3)
            R.id.bt_four -> controlPanel!!.keyPressed(4)
            R.id.bt_five -> controlPanel!!.keyPressed(5)
            R.id.bt_six -> controlPanel!!.keyPressed(6)
            R.id.bt_seven -> controlPanel!!.keyPressed(7)
            R.id.bt_no -> controlPanel!!.keyPressed(8)
            R.id.bt_command -> {}
            else -> {}
        }
    }
}
