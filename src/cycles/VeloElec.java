package cycles;

public class VeloElec extends Velo{
	private static double DEFAUT_FACTEUR_PUISSANCE_MOTEUR = 15.0;
	private double facteurPuissanceMoteur;
	private double DEFAUT_COUPLE_MOTEUR = 15.0;

	public VeloElec(double braquet, double diamRoue, double coupleMoteur) {
		super(braquet,diamRoue);
		this.facteurPuissanceMoteur = coupleMoteur;
	}
	
	public VeloElec(double diamRoue, double coupleMoteur) {
		super(diamRoue);
		this.facteurPuissanceMoteur = coupleMoteur;
	}
	
	public VeloElec() {
		super();
		this.facteurPuissanceMoteur = DEFAUT_FACTEUR_PUISSANCE_MOTEUR;
	}
	
	public double getDEFAUT_COUPLE_MOTEUR() {
		return DEFAUT_COUPLE_MOTEUR;
	}
	
	public void setDEFAUT_COUPLE_MOTEUR(double DEFAUT_COUPLE_MOTEUR) {
		this.DEFAUT_COUPLE_MOTEUR = DEFAUT_COUPLE_MOTEUR;
	}
	
	public double getFacteurPuissanceMoteur() {
		return facteurPuissanceMoteur;
	}
	
	public void FacteurPuissanceMoteur(double coupleMoteur) {
		this.facteurPuissanceMoteur = coupleMoteur;
	}
	
	@Override
	public String toString() {
        return "VeloElec [facteurPuissanceMoteur=" + facteurPuissanceMoteur + "]";
    }
	
	@Override
	public double getPuissance(double FrequenceCoupDePedale) {
        return super.getPuissance(FrequenceCoupDePedale) * facteurPuissanceMoteur;
    }
	
	public static void main(String[] args) {
        Velo v1 = new Velo();
        Velo v2 = new Velo(16);
        Velo v3 = new Velo(18, 2.5);

        System.out.println("Test des constructeurs:");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        System.out.println("Test des getters et setters:");
        v1.setBraquet(14);
        v1.setDiamRoue(2.2);
        System.out.println(v1);

        System.out.println("Test de getPuissance:");
        System.out.printf("Puissance v3 (avec 90 tours/min) : %.2f\n", v3.getPuissance(90));
    }
}
