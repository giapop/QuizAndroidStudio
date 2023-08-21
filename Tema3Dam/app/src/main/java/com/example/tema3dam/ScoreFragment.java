package com.example.tema3dam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ScoreFragment extends Fragment {
    public static final String SCORE_KEY = "SCORE_KEY";
    public static final String TOTAL_KEY = "TOTAL_KEY";
    private int score;
    private int total;
    private TextView txtScore;

    public ScoreFragment() {
        // Required empty public constructor
    }


    public static ScoreFragment newInstance(int scor,int total) {
        ScoreFragment fragment = new ScoreFragment();
        Bundle args = new Bundle();
        args.putInt(SCORE_KEY,scor);
        args.putInt(TOTAL_KEY,total);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            score=getArguments().getInt(SCORE_KEY);
            total=getArguments().getInt(TOTAL_KEY);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_score, container, false);
    txtScore=view.findViewById(R.id.popescu_georgiana_score_txtview_score);
    if(getArguments()!=null)
    {
        txtScore.setText(getString(R.string.total_score,score,total));
    }
    return view;
    }
}