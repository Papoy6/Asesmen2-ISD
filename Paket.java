import java.util.PriorityQueue;

class Paket implements Comparable<Paket> {
    int idPaket;
    String namaPelanggan;
    String alamatPelanggan;
    int tanggalMasuk;
    String tipePengiriman;
    int prioritas;

    public Paket(int idPaket, String namaPelanggan, int tanggalMasuk, String tipePengiriman, String alamatPelanggan) {
        this.idPaket = idPaket;
        this.namaPelanggan = namaPelanggan;
        this.alamatPelanggan = alamatPelanggan;
        this.tanggalMasuk = tanggalMasuk;
        this.tipePengiriman = tipePengiriman.toLowerCase();
        this.setPrioritas();
    }

    private void setPrioritas() {
        switch (this.tipePengiriman) {
            case "same day":
                this.prioritas = this.tanggalMasuk;
                break;
            case "kilat":
                this.prioritas = this.tanggalMasuk + 1;
                break;
            case "express":
                this.prioritas = this.tanggalMasuk + 2;
                break;
            case "biasa":
                this.prioritas = this.tanggalMasuk + 3;
                break;
            default:
                this.prioritas = this.tanggalMasuk + 3;
        }
    }

    @Override
    public int compareTo(Paket other) {
        return Integer.compare(this.prioritas, other.prioritas);
    }

    @Override
    public String toString() {
        return "ID Paket: " + idPaket + " namaPelanggan: " + namaPelanggan + " alamatPelanggan: " + alamatPelanggan;
    }
}

class DaftarPaket {
    private PriorityQueue<Paket> queue;

    public DaftarPaket() {
        this.queue = new PriorityQueue<>();
    }

    public void terimaKiriman(int idPaket, String namaPelanggan, int tanggalMasuk, String tipePengiriman, String alamatPelanggan) {
        Paket paket = new Paket(idPaket, namaPelanggan, tanggalMasuk, tipePengiriman, alamatPelanggan);
        queue.add(paket);
    }

    public void cetakDataPaket() {
        System.out.println("Urutan paket harus diselesaikan:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
