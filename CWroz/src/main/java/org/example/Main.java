public class Main {
    private double aktualnaTemperatura = 20.0; // Wartość początkowa temperatury
    private double ustawionaTemperatura = 22.0; // Wartość początkowa ustawionej temperatury
    private boolean ogrzewanieWlaczone = false;
    private boolean chlodzenieWlaczone = false;

    public void wlaczOgrzewanie() {
        ogrzewanieWlaczone = true;
        System.out.println("Ogrzewanie włączone.");
    }

    public void wlaczChlodzenie() {
        chlodzenieWlaczone = true;
        System.out.println("Chłodzenie włączone.");
    }

    public void wylaczOgrzewanie() {
        ogrzewanieWlaczone = false;
        System.out.println("Ogrzewanie wyłączone.");
    }
    public void wylaczChlodzenie() {
        chlodzenieWlaczone = false;
        System.out.println("Chłodzenie wyłączone.");
    }

    public void sprawdzTemperature() {
        if (aktualnaTemperatura < ustawionaTemperatura && !chlodzenieWlaczone) {
            wlaczOgrzewanie();
        } else if (aktualnaTemperatura > ustawionaTemperatura && !ogrzewanieWlaczone) {
            wlaczChlodzenie();
        } else if (aktualnaTemperatura == ustawionaTemperatura) {
            wylaczOgrzewanie();
            wylaczChlodzenie();
        }
    }

    public void symulujZmianeTemperatury() {
        while (true) {

            aktualnaTemperatura -= 0.5;
            System.out.println("Aktualna temperatura: " + aktualnaTemperatura + " stopni Celsjusza");
            sprawdzTemperature();
            try {
                Thread.sleep(1000); // Opóźnienie o 1 sekundę
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Main termostat = new Main();
        termostat.symulujZmianeTemperatury();
    }
}