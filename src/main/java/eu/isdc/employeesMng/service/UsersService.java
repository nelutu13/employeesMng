package eu.isdc.employeesMng.service;

import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	public String getUsers() {
		//users should not be retrieved as this, pleace change! 
		return "["
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Paul\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"spaniola\"}, "
	    		+ "{\"name\":\"Remus\", \"age\":\"37\", \"language\":\"spaniola\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"}"
	    		+ "]";
		}
}
