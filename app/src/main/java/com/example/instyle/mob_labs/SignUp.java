package com.example.instyle.mob_labs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText firstNameEditText, lastNameEditText, emailEditText;
    EditText phoneEditText, passwordEditText, passwordConfirmEditText;
    Button submitButton;

    String firstName, lastName, email;
    String phone, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        passwordConfirmEditText = findViewById(R.id.passwordConfirmEditText);
        submitButton = findViewById(R.id.submitButton);
    }

    public void submitData(View view) {
        firstName = firstNameEditText.getText().toString();
        lastName = lastNameEditText.getText().toString();
        email = emailEditText.getText().toString();
        phone = phoneEditText.getText().toString();
        password = passwordEditText.getText().toString();
        confirmPassword = passwordConfirmEditText.getText().toString();

        if (!Validations.isValidPassword(password) || !confirmPassword.equals(password) ||
                !Validations.isValidPhoneNumber(phone) || !Validations.isValidEmail(email) ||
                !Validations.isValidFirstName(firstName) || !Validations.isValidLastName(lastName))
        {
            if (!Validations.isValidFirstName(firstName)) {
                firstNameEditText.setError("Такого імя нема!");
            }
            if (!Validations.isValidLastName(lastName)){
                lastNameEditText.setError("Такого прізвища немає!");
            }
            if (!Validations.isValidPassword(password)) {
                passwordEditText.setError("Паролі повинні містити більше 8 символів!");
            }
            if (!confirmPassword.equals(password)) {
                passwordConfirmEditText.setError("Перевірте чи паролі співпадають");
            }
            if (!Validations.isValidPhoneNumber(phone)) {
                System.out.println(phone);
                phoneEditText.setError("Перевірте чи правильно введено телефон");
            }
            if (!Validations.isValidEmail(email)) {
                emailEditText.setError("Неправильний емейл");

            }

        }

    }

}
