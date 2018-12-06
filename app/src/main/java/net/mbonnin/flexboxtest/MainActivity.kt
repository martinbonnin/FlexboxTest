package net.mbonnin.flexboxtest

import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexboxLayoutManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create a recyclerView but do not attach it to the window
        val recyclerView = RecyclerView(this)
        recyclerView.layoutManager =  FlexboxLayoutManager(this)
        recyclerView.adapter = object: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                return object: RecyclerView.ViewHolder(TextView(this@MainActivity)){}
            }

            override fun getItemCount(): Int {
                return 10000;
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                (holder.itemView as TextView).text = "position #$position"
            }

        }
        recyclerView.smoothScrollToPosition(500)
    }
}
