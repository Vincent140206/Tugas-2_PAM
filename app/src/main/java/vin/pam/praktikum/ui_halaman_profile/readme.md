# Tugas Compose UI Halaman Profil_D

Folder ini berisi implementasi halaman profil menggunakan Jetpack Compose sebagai bagian dari praktikum modul Activity Lifecycle, Composable, dan Modifier.

## Deskripsi

Halaman ini menampilkan informasi profil pengguna yang terdiri dari foto, nama, NIM, serta kontak seperti email dan nomor telepon. Tampilan dibuat menggunakan pendekatan declarative UI dari Jetpack Compose.

## Komponen yang Digunakan

Implementasi ini menggunakan beberapa komponen utama:

- **Column** → menyusun elemen secara vertikal
- **Row** → menyusun elemen secara horizontal
- **Box** → menumpuk elemen (overlay)
- **Spacer** → memberikan jarak antar komponen
- **Text** → menampilkan teks
- **Icon** → menampilkan ikon
- **Modifier** → mengatur ukuran, padding, background, dan styling

Gambar ditampilkan menggunakan `Image` dengan `painterResource`.

## Struktur File

- `ProfileScreen.kt` → Composable utama halaman profil

## Resource Gambar

Foto profil disimpan di dalam folder:
app/src/main/res/drawable/


Nama file:
- `foto_saya.jpg`

Link ke file gambar:
- https://github.com/Vincent140206/Tugas-2_PAM/blob/main/app/src/main/res/drawable/foto_saya.JPG

## Cara Menjalankan

1. Buka project di Android Studio
2. Jalankan aplikasi pada emulator atau device
3. Pastikan `ProfileScreen()` dipanggil di dalam `setContent` pada `MainActivity`
- https://github.com/Vincent140206/Tugas-2_PAM/blob/main/app/src/main/java/vin/pam/praktikum/MainActivity.kt

## Catatan

- File gambar harus menggunakan huruf kecil tanpa spasi
- Format yang didukung: PNG, JPG, atau WEBP
- Jetpack Compose digunakan untuk membangun UI tanpa XML  

<img width="1920" height="1080" alt="Screenshot (64)" src="https://github.com/user-attachments/assets/617b7c60-d3f8-4dff-8f05-0c1f4bbf5b68" />
<img width="419" height="916" alt="Screenshot 2026-09-08 132120" src="https://github.com/user-attachments/assets/e76f71c0-d859-411f-b2f6-736b0fcd7e56" />
