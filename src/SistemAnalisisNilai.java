//Link Github: https://github.com/yosafatjac/TugasPBO/tree/main/src

import java.util.Scanner;
import java.util.Locale;

public class SistemAnalisisNilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("=== SISTEM ANALISIS NILAI MAHASISWA ===\n");
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = input.nextInt();

        int[] nilaiMahasiswa = new int[jumlah];

        for (int i = 0; i < jumlah; i++) {
            System.out.print("Masukkan nilai mahasiswa ke-" + (i + 1) + ": ");
            int tempNilai = input.nextInt();

            if (tempNilai < 0 || tempNilai > 100) {
                System.out.println("Nilai tidak valid! Masukkan antara 0-100.");
                i--;
            } else {
                nilaiMahasiswa[i] = tempNilai;
            }
        }

        int totalNilai = 0;
        int nilaiTertinggi = nilaiMahasiswa[0];
        int nilaiTerendah = nilaiMahasiswa[0];
        int jumlahLulus = 0;

        for (int i = 0; i < jumlah; i++) {
            totalNilai += nilaiMahasiswa[i];

            if (nilaiMahasiswa[i] > nilaiTertinggi) {
                nilaiTertinggi = nilaiMahasiswa[i];
            }
            
            if (nilaiMahasiswa[i] < nilaiTerendah) {
                nilaiTerendah = nilaiMahasiswa[i];
            }

            if (nilaiMahasiswa[i] >= 75) {
                jumlahLulus++;
            }
        }

        double rataRata = (double) totalNilai / jumlah;

        int diAtasRataRata = 0;
        for (int i = 0; i < jumlah; i++) {
            if (nilaiMahasiswa[i] > rataRata) {
                diAtasRataRata++;
            }
        }

        System.out.println("\n--- HASIL ANALISIS ---");
        for (int i = 0; i < jumlah; i++) {
            String status = (nilaiMahasiswa[i] >= 75) ? "Lulus" : "Tidak Lulus";
            System.out.println("Mahasiswa " + (i + 1) + ": " + nilaiMahasiswa[i] + " (" + status + ")");
        }

        System.out.println("----------------------");
        System.out.printf(Locale.US, "Nilai Rata-rata: %.2f\n", rataRata);
        System.out.println("Nilai Tertinggi: " + nilaiTertinggi);
        System.out.println("Nilai Terendah : " + nilaiTerendah);
        System.out.println("Jumlah Mahasiswa Lulus: " + jumlahLulus);
        System.out.println("Jumlah Mahasiswa di Atas Rata-rata: " + diAtasRataRata);
        System.out.println("=======================================");
        
        input.close();
    }
}