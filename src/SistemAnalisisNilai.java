import java.util.Scanner;
import java.util.Locale; 

public class SistemAnalisisNilai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEM ANALISIS NILAI MAHASISWA ===");
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = scanner.nextInt();

        int[] nilai = new int[jumlahMahasiswa];
        int totalNilai = 0;
        int nilaiTertinggi = -1;  
        int nilaiTerendah = 101;  
        int jumlahLulus = 0;

        for (int i = 0; i < jumlahMahasiswa; i++) {
            while (true) {
                System.out.print("Masukkan nilai mahasiswa ke-" + (i + 1) + ": ");
                int inputNilai = scanner.nextInt();

                if (inputNilai >= 0 && inputNilai <= 100) {
                    nilai[i] = inputNilai;
                    totalNilai += inputNilai;

                    if (inputNilai > nilaiTertinggi) {
                        nilaiTertinggi = inputNilai;
                    }
                    if (inputNilai < nilaiTerendah) {
                        nilaiTerendah = inputNilai;
                    }
                    
                    if (inputNilai >= 75) {
                        jumlahLulus++;
                    }
                    break; 
                } else {
                    System.out.println("Nilai tidak valid! Masukkan antara 0-100.");
                }
            }
        }

        double rataRata = (double) totalNilai / jumlahMahasiswa;

        int diAtasRataRata = 0;
        for (int n : nilai) {
            if (n > rataRata) {
                diAtasRataRata++;
            }
        }

        System.out.println("\n--- HASIL ANALISIS ---");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            String status = (nilai[i] >= 75) ? "Lulus" : "Tidak Lulus";
            System.out.println("Mahasiswa " + (i + 1) + ": " + nilai[i] + " (" + status + ")");
        }

        System.out.println("----------------------");
        
        System.out.printf(Locale.US, "Nilai Rata-rata: %.2f\n", rataRata);
        
        System.out.println("Nilai Tertinggi: " + nilaiTertinggi);
        System.out.println("Nilai Terendah : " + nilaiTerendah);
        System.out.println("Jumlah Mahasiswa Lulus: " + jumlahLulus);
        System.out.println("Jumlah Mahasiswa di Atas Rata-rata: " + diAtasRataRata);
        System.out.println("=======================================");

        scanner.close();
    }
}