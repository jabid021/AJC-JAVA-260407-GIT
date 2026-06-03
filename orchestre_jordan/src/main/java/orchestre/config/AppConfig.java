package orchestre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import orchestre.model.Flutiste;
import orchestre.model.Guitariste;
import orchestre.model.IInstrument;
import orchestre.model.IMusicien;
import orchestre.model.Pianiste;
import orchestre.model.Piano;

@Configuration
@ComponentScan("orchestre.model")
public class AppConfig {

	
	@Bean
    public IMusicien guitariste() 
    {
        Guitariste guitariste = new Guitariste();
        guitariste.setPrenom("Jordan");
        return guitariste ;
        
    }
    
	@Bean
	public Piano piano() 
	{
		return new Piano();
	}
	

    @Bean
    public IMusicien pianiste()
    {
    	Pianiste pianiste = new Pianiste();
    	pianiste.setPrenom("Eric");
    	pianiste.setInstrument(piano());
    	return pianiste;
    }
    
    
    //Bean du flutiste 
    @Bean
    public IMusicien musicien()
    {
    	Flutiste flutiste = new Flutiste();
    	flutiste.setPrenom("Olivier");
    	return flutiste;
    }
    
	
}
