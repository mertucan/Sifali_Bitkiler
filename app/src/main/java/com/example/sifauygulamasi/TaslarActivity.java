package com.example.sifauygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class TaslarActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button buttonBitkiler;
    Button buttonTaslar;
    Button buttonDualar;
    Button buttonYaglar;
    Button buttonCaylar;
    Button buttonanaSayfa;
    Button buttonEkle;
    Button buttonTemizle;
    ListView plantList;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    int myColor = Color.parseColor("#4CAF50");

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taslar);

        db = new DatabaseHelper(this);
        plantList = findViewById(R.id.listView);
        listItem = new ArrayList<>();

        buttonBitkiler = findViewById(R.id.buttonBitkiler);
        buttonTaslar = findViewById(R.id.buttonTaslar);
        buttonDualar = findViewById(R.id.buttonDualar);
        buttonYaglar = findViewById(R.id.buttonYaglar);
        buttonCaylar = findViewById(R.id.buttonCaylar);
        buttonanaSayfa = findViewById(R.id.buttonAnaSayfa);
        buttonEkle = findViewById(R.id.buttonEkle);
        buttonTemizle = findViewById(R.id.buttonTemizle);

        viewData();

        setButtonSelected(buttonTaslar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Şifacı - Taşlar");
        buttonBitkiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonBitkiler);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), BitkilerActivity.class);
                startActivity(intent);
            }
        });

        buttonTaslar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonTaslar);

                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);
                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), TaslarActivity.class);
                startActivity(intent);
            }
        });

        buttonDualar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonDualar);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), DualarActivity.class);
                startActivity(intent);
            }
        });

        buttonYaglar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonYaglar);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), YaglarActivity.class);
                startActivity(intent);
            }
        });

        buttonCaylar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonCaylar);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), CaylarActivity.class);
                startActivity(intent);

            }
        });

        buttonanaSayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonanaSayfa);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        buttonEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonEkle);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);
                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);

                db.insertData("Agate", "Kalkedon. Kırmızı, portakal, sarı, kahverengi tonlarında. Som. Öğütülebilir. Mide, bağırsak, karaciğer, dalak, böbrekler ve radyasyon hastalıklarında etkili. Kalp üzerine takıldığında kan şekeri, iştahsızlık ve lenfler üzerinde etkin. Duyguları dengeleyici, sinir dengeleyici, yaralanma ve yanma olaylarında sonra çabuk iyileştirici, beyin enerjisini dengeliyici. Mavi desenlisi, sabrı ve barış duygularını arttırır, sakinleştirir. H-CTR.", "Taslar");
                db.insertData("Amber", "Açık sarı veya portakal. İlk Çağ´dan kalan taşlaşmış reçine oluşumu. Elektromanyetik. Solar Plexus şakrasını açar, ruhsal dengeyi, zihin açıklığını, güveni sağlar. Mide gerilimlerini, omurgayı, merkezi sinir sistemini, bellek kayıplarını, hücre yenilenmelerini düzenler. Sarı ve portakal renkli amberler, zihinsel ve duygusal uyumu sağlarlar. Amber özellikle, radyasyonun, x ışınlarının, güneşin, bilgisayarların, uçakların ve diğer aygıtların yaydığı enerjilerin zararlarını azaltır. Eski çağlarda kızılderililer ve Asyalılar tarafından kullanılırdı. Amber tesbihlerin gerilimleri giderdiği gözlemlenmiştir. H-T", "Taslar");
                db.insertData("Ametist", "Yarı şeffaf, mor/levanta renklerinde. Fiziksel, imajinatif ve düşünsel dengeleyici. Uykuda veya uyanıldığında takılırsa, öfkeyi, sabırsızlığı ve kabusları engeller. Başağrıları, gözler, saç dökülmesi, kilo kaybı, kan şekeri dengesi üzerinde etkilidir. Hıçkırığın, alkolün, aşırı yemeğin zararlarını azaltır. İyi bir panzehirdir (özellikle alkole karşı). Ev hayvanlarının suyunun içine konulursa pireleri kaçırır. H-CTR", "Taslar");
                db.insertData("Aquamarin", "Beril türü. Açık parlak mavi, mavi-yeşil renklerde. Sakinleştirici, güçlendirici; zihin açıcı; yaratıcılığı, ilişkilerin kolaylaşmasını, güven duygusunun artmasını sağlar. Gırtlak, tiroid, dalak (CTR), bağışıklık sistemi, timus, lenfler üzerinde yararlı etkiler oluşturur. Korkuları, huzursuzlukları, panik atakları yatıştırır, azaltır. Allerjik solunum rahatsızlıklarını yumuşatır. Eski çağlarda su yolculuklarında koruyucu olarak kabul edilirdi. H-CTR\n", "Taslar");
                db.insertData("Azurite", "Koyu mavi, mavi-mor. Alın ve boğaz üzerinde aktiftir ama aşırıya kaçılmadan. Ayrıca bilinçaltını sakinleştirdiği iddia edilmektedir. Fiziksel güç sağlar, yaratıcılığı, kararlılığı, anlayışı, gerçekleri görmeyi geliştirir. Hücrelerin normaldışı davranışlarını dengeler. Tiroid, sinüsler, cilt sağlığı, dalak, sinir sistemi üzerinde olumlu etkiler yaratır. H-CTR-T\n", "Taslar");
                db.insertData("Bakır", "Mükemmel enerji yöneticisi. Düşünce gücünü ve sağlığı güçlendirir, taşıyanın enerji alanına katkıda bulunur. Cilde temas ettirildiğinde, yatıştırıcıdır. Artrit, romatizma gibi yoğun enerji düğümlerini çözer. Bağırsaklara ve mideye yararlıdır. Sıcak duygular verir, öfkeyi, alınganlığı azaltır. Güneş ve Ay enerjilerini dengeler. H-CTR-T\n", "Taslar");
            }
        });
        buttonTemizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonTemizle);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);
                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);

                db.deleteAllData("Taslar");

            }
        });
    }

    private void setButtonSelected(Button button) {
        button.setTextColor(myColor);
        button.setBackgroundColor(Color.WHITE);
    }

    private void viewData(){
        Cursor cursor = db.viewData("Taslar");

        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data to show.", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                listItem.add(cursor.getString(1));
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            plantList.setAdapter(adapter);
        }
    }
}