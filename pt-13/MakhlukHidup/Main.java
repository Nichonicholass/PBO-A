abstract class MakhlukHidup {
    protected String nama;

    public MakhlukHidup(String nama) {
        this.nama = nama;
    }

    public abstract void bernafas();

    public abstract void berkembangBiak();

    public void makan() {
        System.out.println(nama + " sedang makan.");
    }
}

class Manusia extends MakhlukHidup {

    public Manusia(String nama) {
        super(nama);
    }

    @Override
    public void bernafas() {
        System.out.println(nama + " bernafas menggunakan paru-paru.");
    }

    @Override
    public void berkembangBiak() {
        System.out.println(nama + " berkembang biak secara melahirkan (vivipar).");
    }
}

class Hewan extends MakhlukHidup {

    public Hewan(String nama) {
        super(nama);
    }

    @Override
    public void bernafas() {
        System.out.println(nama + " bernafas menggunakan paru-paru atau insang.");
    }

    @Override
    public void berkembangBiak() {
        System.out.println(nama + " berkembang biak secara bertelur (ovipar) atau melahirkan (vivipar).");
    }
}

class Tumbuhan extends MakhlukHidup {

    public Tumbuhan(String nama) {
        super(nama);
    }

    @Override
    public void bernafas() {
        System.out.println(nama + " bernafas melalui stomata atau lentisel.");
    }

    @Override
    public void berkembangBiak() {
        System.out.println(nama + " berkembang biak melalui biji, tunas, atau cangkok.");
    }
}

public class Main {
    public static void main(String[] args) {
        MakhlukHidup manusia = new Manusia("Budi");
        manusia.bernafas();
        manusia.makan();
        manusia.berkembangBiak();

        MakhlukHidup hewan = new Hewan("Kucing");
        hewan.bernafas();
        hewan.makan();
        hewan.berkembangBiak();

        MakhlukHidup tumbuhan = new Tumbuhan("Mawar");
        tumbuhan.bernafas();
        tumbuhan.makan();
        tumbuhan.berkembangBiak();
    }
}
