package eu.isdc.employeesMng.service;

import org.springframework.stereotype.Component;

@Component
public class UsersService {
	
	public String getUsers() {
		//users should not be retrieved as this, pleace change! 
		return "["
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"64\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Paul\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"spaniola\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"37\", \"language\":\"spaniola\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"34\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Paul\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Remus\", \"age\":\"22\", \"language\":\"spaniola\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Paul\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Remus\", \"age\":\"11\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"14\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Remus\", \"age\":\"35\", \"language\":\"spaniola\"},"
	    		+ "{\"name\":\"Ion\", \"age\":\"24\", \"language\":\"romana\"}, "
	    		+ "{\"name\":\"Maria\", \"age\":\"35\", \"language\":\"engleza\"}"
	    		+ "]";
		}
}
