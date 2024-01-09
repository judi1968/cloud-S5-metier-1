package projetS5.cloud.projetCloud.Controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {
    @GetMapping("/")
    public Map initializer() {
		Map resultat = new HashMap();
		int status = 0;
		String titre = null;
		String message = null;
		Map data = new HashMap();
		Vector<String> donnes = new Vector<>();
		try {
            donnes.add("huhu");
            donnes.add("Salama");
            donnes.add("Bonjour");

			status = 200;
			titre = "Bienvenue sur VaikaNet";
			message = "Vous etes le bienvenue sur le projet";
		}catch (Exception e) {
			status = 500;
			titre = "Prendre des articles a echoue";
			message = e.getMessage();
		}finally {
			resultat.put("status",status);
			resultat.put("titre",titre);
			resultat.put("message",message);
			resultat.put("data",donnes);
			return resultat;
		}
	}
}
