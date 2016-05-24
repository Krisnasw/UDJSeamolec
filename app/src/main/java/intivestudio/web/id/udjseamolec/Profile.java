package intivestudio.web.id.udjseamolec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class Profile extends AppCompatActivity {

    private TextView txtName;
    private TextView txtEmail;
    private ImageView btnLogout;
    private ImageView btnSoal;
    private ImageView btStatistik;

    private SQLiteHandler db;
    private SessionManager session;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        txtName = (TextView) findViewById(R.id.tv1);
        txtEmail = (TextView) findViewById(R.id.tv2);
        btnLogout = (ImageView) findViewById(R.id.btnLogout);
        btnSoal = (ImageView) findViewById(R.id.btSoal);
        btStatistik = (ImageView) findViewById(R.id.btStatistik);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("User Profile");

        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        // Fetching user details from SQLite
        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        String email = user.get("email");

        // Displaying the user details on the screen
        txtName.setText("Nama Lengkap : " +name);
        txtEmail.setText("Kelas : " +email);

        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

        btnSoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q = new Intent(Profile.this, QuizActivity.class);
                startActivity(q);
            }
        });

        btStatistik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goblok = new Intent(Profile.this, Score.class);
                startActivity(goblok);
            }
        });
    }

    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */
    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(Profile.this, Login.class);
        finish();
        startActivity(intent);
    }
}