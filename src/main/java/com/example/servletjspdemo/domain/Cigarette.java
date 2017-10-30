package com.example.servletjspdemo.domain;

public class Cigarette {
	private int id = 0;
	private String Name = "";
	private double Price = 0.0;
	private int Count = 0;
	
	public Cigarette() {
		// TODO Auto-generated constructor stub
	}
	
	public Cigarette(int a, String b, double c, int d) {
		this.id = a;
		this.Name = b;
		this.Price = c;
		this.Count = d;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double Price) {
		this.Price = Price;
	}
	
	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}
	
	public void Dec() throws Exception {
		if (Count == 0) throw new Exception();
		else Count--;
	}

	@Override
	public String toString() {
		return ""+Name+"\t"+Price+"";
	}
	
	public String print() {
		return ""+id+"\t"+Name+"\t"+Price+"\t"+Count+"";
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cigarette cig = (Cigarette) o;

        if (Name != null ? !Name.equals(cig.Name) : cig.Name != null) return false;
        if (Price != cig.Price) return false;
        return Count != cig.Count;
    }

    @Override
    public int hashCode() {
        int result = Name != null ? Name.hashCode() : 0;
        result = 31 * result + (int) Price;
        return result;
}
}
