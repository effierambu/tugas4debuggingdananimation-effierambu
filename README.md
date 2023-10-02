# Tugas4DebuggingdanANimation

Buatlah dengan spesifikasi aplikasi  sebagai berikut :

## Kebutuhan non-fungsional :
1. Project harus menggunakan pertemuan sebelumnya yang tersedia pada github dengan path /PemrogramanAndroid/CLickRush (5  point)
2. Semua Commit log tugas ini harus dalam format "[Pertemuan 5] <`log title`>" (5 point)

## Kebutuhan fungsional :

1. Aplikasi memiliki Themes seperti berikut ini  (10 point)

![Alt Text](https://github.com/UKDW-PemrogAndroid/Tugas4DebuggingdanANimation/blob/main/samplelayout5.PNG)

2. Perbaiki bug saat permainan dirotasi dari vertikal ke horizontal (atau sebaliknya), yang menyebabkan permainan ter-reset sehingga permainan tidak dapat dilanjutkan saat sedang dimainkan. (40 point)
3. Jika tombol Tap Me ditekan, akan muncul animasi scaling dengan spesifikasi (10 point)

<scale
        android:duration="2000"
        android:fromXScale="2.0"
        android:fromYScale="2.0"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="1.0"
        android:toYScale="1.0" />
        
4. Permainan akan memiliki menu about dengan icon ic_menu_info_details, ber-title "About", dan parameter showAsAction="always".
bila menu about ditekan akan menampilkan dialog yang berisi informasi versi aplikasi dan pembuat aplikasi dengan format <NIM>-<Nama>. (30 point)

![Alt Text](https://github.com/UKDW-PemrogAndroid/Tugas4DebuggingdanANimation/blob/main/about.PNG)
