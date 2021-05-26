
public class ProduitBeanModele {
	private int ID;
	private String reference;
	private FournisseurBeanModele id_fournisseur;
	private String designation;
	private int quantite_stock;
	private String emplacement;
	private MachineBeanModele id_machine;
	private String urgence;
	private double pump;
	private String etat_commande;
	private MembreBeanModele id_utilisateur;
	
	public ProduitBeanModele() {
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public FournisseurBeanModele getId_fournisseur() {
		return id_fournisseur;
	}
	public void setId_fournisseur(FournisseurBeanModele id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getQuantite_stock() {
		return quantite_stock;
	}
	public void setQuantite_stock(int quantite_stock) {
		this.quantite_stock = quantite_stock;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public MachineBeanModele getId_machine() {
		return id_machine;
	}
	public void setId_machine(MachineBeanModele id_machine) {
		this.id_machine = id_machine;
	}
	public String getUrgence() {
		return urgence;
	}
	public void setUrgence(String urgence) {
		this.urgence = urgence;
	}
	public double getPump() {
		return pump;
	}
	public void setPump(double pump) {
		this.pump = pump;
	}
	public String getEtat_commande() {
		return etat_commande;
	}
	public void setEtat_commande(String etat_commande) {
		this.etat_commande = etat_commande;
	}
	public MembreBeanModele getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(MembreBeanModele id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	

}
