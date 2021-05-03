package hu.bme.aut.android.rocketlaunchtracker.ui.upcominglaunches

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.android.rocketlaunchtracker.R
import hu.bme.aut.android.rocketlaunchtracker.model.Launch
import kotlinx.android.synthetic.main.card_launch.view.*
import java.text.SimpleDateFormat

class LaunchAdapter constructor(
    private val context: Context,
    private val upcomingLaunchesPresenter: UpcomingLaunchesPresenter,
    private var launchList: List<Launch>) : RecyclerView.Adapter<LaunchAdapter.ViewHolder>() {

    private val dateFormat = SimpleDateFormat("MM/dd")
    private val timeFormat = SimpleDateFormat("h:mm")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_launch, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return launchList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val launch = launchList[position]

        holder.tvRocket.text = launch.rocket
        holder.tvMission.text = launch.mission
        holder.tvProvider.text = launch.serviceProvider
        holder.tvDate.text = if (launch.palnnedDate == null) "-" else dateFormat.format(launch.palnnedDate)
        holder.tvTime.text = if (launch.palnnedDate == null) "-" else timeFormat.format(launch.palnnedDate)
        holder.tvStatus.text = launch.status

        holder.cardView.setOnClickListener {
            upcomingLaunchesPresenter.onLaunchSelected(launch.id)
        }
    }

    inner class ViewHolder(launchView: View) : RecyclerView.ViewHolder(launchView) {
        val cardView = launchView.cardLaunch
        var tvRocket: TextView = launchView.tvRocket
        var tvMission: TextView = launchView.tvMission
        var tvProvider: TextView = launchView.tvProvider
        var tvDate: TextView = launchView.tvDate
        var tvTime: TextView = launchView.tvTime
        var tvStatus: TextView = launchView.tvStatus
    }

}