# Şifacı - Şifalı Bitkiler ve Sağlık Uygulaması

Şifacı, geleneksel tıp bilgilerini ve sağlık hesaplamalarını bir araya getiren kapsamlı bir Android uygulamasıdır. Uygulama, şifalı bitkiler, taşlar, çaylar, yağlar ve dualar hakkında bilgi saklama ve arama imkanı sunarken, aynı zamanda kişisel sağlık hesaplamaları da yapabilmektedir.

## 📖 Proje Hakkında

Bu proje, **Marmara Üniversitesi - Mobil Programlama Final Projesi** kapsamında geliştirilmiştir. Uygulamanın amacı, geleneksel şifa yöntemleri ile modern sağlık hesaplamalarını birleştirerek kullanıcılara kapsamlı bir sağlık platformu sunmaktır.

## 🛠️ Teknoloji Stack

- **Platform**: Android
- **Dil**: Java
- **Minimum SDK**: API 21 (Android 5.0)
- **Veritabanı**: SQLite
- **UI Framework**: Android Views
- **IDE**: Android Studio

## 📋 Ana Özellikler

### 🌿 Şifalı Bitkiler Modülü
- Şifalı bitkilerin isim ve açıklamalarını saklama
- Bitki arama ve filtreleme
- Yeni bitki bilgisi ekleme
- Detaylı bitki açıklamaları görüntüleme

### 💎 Şifalı Taşlar Modülü
- Değerli taşların şifa özellikleri
- Taş arama ve listeleme
- Yeni taş bilgisi ekleme
- Taşların etkileri hakkında detaylı bilgi

### 🍵 Şifalı Çaylar Modülü
- Şifalı çay tarifleri ve faydaları
- Çay türleri arama
- Yeni çay bilgisi ekleme
- Hazırlama talimatları

### 🫒 Şifalı Yağlar Modülü
- Doğal yağların şifa özellikleri
- Yağ türleri ve kullanım alanları
- Yeni yağ bilgisi ekleme
- Kullanım talimatları

### 🤲 Şifalı Dualar Modülü
- Manevi şifa duaları
- Dua metinleri ve açıklamaları
- Yeni dua ekleme
- Kategorize edilmiş dua koleksiyonu

### 📊 Sağlık Hesaplama Modülü
- **BMI Hesaplama**: Vücut kitle indeksi hesaplama ve değerlendirme
- **Bazal Metabolizma**: Günlük kalori ihtiyacı hesaplama
- **Yağ Oranı**: Vücut yağ yüzdesi hesaplama
- **Günlük Kalori**: Kalori ihtiyacı ve diyet önerileri

### 📱 Uygulama Özellikleri
- Kullanıcı dostu arayüz
- Hızlı arama ve filtreleme
- Yerel veritabanı desteği
- Bildirim sistemi
- Responsive tasarım

## 🏗️ Proje Yapısı

```
app/src/main/java/com/example/sifauygulamasi/
├── MainActivity.java              # Ana menü ve navigasyon
├── BitkilerActivity.java          # Şifalı bitkiler modülü
├── TaslarActivity.java            # Şifalı taşlar modülü
├── CaylarActivity.java            # Şifalı çaylar modülü
├── YaglarActivity.java            # Şifalı yağlar modülü
├── DualarActivity.java            # Şifalı dualar modülü
├── BMI_Activity.java              # BMI hesaplama
├── BazalActivity.java             # Bazal metabolizma hesaplama
├── YagOraniActivity.java          # Yağ oranı hesaplama
├── GunlukKaloriActivity.java      # Günlük kalori hesaplama
├── DatabaseHelper.java           # SQLite veritabanı yöneticisi
├── AddActivity.java              # Yeni veri ekleme
└── GosterActivity.java           # Detay görüntüleme
```

### Layout Dosyaları
```
app/src/main/res/layout/
├── activity_main.xml             # Ana menü tasarımı
├── activity_bitkiler.xml         # Bitkiler sayfası
├── activity_taslar.xml           # Taşlar sayfası
├── activity_caylar.xml           # Çaylar sayfası
├── activity_yaglar.xml           # Yağlar sayfası
├── activity_dualar.xml           # Dualar sayfası
├── activity_bmi.xml              # BMI hesaplama sayfası
├── activity_bazal.xml            # Bazal metabolizma sayfası
├── activity_yagorani.xml         # Yağ oranı sayfası
├── activity_kalori.xml           # Kalori hesaplama sayfası
├── activity_add.xml              # Veri ekleme sayfası
└── activity_goster.xml           # Detay görüntüleme sayfası
```

### Veritabanı Yapısı

Uygulama, SQLite veritabanı kullanarak beş ana kategori için veri saklar:

```sql
-- Şifalı Bitkiler Tablosu
CREATE TABLE Bitkiler (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Name TEXT,
    Description TEXT
);

-- Şifalı Taşlar Tablosu
CREATE TABLE Taslar (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Name TEXT,
    Description TEXT
);

-- Şifalı Çaylar Tablosu
CREATE TABLE Caylar (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Name TEXT,
    Description TEXT
);

-- Şifalı Yağlar Tablosu
CREATE TABLE Yaglar (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Name TEXT,
    Description TEXT
);

-- Şifalı Dualar Tablosu
CREATE TABLE Dualar (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Name TEXT,
    Description TEXT
);
```

## 🔧 Kurulum ve Çalıştırma

### Gereksinimler
- Android Studio 4.0 veya üzeri
- Java 8 veya üzeri
- Android SDK API 21 veya üzeri
- Minimum 4GB RAM
- 2GB boş disk alanı

### Kurulum Adımları

1. **Proje Klonlama:**
   ```bash
   git clone [repository-url]
   cd Sifali_Bitkiler
   ```

2. **Android Studio'da Açma:**
   - Android Studio'yu başlatın
   - "Open an existing Android Studio project" seçin
   - Proje klasörünü seçin

3. **Bağımlılıkları Yükleme:**
   - Gradle dosyaları otomatik olarak senkronize edilecektir
   - Eksik SDK bileşenleri varsa otomatik olarak indirilecektir

4. **Uygulamayı Çalıştırma:**
   - Android cihaz veya emülatör bağlayın
   - "Run" butonuna tıklayın veya `Shift + F10` tuş kombinasyonunu kullanın

### APK Oluşturma

```bash
# Debug APK oluşturma
./gradlew assembleDebug

# Release APK oluşturma (imzalı)
./gradlew assembleRelease
```

## 🎯 Kullanım Kılavuzu

### Ana Menü
Uygulama açıldığında karşınıza çıkan ana menüde 9 ana kategori bulunmaktadır:

1. **Şifalı Bitkiler** - Bitki bilgilerini görüntüle ve ekle
2. **Şifalı Taşlar** - Taş bilgilerini görüntüle ve ekle
3. **Şifalı Dualar** - Dua metinlerini görüntüle ve ekle
4. **Şifalı Yağlar** - Yağ bilgilerini görüntüle ve ekle
5. **Şifalı Çaylar** - Çay bilgilerini görüntüle ve ekle
6. **BMI Hesapla** - Vücut kitle indeksi hesaplama
7. **Bazal Metabolizma** - Günlük kalori ihtiyacı
8. **Yağ Oranı** - Vücut yağ yüzdesi
9. **Kalori Miktarı** - Günlük kalori hesaplama

### Veri Ekleme
Her kategoride yeni bilgi eklemek için:
1. İlgili kategoriyi seçin
2. "Veri Ekle" butonuna tıklayın
3. İsim ve açıklama alanlarını doldurun
4. "Kaydet" butonuna tıklayın

### Arama Yapma
Herhangi bir kategoride arama yapmak için:
1. Arama kutusuna aranacak kelimeyi yazın
2. "Ara" butonuna tıklayın
3. Sonuçlar listede görüntülenecektir

### BMI Hesaplama
1. Boy (cm) ve kilo (kg) bilgilerinizi girin
2. "Hesapla" butonuna tıklayın
3. BMI değeriniz ve sağlık durumunuz görüntülenecektir
4. Diyet önerileri otomatik olarak sunulacaktır

## 📱 Ekran Görüntüleri

<img>

### Ana Menü
Ana menü, modern ve kullanıcı dostu bir tasarıma sahiptir. Yeşil renk temasıyla doğallığı vurgulayan arayüz, 9 ana kategoriyi grid düzeninde sunar.

### Kategori Sayfaları
Her kategori sayfası aynı düzeni kullanır:
- Üst kısımda navigasyon butonları
- Ortada arama kutusu ve ara butonu
- Alt kısımda veri listesi
- Veri ekleme butonu

### Hesaplama Sayfaları
Sağlık hesaplama sayfaları:
- Temiz ve anlaşılır input alanları
- Büyük hesaplama butonları
- Detaylı sonuç görüntüleme
- Diyet önerileri (BMI için)
- Bildirim desteği

## 🔒 Güvenlik ve İzinler

Uygulama aşağıdaki izinleri kullanır:

```xml
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.VIBRATE" />
```

- **POST_NOTIFICATIONS**: BMI sonuçları için bildirim gönderme
- **RECEIVE_BOOT_COMPLETED**: Cihaz açılışında bildirim servisini başlatma
- **INTERNET**: Gelecekteki güncellemeler için (şu anda kullanılmıyor)
- **VIBRATE**: Bildirim titreşimi

## 🎨 Tasarım Özellikleri

- **Renk Paleti**: Yeşil (#4CAF50) ana renk, doğallığı simgeler
- **Tipografi**: Sistem fontu kullanımı, okunabilirlik öncelikli
- **Layout**: Grid ve list düzeni karışımı
- **Navigasyon**: Button tabanlı navigasyon sistemi
- **Responsive**: Farklı ekran boyutlarına uyumlu

## 🚀 Gelecek Geliştirmeler

- [ ] Favori sistem ekleme
- [ ] Görsel/resim desteği
- [ ] Sesli dua oynatma özelliği
- [ ] Çevrimdışı senkronizasyon
- [ ] Kullanıcı profili sistemi
- [ ] Sosyal paylaşım özellikleri
- [ ] Çoklu dil desteği
- [ ] Dark mode tema
- [ ] Widget desteği
- [ ] Backup/restore özelliği

## 🐛 Bilinen Sorunlar

- Büyük miktarda veri eklendikğinde liste performansı düşebilir
- Bazı eski Android sürümlerinde bildirim sorunu yaşanabilir
- Arama özelliği türkçe karakter hassasiyeti

## 📞 İletişim ve Destek

Bu proje Marmara Üniversitesi Mobile Programming dersi kapsamında geliştirilmiştir. Proje ile ilgili sorularınız için issue açabilir veya doğrudan iletişime geçebilirsiniz.

## 📄 Lisans

Bu proje eğitim amaçlı geliştirilmiştir ve MIT lisansı altında sunulmaktadır.