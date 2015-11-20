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
public class CardController {
  private List<Card> carduri = new ArrayList<Card>();

  CardController() {
    Card c1 = new Card(1, "VISA");
    Card c2 = new Card(2, "MasterCard");
    Card c3 = new Card(3, "Skrill");

    carduri.add(c1);
    carduri.add(c2);
    carduri.add(c3);
  }

  @RequestMapping(value="/card", method = RequestMethod.GET)
  public List<Card> index() {
    return this.carduri;
  }

  @RequestMapping(value="/card/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Card c : this.carduri) {
      if(c.getId() == id) {
        return new ResponseEntity<Card>(c, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/card/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Card c : this.carduri) {
      if(c.getId() == id) {
        this.carduri.remove(c);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/card", method = RequestMethod.POST)
  public ResponseEntity create(@RequestParam(value="name", defaultValue="card nou") String name) {
	Card newcard = new Card(this.carduri.size() + 1,String.format(name));
	carduri.add(newcard);
	String namecard = newcard.getname();
	for(Card c : this.carduri) {	
		if(c.getname().equals(namecard)) {
            return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.OK);
        }
	}
	return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }  
  
  @RequestMapping(value="/card/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id , 
                                @RequestParam(value="name", defaultValue="Updated Type") String newname) {
    for(Card c : this.carduri) {
      if(c.getId() == id) {
        c.setname(newname);
		return new ResponseEntity<Card>(c, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  } 
}
