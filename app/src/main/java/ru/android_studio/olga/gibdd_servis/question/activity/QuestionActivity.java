package ru.android_studio.olga.gibdd_servis.question.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.android_studio.olga.gibdd_servis.ActivityWithMenu;
import ru.android_studio.olga.gibdd_servis.R;

/**
 * Created by y.andreev on 03.06.2016.
 *
 * Прием обращений
 */
public class QuestionActivity  extends ActivityWithMenu implements View.OnClickListener {

    @BindView(R.id.btn_next)
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        ButterKnife.bind(this);

        addToolbarByIconId(R.mipmap.question_logo);
        setMenuConfig();

        nextBtn.setOnClickListener(this);
    }

    @Override
    protected int getCurrentMenuId() {
        return R.id.menu_question_btn;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next :
                Intent intent = new Intent(this, QuestionActivityNext.class);
                startActivity(intent);
                break;
        }
    }
}