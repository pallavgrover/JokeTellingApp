package e.pallavgrover.jokedisplay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class ViewJokeActivity extends AppCompatActivity {

    public static final String INTENT_JOKE = "intent:extra:joke";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_joke);

        TextView text = (TextView) findViewById(R.id.joke);
        text.setText(getIntent().getStringExtra(INTENT_JOKE));
    }
}