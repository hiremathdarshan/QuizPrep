package com.example.darshan.quizprep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Darshan on 8/7/2016.
 */
public class CustomQuelist extends BaseAdapter {
    String [] que1,op11,op21,op31,op41,ans1;
    Context context;
    String [] imageId;
    private static LayoutInflater inflater=null;
    public CustomQuelist(ProfQuestionList mainActivity, String[] que, String[] op1,String[] op2,String[] op3,String[] op4,String[] ans) {
        // TODO Auto-generated constructor stub

        context=mainActivity;
        que1=que;
        op11=op1;
        op21=op2;
        op31=op3;
        op41=op4;
        ans1=ans;




        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return que1.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView question;
        TextView op1;
        TextView op2;
        TextView op3;
        TextView op4;
        EditText et;
        CheckBox b;


    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView,btn;
        rowView = inflater.inflate(R.layout.profquelist, null);


        holder.question=(TextView) rowView.findViewById(R.id.textView1);
        holder.op1=(TextView) rowView.findViewById(R.id.textView2);
        holder.op2=(TextView) rowView.findViewById(R.id.textView3);
        holder.op3=(TextView) rowView.findViewById(R.id.textView4);
        holder.op4=(TextView) rowView.findViewById(R.id.textView5);
        holder.et=(EditText) rowView.findViewById(R.id.et);
        holder.b=(CheckBox) rowView.findViewById(R.id.chk);


        holder.question.setText(que1[position]);
        holder.op1.setText(op11[position]);
        holder.op2.setText(op21[position]);
        holder.op3.setText(op31[position]);
        holder.op4.setText(op41[position]);
        holder.et.setText(ans1[position]);

     /* holder.b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked ", Toast.LENGTH_LONG).show();

               /* Intent I = new Intent(context, ViewQuizScore.class);
                context.startActivity(I);
            }
        });*/
        return rowView;
    }

}
