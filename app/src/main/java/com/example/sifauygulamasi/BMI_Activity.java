package com.example.sifauygulamasi;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Calendar;
import java.util.Objects;

public class BMI_Activity extends AppCompatActivity {

    private EditText editTextHeight;
    private EditText editTextWeight;
    private Button buttonCalculateBMI;
    private TextView textViewResult;

    Button buttonBack;
    int myColor = Color.parseColor("#4CAF50");
    Calendar currentTime = Calendar.getInstance();
    int hour = currentTime.get(Calendar.HOUR_OF_DAY);
    String dietPlan = "";
    String zayif = "Sabah:\n\nKahvaltı:\nYulaf ezmesi veya tam buğdaylı gevrekler (süt veya yoğurt ile)\nTaze meyve (muz, çilek, elma gibi)\nBir dilim tam buğday ekmeği üzerine az yağlı peynir veya fıstık ezmesi\nYeşil çay veya siyah kahve (şeker ilavesiz)\n\nÖğle:\n\nÖğle Yemeği:\nIzgara tavuk veya somon\nTam buğdaylı pirinç veya bulgur pilavı\nÇiğ sebzelerle hazırlanmış salata (marul, roka, domates, salatalık)\nZeytinyağı ve limon suyu ile yapılmış hafif bir sos\n\nAra Öğün:\n\nİkindi Atıştırmalığı:\nBir avuç badem veya ceviz\nBiraz taze meyve veya bir küçük smoothie (süt veya yoğurt bazlı, şeker ilavesiz)\n\nAkşam:\n\nAkşam Yemeği:\nIzgara hindi göğsü veya ızgara sebzeler (patlıcan, kabak, biber)\nTam buğday makarna veya kepekli ekmek\nYoğurtlu cacık veya az yağlı yoğurt ile yapılmış soslu sebzeler\n\nİçecekler:\n\nGün boyunca yeterli su tüketimi önemlidir. En az 8-10 bardak su içmeye çalışın.\nYeşil çay veya siyah kahve (şeker ilavesiz) içmeyi tercih edin.\nHazır meyve sularından veya gazlı içeceklerden kaçının, çünkü bu içecekler genellikle ekstra şeker içerir.\n\nGenel İpuçları:\n\nPorsiyon kontrolü önemlidir. Her öğünde doyduğunuz noktada durun ve aşırı yemez.\nŞekerli ve işlenmiş gıdalardan kaçının.\nEgzersiz yapmaya çalışın. Haftada en az 3-4 kez düzenli egzersiz yapmak kilo verme sürecinizi hızlandırır.\nYeterince uyumaya özen gösterin. Yetersiz uyku, kilo vermeyi zorlaştırabilir.\nHer öğünde protein, kompleks karbonhidratlar ve sağlıklı yağlar içeren bir dengeli diyeti benimseyin.";
    String normal = "Sabah:\n\nKahvaltı:\nYulaf ezmesi veya tam buğdaylı gevrekler (süt veya yoğurt ile)\nTaze meyve (muz, çilek, kivi gibi)\nBir dilim tam buğday ekmeği üzerine az yağlı peynir veya avokado\nYeşil çay veya şekersiz bitki çayı\n\nÖğle:\n\nÖğle Yemeği:\nIzgara tavuk veya ızgara hindi göğsü\nTam buğdaylı ekmek veya kepekli makarna\nBol yeşillikli salata (marul, roka, ıspanak, rendelenmiş havuç)\nZeytinyağı ve limon suyu ile yapılmış hafif bir sos\n\nAra Öğün:\n\nİkindi Atıştırmalığı:\nBir avuç badem veya ceviz\nBiraz taze meyve veya bir küçük smoothie (süt veya yoğurt bazlı, şeker ilavesiz)\n\nAkşam:\n\nAkşam Yemeği:\nBuharda veya ızgarada pişmiş somon veya ton balığı\nBuğulama sebzeler (brokoli, kuşkonmaz, kabak)\nTam buğdaylı pirinç veya bulgur pilavı\nYoğurtlu cacık veya az yağlı yoğurt ile yapılmış soslu sebzeler\n\nİçecekler:\n\nBol su içmeye özen gösterin. Günde en az 8-10 bardak su içmeyi hedefleyin.\nYeşil çay veya bitki çayları içebilirsiniz.\nKafeinli içeceklerin tüketimine dikkat edin ve aşırıya kaçmayın.\n\nGenel İpuçları:\n\nPorsiyon kontrolü önemlidir. Her öğünde doyduğunuz noktada durun ve aşırı yemez.\nŞekerli ve işlenmiş gıdalardan kaçının.\nDüzenli olarak egzersiz yapmaya çalışın. Haftada en az 3-4 kez aerobik egzersizler ve güç antrenmanları yapmayı hedefleyin.\nSağlıklı yağları (zeytinyağı, avokado, fındık) tercih edin, ancak miktarını kontrol altında tutun.\nYeterince uyumaya özen gösterin. Yetersiz uyku, kilo kontrolünü zorlaştırabilir.";
    String kilolu = "Sabah:\n\nKahvaltı:\nYulaf ezmesi veya tam buğdaylı gevrekler (süt veya yoğurt ile)\nBir dilim tam buğday ekmeği üzerine az yağlı peynir veya fıstık ezmesi\nTaze meyve (elma, armut, çilek gibi)\nYeşil çay veya şekersiz bitki çayı\n\nÖğle:\n\nÖğle Yemeği:\nIzgara tavuk veya hindi göğsü\nTam buğday ekmeği ile yapılmış sandviç (az yağlı peynir, marul, domates)\nBol yeşillikli salata (marul, roka, rendelenmiş havuç)\nZeytinyağı ve limon suyu ile yapılmış hafif bir sos\n\nAra Öğün:\n\nİkindi Atıştırmalığı:\nBir avuç badem veya ceviz\nBiraz taze meyve veya bir küçük smoothie (süt veya yoğurt bazlı, şeker ilavesiz)\n\nAkşam:\n\nAkşam Yemeği:\nIzgara somon veya ton balığı\nBuğulama veya ızgara sebzeler (brokoli, kabak, biber)\nKepekli bulgur pilavı veya tam buğday makarna\nYoğurtlu cacık veya az yağlı yoğurt ile yapılmış soslu sebzeler\n\nİçecekler:\n\nGünde en az 8-10 bardak su içmeye özen gösterin.\nYeşil çay veya şekersiz bitki çayları tüketebilirsiniz.\nŞekerli içeceklerden kaçının ve meyve sularını sınırlayın.\n\nGenel İpuçları:\n\nPorsiyon kontrolü önemlidir. Her öğünde doyduğunuzda durun ve aşırıya kaçmayın.\nİşlenmiş gıdaların tüketimini azaltın ve doğal, tam gıdalara yönelin.\nDüzenli olarak egzersiz yapmaya çalışın. Haftada en az 3-4 kez aerobik egzersiz ve güç antrenmanları yapmayı hedefleyin.\nGünlük kalori alımınızı izleyin ve gerektiğinde ayarlamalar yapın.\nSağlıklı yağları (zeytinyağı, avokado, fındık) tercih edin, ancak miktarını kontrol altında tutun.\nYeterince uyumaya özen gösterin. Yetersiz uyku, kilo verme çabalarınızı etkileyebilir.";
    String obez = "Sabah:\n\nKahvaltı:\nYulaf ezmesi veya kepekli tahıl gevrekleri (süt veya yoğurt ile)\nBir dilim tam buğday ekmeği üzerine az yağlı peynir veya fıstık ezmesi\nBir porsiyon meyve (muz, elma, portakal gibi)\nYeşil çay veya şekersiz bitki çayı\n\nÖğle:\n\nÖğle Yemeği:\nIzgara tavuk veya hindi göğsü\nKepekli veya tam buğdaylı ekmek ile yapılmış sandviç (az yağlı peynir, marul, domates)\nBol yeşillikli salata (marul, roka, rendelenmiş havuç, salatalık)\nZeytinyağı ve limon suyu ile yapılmış hafif bir sos\n\nAra Öğün:\n\nİkindi Atıştırmalığı:\nBir avuç badem veya ceviz\nBiraz taze meyve veya sebzeler (havuç, salatalık, kırmızı biber gibi)\n\nAkşam:\n\nAkşam Yemeği:\nIzgara somon veya ızgara hindi göğsü\nBuğulama veya fırında pişirilmiş sebzeler (brokoli, kabak, patlıcan)\nKepekli bulgur pilavı veya tam buğday makarna\nYoğurtlu cacık veya az yağlı yoğurt ile yapılmış soslu sebzeler\n\nİçecekler:\n\nGünde en az 8-10 bardak su içmeye özen gösterin.\nYeşil çay veya şekersiz bitki çayları tüketebilirsiniz.\nŞekerli içeceklerden kaçının ve meyve sularını sınırlayın.\n\nGenel İpuçları:\n\nPorsiyon kontrolüne özen gösterin ve yavaş yemek yeme alışkanlığı edinin.\nFast food ve işlenmiş gıdalardan kaçının. Doğal ve tam gıdalara yönelin.\nDüzenli olarak egzersiz yapmaya çalışın. Haftada en az 4-5 gün hafiften orta düzeyde aerobik egzersiz ve güç antrenmanları yapmayı hedefleyin.\nKalori alımınızı izleyin ve gerektiğinde azaltın, ancak aşırıya kaçmayın.\nSağlıklı yağları (zeytinyağı, avokado, fındık) tercih edin ve kızartma gibi yağda derinlemesine pişirme yöntemlerinden kaçının.\nDüzenli olarak tıbbi kontrol ve takip yapın. Kilo kaybı sürecinde bir doktor veya beslenme uzmanından destek alın.\nBu program, aşırı kilolu insanlar için tasarlanmıştır.";

    NotificationManager notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        buttonCalculateBMI = findViewById(R.id.buttonCalculateBMI);
        textViewResult = findViewById(R.id.textViewResult);
        buttonBack = findViewById(R.id.btnBack);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Şifacı - BMI Hesaplama");

        buttonCalculateBMI.setTextColor(Color.WHITE);
        buttonCalculateBMI.setBackgroundColor(myColor);

        buttonBack.setTextColor(Color.WHITE);
        buttonBack.setBackgroundColor(myColor);

        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonCalculateBMI.setTextColor(myColor);
                buttonCalculateBMI.setBackgroundColor(Color.WHITE);
                calculateAndShowBMI();
                createNotification();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonBack.setTextColor(myColor);
                buttonBack.setBackgroundColor(Color.WHITE);
                buttonCalculateBMI.setTextColor(Color.WHITE);
                buttonCalculateBMI.setBackgroundColor(myColor);
                Intent intent = new Intent(BMI_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calculateAndShowBMI() {
        double height = Double.parseDouble(editTextHeight.getText().toString()) / 100; // Convert cm to meters
        double weight = Double.parseDouble(editTextWeight.getText().toString());

        double bmi = weight / (height * height);

        String result;

        if (bmi < 18.5) {
            result = "Zayıf";
            dietPlan = zayif;
        } else if (bmi < 25) {
            result = "Normal";
            dietPlan = normal;
        } else if (bmi < 30) {
            result = "Kilolu";
            dietPlan = kilolu;
        } else {
            result = "Obez";
            dietPlan =  obez;
        }

        // Alert Dialog oluşturma
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Diyet Planı")
                .setMessage(dietPlan)
                .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();

        textViewResult.setText("BMI: " + String.format("%.2f", bmi) + "\nDurum: " + result);
    }

    private void createNotification() {
        String channelID = "CHANNEL_ID_NOTIFICATION";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channelID);
        builder.setSmallIcon(R.drawable.ic_notifications);
        builder.setContentTitle("Başarılı!");
        builder.setContentText("Diyet planınız başarıyla oluşturuldu.");
        builder.setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(channelID);
            if (notificationChannel == null) {
                int importance = NotificationManager.IMPORTANCE_HIGH;
                notificationChannel = new NotificationChannel(channelID, "Bildirimler", importance);
                notificationChannel.setLightColor(Color.GREEN);
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        Log.d("Bildirim Oluşturuldu", "Bildirim başarıyla oluşturuldu.");
        notificationManager.notify(235, builder.build());
    }
}