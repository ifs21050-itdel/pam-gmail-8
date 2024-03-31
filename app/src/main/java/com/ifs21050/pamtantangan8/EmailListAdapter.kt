package com.ifs21050.pamtantangan8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ifs21050.pamtantangan8.R

class EmailListAdapter(
    private val emailList: List<Email>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<EmailListAdapter.EmailViewHolder>() {

    inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val textViewSubject: TextView = itemView.findViewById(R.id.textViewSubject)
        private val textViewSender: TextView = itemView.findViewById(R.id.textViewSender)
        private val textViewContent: TextView = itemView.findViewById(R.id.textViewContent)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                itemClickListener.onItemClick(emailList[position])
            }
        }

        fun bind(email: Email) {
            textViewSubject.text = email.subject
            textViewSender.text = email.sender
            textViewContent.text = email.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_list_item, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emailList[position]
        holder.bind(email)
    }

    override fun getItemCount(): Int {
        return emailList.size
    }

    interface OnItemClickListener {
        fun onItemClick(email: Email)
    }
}
