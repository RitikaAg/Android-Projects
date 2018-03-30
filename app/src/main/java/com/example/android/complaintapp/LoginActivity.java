package com.example.android.complaintapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
/**
 * A login screen that offers login via email/password.
 */
abstract class LoginActivity extends AppCompatActivity  implements  /*implements LoaderCallbacks<Cursor>*/

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    //new
        View.OnClickListener {


        public FirebaseAuth mAuth;

        /**
         * A dummy authentication store containing known user names and passwords.
         * TODO: remove after connecting to a real authentication system.
         */

        /**
         * Keep track of the login task to ensure we can cancel it if requested.
         */
        //private UserLoginTask mAuthTask = null;

        // UI references.
        private AutoCompleteTextView mEmailView;
        private String mEm;
        private EditText mPasswordView;
        private String mPas;
        private View mProgressView;
        private View mLoginFormView;


        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            //setupActionBar();
            // Set up the login form.
            mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
            mEm = mEmailView.getText().toString();
            //populateAutoComplete();

            mPasswordView = (EditText) findViewById(R.id.password);
            mPas = mPasswordView.getText().toString();
       /* mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });*/

// ...
            mAuth = FirebaseAuth.getInstance();
        }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    private void signIn(String email,String password){
        if (!validateForm()) {
            return;
        }
      mAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                // Sign in success, update UI with the signed-in user's information

                FirebaseUser user = mAuth.getCurrentUser();
                updateUI(user);
            } else {
                // If sign in fails, display a message to the user.
                //Log.w(TAG, "signInWithEmail:failure", task.getException());
                Toast.makeText(LoginActivity.this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show();
                updateUI(null);
            }
        }
        });
            }


            Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
         findViewById(R.id.email_sign_in_button).setOnClickListener(this);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mEm = mEmailView.getText().toString();
                mPas = mPasswordView.getText().toString();
                Intent Complaint = new Intent(LoginActivity.this, DispcomplaintsActivity.class);


                if((mEm.trim()).equals("r@gmail.com")&&(mPas.trim()).equals("123456"))// Start the new activity
                startActivity(Complaint);
                else
                    Toast.makeText(getApplicationContext(), "invalid email and password", Toast.LENGTH_SHORT).show();
            }
        });


    }


    }
        }


