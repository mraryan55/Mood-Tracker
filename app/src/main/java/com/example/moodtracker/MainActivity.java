package com.example.moodtracker;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    Spinner moodSpinner;
    Button showThoughtsBtn;
    TextView thoughtsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moodSpinner = findViewById(R.id.moodSpinner);
        showThoughtsBtn = findViewById(R.id.showThoughtsBtn);
        thoughtsTextView = findViewById(R.id.thoughtsTextView);

        // Mood options Spinner ke liye
        String[] moods = {"Khush", "Udaas", "Thak gya hoon", "Romantic", "Tension mein"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, moods);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moodSpinner.setAdapter(adapter);

        // Button pe click karne par thoughts dikhao
        showThoughtsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedMood = moodSpinner.getSelectedItem().toString();
                String thoughts = getFunnyThoughts(selectedMood);
                thoughtsTextView.setText(thoughts);
                thoughtsTextView.setVisibility(View.VISIBLE);
            }
        });
    }

    // Mood ke hisaab se funny Hinglish thoughts return karega
    private String getFunnyThoughts(String mood) {
        switch (mood) {
            case "Khush":
                return "1. Zindagi mast hai jab phone charge ho aur data on ho!\n" +
                        "2. Khushi ka asli matlab - khana mil jaaye bina kisi ke pooche.\n" +
                        "3. Jab teacher bole, 'aaj koi homework nahi'... wo feeling priceless hoti hai.";

            case "Udaas":
                return "1. Mood kharab hai, par dikhana nahi hai kyunki recharge bhi nahi hai.\n" +
                        "2. Udaasi ka ilaaj sirf ek hi hai – mom ke haath ka khaana aur thoda Netflix.\n" +
                        "3. Main udaas hoon, par status pe nahi daalunga… log 'kya hua' poochhenge aur main rona nahi chahta.";

            case "Thak gya hoon":
                return "1. Aaj itna kaam kiya ki body ne khud bola – ‘Bhai rehne de’.\n" +
                        "2. Kaam se thak gaya hoon, ab sirf pillow aur neend chahiye.\n" +
                        "3. Ek din aisa bhi aayega… jahan alarm nahi bajega aur main fir bhi uthunga – Sapna hai bas.";

            case "Romantic":
                return "1. Tum mile to laga har pal beautiful hai… phir aankh khuli aur phone ka alarm baja.\n" +
                        "2. Love  aise karo jaise pizza ka last slice – dil se aur bina share kiye.\n" +
                        "3. Tere bina jee na paayein… par data pack khatam ho gaya toh kaise chalega?";

            case "Tension mein":
                return "1. Tension lene ka nahi, dene ka mere bhai.\n" +
                        "2. Exams aa rahe hain… lagta hai bhagwan bhi soch rahe – 'beta ab tu dekh'.\n" +
                        "3. Tension free rehne ka sabse best tareeka – sab kuch bhool jao aur so jao.";

            default:
                return "Aaj ka thought: Smile karo, tumse se bada joke duniya mein koi nahi!";
        }
    }
}