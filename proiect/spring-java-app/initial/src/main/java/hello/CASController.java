package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;

@RestController
public class CASController {
  private List<CAS> institutie = new ArrayList<CAS>();

	CASController() {
    CAS cas1 = new  CAS(1, 1930619450019, 2015, "Udrea", "Ferentari Nr 2");
    CAS cas2 = new  CAS(2, 29234, 2015, "Siderache" , "Stefan Cel Mare Nr 60");
    CAS cas3 = new  CAS(3, 24434, 2015, "Bolboaca", "Grozavesti Nr 10");

    institutie.add(cas1);
    institutie.add(cas2);
    institutie.add(cas3);
  }

  @RequestMapping(value="/CAS", method = RequestMethod.GET)
  public List<CAS> index() {
    return this.institutie;
  }

  @RequestMapping(value="/CAS/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(CAS c : this.institutie) {
      if(c.getId() == id) {
        return new ResponseEntity<CAS>(c, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/CAS/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(CAS c : this.institutie) {
      if(c.getId() == id) {
        this.institutie.remove(c);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/CAS", method = RequestMethod.POST)
  public ResponseEntity create(@RequestParam(value="name", defaultValue="CAS") String name,
                               @RequestParam(value="address", defaultValue="adresa") String address,
                               @RequestParam(value="cnp", defaultValue="12345") int cnp,
                               @RequestParam(value="elib_card", defaultValue="0") int elib_card) {
	CAS newCAS = new CAS(this.institutie.size() + 1, cnp, elib_card, String.format(name), String.format(address));
	institutie.add(newCAS);
	String numeCAS = newCAS.getName();
	for(CAS c : this.institutie) {	
		if(c.getName().equals(numeCAS)) {
            return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.OK);
        }
	}
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }  
  
  @RequestMapping(value="/CAS/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id,
                               @RequestParam(value="name", defaultValue="Updated Name") String newName, 
                               @RequestParam(value="address", defaultValue="adresa") String address) {
    for(CAS c : this.institutie) {
      if(c.getId() == id) {
        c.setName(newName);
		c.setAddress(address);
		return new ResponseEntity<CAS>(c, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  } 
}