package hello;

import java.util.List;
import java.util.ArrayList;

public class CAS{
  
  private long int id;
  private int cnp;
  private int elib_card;
  private String name;
  private String address;


  public CAS() {}

  public CAS(int id, long int cnp, int elib_card, String name, String address) {
      this.name = name;
      this.id = id;
      this.address = address;
      this.cnp = cnp;
      this.elib_card = elib_card;
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.id;
  }

  public int getCnp() {
    return this.cnp;
  }
  
  public int getElib_card() {
    return this.elib_card;
  }

  public String getAddress() {
     return this.address;
  }
  
  public void setName(String name) {
	this.name = name;
  }
  
  public void setAddress(String address) {
	this.address = address;
  }
}
