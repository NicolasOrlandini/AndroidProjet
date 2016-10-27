package orlandini.jeu.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

import orlandini.jeu.MainActivity;
import orlandini.jeu.R;

import orlandini.jeu.GameCustomView;
import orlandini.jeu.RVAdapter;
import orlandini.jeu.ScoreDataBase;

import static orlandini.jeu.MainActivity.scoreDataBase;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeaderboardFragment extends Fragment {

    private TextView myscore;
    private ArrayList<String> score;
    private String myString;
    private RecyclerView rv;

    public LeaderboardFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_leaderboard, container, false);

        /*rv = (RecyclerView)myView.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        initializeAdapter();
        initializeData(); */

        /*for (Iterator<String> i = db.getAllScores().iterator(); i.hasNext();){
            String scoremescouilles = i.next();
            Log.v(scoremescouilles, "mon score");
        }*/

        myString = MainActivity.scoreDataBase.getTopScore();
        myscore = (TextView) myView.findViewById(R.id.myscore);
        myscore.setText(getString(R.string.score) + myString);

        return myView;
    }

    private void initializeData() {
        score = new ArrayList<>();
        for (Iterator<String> i = MainActivity.scoreDataBase.getAllScores().iterator(); i.hasNext(); ) {
            String scoremescouilles = i.next();
            score.add(scoremescouilles);
        }
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(score);
        rv.setAdapter(adapter);
    }

}