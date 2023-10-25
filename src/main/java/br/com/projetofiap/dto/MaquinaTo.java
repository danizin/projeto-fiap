package br.com.projetofiap.dto;

public class MaquinaTo {

    private String modelo;
    private String numeroSerial;

    public MaquinaTo(String modelo, String numeroSerial) {
        this.modelo = modelo;
        this.numeroSerial = numeroSerial;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerial() {
        return numeroSerial;
    }

    public void setNumeroSerial(String numeroSerial) {
        this.numeroSerial = numeroSerial;
    }
}
