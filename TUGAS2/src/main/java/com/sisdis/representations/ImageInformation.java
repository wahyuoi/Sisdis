package com.sisdis.representations;

/**
 * Created by wahyuoi on 9/30/15.
 */
public class ImageInformation {
    final String isi_berkas;
    final String lokasi_berkas;
    final String ukuran_berkas;

    public ImageInformation(String isi_berkas, String lokasi_berkas, String ukuran_berkas) {
        this.isi_berkas = isi_berkas;
        this.lokasi_berkas = lokasi_berkas;
        this.ukuran_berkas = ukuran_berkas;
    }

    public ImageInformation(){
        this(null, null, null);
    }

    public String getIsi_berkas() {
        return isi_berkas;
    }

    public String getLokasi_berkas() {
        return lokasi_berkas;
    }

    public String getUkuran_berkas() {
        return ukuran_berkas;
    }
}
