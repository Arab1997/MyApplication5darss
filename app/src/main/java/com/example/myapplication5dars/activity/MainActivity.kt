package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.adapter.CustomAdapter
import com.example.myapplication.model.Member
import com.example.myapplication.model.MemberSubs
import com.example.myapplication5dars.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();


        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun initView() {
        recyclerView.layoutManager = GridLayoutManager(this, 1)

    }
    //refreshAdapter- har qanday malumotni yangilansa adapter refresh  qibergan
    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(this,members)
                recyclerView.adapter = adapter
    }


    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()

        for (i in 0..29) {
            if (i == 0 || i == 10) {
                members.add(Member("Makhmudov" + i, "Abdulloh" + i, prepareSubMemberList()))
            } else {
                members.add(Member("Makhmudov" + i, "Abdulloh" + i, ArrayList<MemberSubs>()))   // turi 2 xil bolganda
            }
        }
        return members
    }

    private fun prepareSubMemberList(): ArrayList<MemberSubs> {
        val members = ArrayList<MemberSubs>()

        for (i in 0..4) {
                members.add(MemberSubs("Offline"))
            }
        return members
        }
}
