package com.example.jingbin.designpattern

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jingbin.designpattern.adapter.AdapterActivity
import com.example.jingbin.designpattern.bridge.BridgeActivity
import com.example.jingbin.designpattern.builder.BuilderActivity
import com.example.jingbin.designpattern.chainofresponsibility.ChainOfResponsibilityActivity
import com.example.jingbin.designpattern.command.CommandActivity
import com.example.jingbin.designpattern.composite.CompositeActivity
import com.example.jingbin.designpattern.databinding.ActivityMainBinding
import com.example.jingbin.designpattern.decorator.DecoratorActivity
import com.example.jingbin.designpattern.facade.FacadeActivity
import com.example.jingbin.designpattern.factory.FactoryActivity
import com.example.jingbin.designpattern.flyweight.FlyweightActivity
import com.example.jingbin.designpattern.interpreter.InterpreterActivity
import com.example.jingbin.designpattern.iterator.IteratorActivity
import com.example.jingbin.designpattern.mediator.MediatorActivity
import com.example.jingbin.designpattern.memento.MementoActivity
import com.example.jingbin.designpattern.observer.ObserverActivity
import com.example.jingbin.designpattern.prototype.PrototypeActivity
import com.example.jingbin.designpattern.proxy.ProxyActivity
import com.example.jingbin.designpattern.singleton.SingletonActivity
import com.example.jingbin.designpattern.state.StateActivity
import com.example.jingbin.designpattern.strategy.StrategyActivity
import com.example.jingbin.designpattern.templatemethod.TemplateMethodActivity
import com.example.jingbin.designpattern.visitor.VisitorActivity
import me.jingbin.library.ByRecyclerView
import me.jingbin.library.adapter.BaseByViewHolder
import me.jingbin.library.adapter.BaseRecyclerAdapter
import me.jingbin.library.decoration.GridSpaceItemDecoration
import java.util.Arrays

/**
 * Created by jingbin on 2016/10/21.
 */
class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val patterns = arrayOf<String?>(
        "观察者模式", "工厂模式",
        "单例设计模式", "策略模式",
        "适配器模式", "命令模式",
        "装饰者模式", "外观模式",
        "模板方法模式", "状态模式",
        "建造者模式", "原型模式",
        "享元模式", "代理模式",
        "桥接模式", "组合模式",
        "迭代器模式", "中介者模式",
        "备忘录模式", "解释器模式",
        "责任链模式", "访问者模式"
    )
    private val classes = arrayOf<Class<*>?>(
        ObserverActivity::class.java, FactoryActivity::class.java,
        SingletonActivity::class.java, StrategyActivity::class.java,
        AdapterActivity::class.java, CommandActivity::class.java,
        DecoratorActivity::class.java, FacadeActivity::class.java,
        TemplateMethodActivity::class.java, StateActivity::class.java,
        BuilderActivity::class.java, PrototypeActivity::class.java,
        FlyweightActivity::class.java, ProxyActivity::class.java,
        BridgeActivity::class.java, CompositeActivity::class.java,
        IteratorActivity::class.java, MediatorActivity::class.java,
        MementoActivity::class.java, InterpreterActivity::class.java,
        ChainOfResponsibilityActivity::class.java, VisitorActivity::class.java
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val gridLayoutManager = GridLayoutManager(this, 2)
        binding!!.recyclerView.setLayoutManager(gridLayoutManager)
        binding!!.recyclerView.addItemDecoration(GridSpaceItemDecoration(10).setEndFromSize(0))
        binding!!.recyclerView.setAdapter(object : BaseRecyclerAdapter<String?>(R.layout.item_main, Arrays.asList<String?>(*patterns)) {
            override fun bindView(holder: BaseByViewHolder<String?>?, bean: String?, position: Int) {
                holder?.setText(R.id.bt_button, title)
            }
        })
        binding!!.recyclerView.setOnItemClickListener(object : ByRecyclerView.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                startActivity(Intent(v.getContext(), classes[position]))
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.actionbar_about -> {
                val issuesUrl = Uri.parse("https://github.com/youlookwhat/DesignPattern")
                val intent = Intent(Intent.ACTION_VIEW, issuesUrl)
                startActivity(intent)
            }

            else -> {}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding!!.recyclerView.destroy()
    }
}
