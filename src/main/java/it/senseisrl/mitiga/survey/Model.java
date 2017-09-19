package it.senseisrl.mitiga.survey;

public class Model {
	private int id;
	private String nome;
	private boolean value = false;
	private int bankResidue;
	private int addMoney;
	

	public Model() {
	}

	public Model(int id, String nome, boolean value, int bankResidue, int addMoney) {
		this.id = id;
		this.nome = nome;
		this.value = value;
		this.bankResidue = bankResidue;
		this.addMoney = addMoney;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBankResidue() {
		return bankResidue;
	}

	public void setBankResidue(int bankResidue) {
		this.bankResidue = bankResidue;
	}

	public int getAddMoney() {
		return addMoney;
	}

	public void setAddMoney(int addMoney) {
		this.addMoney = addMoney;
	}
	
	public void addMoreMoney(int more) {
		if(value) {
			updateAcount();
		}
	}

	private void updateAcount() {
		bankResidue += addMoney;
	}
	
	
}
