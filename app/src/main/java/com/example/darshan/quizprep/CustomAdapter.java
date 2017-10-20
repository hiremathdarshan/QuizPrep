package com.example.darshan.quizprep;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Darshan on 8/5/2016.
 */
public class CustomAdapter extends BaseAdapter {
    String [] question,option1,option2,option3,option4,answer;
    Context context;
    String [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(TakeSelectedQuiz mainActivity, String[] que, String[] op1,String[] op2,String[] op3,String[] op4,String[] ans) {
        // TODO Auto-generated constructor stub

        context=mainActivity;
        question=que;
        option1=op1;
        option2=op2;
        option3=op3;
        option4=op4;
        answer=ans;

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return question.length;
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
        TextView que;

        RadioGroup rg;
        RadioButton op1;
        RadioButton op2;
        RadioButton op3;
        RadioButton op4;

        Button b;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView,btn;
        rowView = inflater.inflate(R.layout.program_list, null);
        btn = inflater.inflate(R.layout.activity_take_selected_quiz, null);

        holder.que=(TextView) rowView.findViewById(R.id.textView1);
        holder.rg=(RadioGroup) rowView.findViewById(R.id.rg);
        holder.op1=(RadioButton) rowView.findViewById(R.id.radio1);
        holder.op2=(RadioButton) rowView.findViewById(R.id.radio2);
        holder.op3=(RadioButton) rowView.findViewById(R.id.radio3);
        holder.op4=(RadioButton) rowView.findViewById(R.id.radio4);
        // holder.b=(Button) btn.findViewById(R.id.btn);

        holder.que.setText(question[position]);
        holder.op1.setText(option1[position]);
        holder.op2.setText(option2[position]);
        holder.op3.setText(option3[position]);
        holder.op4.setText(option4[position]);


       /* rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Toast.makeText(context, "You Clicked ", Toast.LENGTH_LONG).show();

                Intent I = new Intent(context, ViewQuizScore.class);
                context.startActivity(I);
            }
        });*/
        return rowView;
    }

}